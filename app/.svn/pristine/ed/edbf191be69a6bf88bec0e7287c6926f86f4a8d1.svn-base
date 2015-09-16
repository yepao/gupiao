package app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import ddq.Dao.*;
import ddq.Service.Cn2Spell;
import ddq.Service.DebtService;
import ddq.Service.HttpUtil;
import ddq.Service.StockService;
import ddq.model.Global;
import ddq.model.Stock;


@Controller  
@RequestMapping("/test")  
public class HelloWorldController  {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private DebtService debtService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockService stockService;

	@SuppressWarnings("deprecation")
	@RequestMapping(value="/hello",method = RequestMethod.GET)  
	public @ResponseBody String printWelcome(ModelMap model) throws Exception { 
		logger.debug("TEST");
		System.out.println("gg");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		System.out.println(req.getParameter("id"));

		double v1=20060;
		double v2=30.86;


		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -7);
		Gson gg=new Gson();
		String result=HttpUtil.sendGet("http://www.baidu.com/","q=sh600399,sh603018,usNKE,usNK,hk00686,hk00222");
		/*String result=HttpUtil.sendGet("http://qt.gtimg.cn/", "q=sh600399,sh603018,usNKE,usNK,hk00686,usNK,hk00222");*/
		//System.out.println(result);

		String result3="";
		String[] temp1=result.split(";");
		System.out.println(temp1.length);
		for(int i=0;i<temp1.length;i++)
		{
			String result2="";
			String[] temp= temp1[i].split("~");
			for(int j=0;j<temp.length;j++)
			{
				result2=result2+",{"+j+"-->"+temp[j]+"}";
			}
			//System.out.println(temp.substring(temp.indexOf("\"")+1,temp.lastIndexOf("\"")));
			//System.out.println(temp.substring(temp.lastIndexOf("_")+1,temp.lastIndexOf("=")));
			result3=result3+"【"+i+"<-->"+result2+"】"+"    P@#%$#%@@#$     ";
		}
		try{
			//int i=7/0;
		}
		catch(Exception e)
		{
			System.out.println(Global.userlogid.get()+"_"+Global.userlogid1.get());
			e.printStackTrace();
		}
		System.out.println(System.getProperty("java.io.tmpdir"));
		return Global.userlogid.get()+"_"+Global.userlogid1.get();  
	}

	@RequestMapping(value="/test",method = RequestMethod.GET)  
	public @ResponseBody String test() throws Exception { 

		String yy=HttpUtil.readTxtFile("C:/Users/hzk/Desktop/stockids.txt");
		String[] arrs=yy.split("<li>");
		for(int i=0;i<arrs.length;i++)
		{
			String temp=arrs[i];
			if(temp==null||temp.length()<8)
			{
				continue;
			}
			String stockid=temp.substring(temp.indexOf(".com/")+5,temp.indexOf(".html"));
			String name=temp.substring(temp.indexOf(">")+1,temp.indexOf("("));
			Stock stock=new Stock();
			stock.setCloseprice(0);
			stock.setName(name);
			stock.setStockid(stockid);
			stock.setType(stockid.substring(0,2));
			stock.setMarket("1");
			stock.setUpdatedate(new Date());
			stock.setCreatedate(new Date());
			stock.setFirstspell(Cn2Spell.converterToFirstSpell(name).toLowerCase());
			stock.setSpell(Cn2Spell.converterToSpell(name).toLowerCase());
			stockDao.insertStock(stock);
		}
		
		return yy;
	}

	@RequestMapping(value="/print",method = RequestMethod.GET)  
	public @ResponseBody String print() throws Exception { 

		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		int week=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(System.getProperty("java.io.tmpdir"));
		
		String t="<a target=\"_blank\" href=\"http://quote.eastmoney.com/sh166105.html\">信达增利(166105)</a></li>";
		
		return sdf.format(cal.getTime())+week+"_llll_"+Cn2Spell.converterToSpell("中低端快睡觉")+"ff_"+t.substring(t.indexOf(">")+1,t.indexOf("("));
	}
	
	@RequestMapping(value="/print1",method = RequestMethod.GET)  
	public @ResponseBody String print1() throws Exception { 

		return stockService.getUserStockIds();
	}

} 

