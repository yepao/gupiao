package ddq.job;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import ddq.Service.*;
import ddq.model.*;

/**
 * Hello world!
 *
 */

public class App 
{

	static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	static String path=App.class.getClass().getResource("/")+"applicationContext.xml";  
	static ApplicationContext context = new FileSystemXmlApplicationContext(path);
	
	public static void main( String[] args ) throws Exception
	{

		Log4jConfigurer.initLogging(App.class.getClass().getResource("/")+"/log4j.xml");
		long oneDay = 24 * 60 * 60 * 1000;  

		//A股收盘
		long AinitDelay  = getTimeMillis("16:00:00") - System.currentTimeMillis();  
		AinitDelay = AinitDelay > 0 ? AinitDelay : oneDay + AinitDelay;  

		//港股收盘
		long hkinitDelay  = getTimeMillis("17:00:00") - System.currentTimeMillis();  
		hkinitDelay = hkinitDelay > 0 ? hkinitDelay : oneDay + hkinitDelay;

		//美股收盘
		long usinitDelay  = getTimeMillis("05:00:00") - System.currentTimeMillis();  
		usinitDelay = usinitDelay > 0 ? usinitDelay : oneDay + usinitDelay;

		//计算利息
		long calcinitDelay  = getTimeMillis("00:00:00") - System.currentTimeMillis();  
		calcinitDelay = calcinitDelay > 0 ? calcinitDelay : oneDay + calcinitDelay;

		
		//计算收益
		long initDelay  = getTimeMillis("20:00:00") - System.currentTimeMillis();  
		initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

		Runnable Arunnable = new Runnable() {  
			public void run() { 
				try{

				    //System.out.println(context.toString());
					StockService stock= (StockService)context.getBean("stockService");
					SysService sysService=(SysService)context.getBean("sysService");
					
					if(stock.IsMarketClose(new Date())==0)
					{
						System.out.println("IsMarketClose:0");
						return;
					}
					//写入用户日志
					UserLog userlog=new UserLog();
					userlog.setIp("127.0.0.1");
					userlog.setOperation("addProfit");
					userlog.setTime(new Date());
					userlog.setUid(0);
					userlog.setRemark("test");
					sysService.addUserLog(userlog);
					
					//取所有的股票代码
					String stockids=stock.getStockIds();
					
					Map stockdata=new HashMap();
					//分段取实时数据
					String[] stockid=stockids.split(",");
					String stockidtemp="";
					for(int i=0,j=0;i<stockid.length;i++)
					{
						stockidtemp=stockidtemp+","+stockid[i];
						j++;
						if(j==50)
						{
							//取实时数据
							stockdata=stock.getStockData(stockidtemp);
							j=0;
							stockidtemp="";
						}
					}
					
					//取实时数据
					stockdata=stock.getStockData(stockidtemp);
					
					Map map=new HashMap();
					
					//组装实时价格
					Iterator entries = stockdata.entrySet().iterator(); 
					while (entries.hasNext()) {  
						Map.Entry entry = (Map.Entry) entries.next();  
					    String key = (String)entry.getKey();  
					    StockPrice value = (StockPrice)entry.getValue();  
					    if(value==null)
					    {
					    	continue;
					    }
					    double dqjg=Double.parseDouble(value.getDqjg());
					    if(dqjg==0)
					    {
					    	dqjg=Double.parseDouble(value.getZrspj());
					    }
					   
					    //System.out.println("Key = " + key + ", Value = " + value);  
					    map.put(key.replace("us", "").toLowerCase(),dqjg);
					} 
					
					//得到实时汇率
					map=stock.getExChangeRate(map);
					
					//定时执行
					int ok=stock.addProfit_job(map, new Date());
					
					System.out.println(sdf.format(new Date())+"path:"+stockids+",ok:"+ok);  
				}catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}  
		};
		
		Runnable calcrunnable=new Runnable() {  
			public void run() { 
				try{
					
					SysService sysService=(SysService)context.getBean("sysService");
					DebtService debtService=(DebtService)context.getBean("debtService");
					
					//写入用户日志
					UserLog userlog=new UserLog();
					userlog.setIp("127.0.0.1");
					userlog.setOperation("addCalc");
					userlog.setTime(new Date());
					userlog.setUid(0);
					userlog.setRemark("test");
					sysService.addUserLog(userlog);
					
					int ok=debtService.addCalc();
					
					System.out.println(sdf.format(new Date())+",ok:"+ok);  
				}catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		};

		System.out.println(context);
		//第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
		service.scheduleAtFixedRate(Arunnable,initDelay,oneDay, TimeUnit.MILLISECONDS);
		service.scheduleAtFixedRate(calcrunnable,calcinitDelay,oneDay, TimeUnit.MILLISECONDS);
	}

	/** 
	 * 获取指定jar包的相对路径
	 * @param time "HH:mm:ss" 
	 * @return 
	 */ 
	public static String getProjectPath() {
		java.net.URL url = App.class.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;
		try {
			filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filePath.endsWith(".jar"))
			filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		java.io.File file = new java.io.File(filePath);
		filePath = file.getAbsolutePath();
		return filePath;
	}

	/** 
	 * 获取指定时间对应的毫秒数 
	 * @param time "HH:mm:ss" 
	 * @return 
	 */  
	private static long getTimeMillis(String time) {  
		try {  
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");  
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
			return curDate.getTime();  
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  
		return 0;  
	}

}
