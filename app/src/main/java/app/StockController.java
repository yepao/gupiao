package app;

import java.text.*;
import java.util.*;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

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

import ddq.Service.*;
import ddq.model.*;


@Controller  
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private StockService stockService;

	@Autowired
	private AppCache appCache;
	
	@Autowired
	private SysService sysService;

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Gson gson=new Gson();
	@RequestMapping(value="/buy", method = RequestMethod.GET)
	public @ResponseBody String cashTran2() throws Exception {
		try
		{
			String stockid=req.getParameter("stockid");
			Double price=Double.parseDouble(req.getParameter("price"));
			Integer position=Integer.parseInt(req.getParameter("position"));
			Integer currency=Integer.parseInt(req.getParameter("currency"));
			Integer day=Integer.parseInt(req.getParameter("day"));
			Integer uid=Integer.parseInt(req.getParameter("uid"));
			
			UserLog userlog=new UserLog();
			userlog.setIp(HttpUtil.getIpAddr(req));
			System.out.println(userlog.getIp());
			userlog.setOperation("buystock");
			userlog.setTime(new Date());
			userlog.setUid(uid);
			sysService.addUserLog(userlog);
			
			Calendar cal=Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -day);

			StockFlow stockflow=new StockFlow();
			stockflow.setUid(uid);
			stockflow.setCurrency(currency);
			stockflow.setOperation(1);
			stockflow.setPosition(position);
			stockflow.setPrice(price);
			stockflow.setStatus(1);
			stockflow.setTimestamp(cal.getTime());
			stockflow.setStockid(stockid);
			int ident=stockService.BuyStock(stockflow, 1,.0);

			return stockflow.getCashflowid()+"gg"+ident+"hh";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sysService.deleteUserLog(Global.userlogid.get());
			return "";
		}

	}

	@RequestMapping(value="/sell", method = RequestMethod.GET)
	public @ResponseBody String Sell() throws Exception {
		try
		{
			
			
			String stockid=req.getParameter("stockid");
			Double price=Double.parseDouble(req.getParameter("price"));
			Integer position=Integer.parseInt(req.getParameter("position"));
			Integer currency=Integer.parseInt(req.getParameter("currency"));
			Integer day=Integer.parseInt(req.getParameter("day"));
			Integer uid=Integer.parseInt(req.getParameter("uid"));
			
			UserLog userlog=new UserLog();
			userlog.setIp(HttpUtil.getIpAddr(req));
			userlog.setOperation("sellstock");
			userlog.setTime(new Date());
			userlog.setUid(uid);
			sysService.addUserLog(userlog);
			
			Calendar cal=Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -day);
			
			StockFlow stockflow=new StockFlow();
			stockflow.setUid(uid);
			stockflow.setCurrency(currency);
			stockflow.setOperation(2);
			stockflow.setPosition(position);
			stockflow.setPrice(price);
			stockflow.setStatus(1);
			stockflow.setTimestamp(cal.getTime());
			stockflow.setStockid(stockid);
			int ident=stockService.SellStock(stockflow, false);
			
			return stockflow.getCashflowid()+"gg"+ident+"hh";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sysService.deleteUserLog(Global.userlogid.get());
			return "";
		}
	}
	/*
	 * 
sh600798	8.09
sh601866	7.35
sh600379	17.45
sh603018	74.39
sh601216	12.33
sh600448	8.38
sh600399	11.92
sh600844	8.72
sh603085	43.58
sh600252	27.77
00005	69.45
00011	154.4
00023	31.5
00222	5.67
00302	121.8
GLBL	23.79
NK	34.64
CYRXW	1.05
WYIGU	10.1
LOB	19.8*/

	@RequestMapping(value="/addProfit", method = RequestMethod.GET)
	public @ResponseBody String addProfit() throws Exception {
		
		Integer day=Integer.parseInt(req.getParameter("day"));
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -day);
		
		Map map=new HashMap();
		map.put("sh600798", 16.69*Math.random()*2);
		map.put("sh601866", 11.35*Math.random()*2);
		map.put("sh600379", 18.45*Math.random()*2);
		map.put("sh601216", 28.33*Math.random()*2);
		map.put("sh600448", 6.38*Math.random()*2);
		map.put("sh600399", 19.92*Math.random()*2);
		map.put("sh600844", 4.72*Math.random()*2);
		map.put("sh603085", 49.58*Math.random()*2);
		map.put("sh600252", 24.77*Math.random()*2);
		map.put("sh603018", 77.39*Math.random()*2);
		map.put("hk00005", 72.45*Math.random()*2);
		map.put("hk00011", 163.4*Math.random()*2);
		map.put("hk00222", 18.67*Math.random()*2);
		map.put("hk00302", 108.8*Math.random()*2);
		map.put("glbl", 21.79*Math.random()*2);
		map.put("nk", 32.64*Math.random()*2);
		map.put("cyrxw", 2.05*Math.random()*2);
		map.put("wyigu", 13.1*Math.random()*2);
		

		int key= stockService.addProfit(map,cal.getTime());
		appCache.deleteAllCache();
		return key+"h";
	}

	@RequestMapping(value="/selectProfit", method = RequestMethod.GET)
	public @ResponseBody String selectProfit() throws Exception {
		Map map=new HashMap();
		map.put("starttime", "2015-08-01 15:00:00");
		map.put("endtime", "2015-08-07 15:00:00");
		map.put("date",7);
		map.put("uid", 9802);

		Map key=appCache.getStockInfo(9802, 7);//stockService.selectProfit(map);

		return gson.toJson(key);
	}


}
