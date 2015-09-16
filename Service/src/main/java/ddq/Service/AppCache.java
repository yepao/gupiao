package ddq.Service;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.*;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ddq.model.Currency;

@Component
@Transactional
public class AppCache {

	@Autowired
	private StockService stockService;

	@Autowired
	private SysService sysService;

	/**
	 * 缓存用户股票信息
	 * @param uid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@Cacheable(value="AppCache", key="#uid")    
	public Map getStockInfo(Integer uid,Integer date) throws Exception{  

		Integer _date=0;

		//排除周末
		for(int i=0;i<date*2;i++)
		{
			Calendar caltemp=Calendar.getInstance();
			caltemp.setTime(new Date());
			caltemp.add(Calendar.DATE, -i);
			if(stockService.IsMarketClose(caltemp.getTime())==1)
			{
				_date++;
			}
			if(_date==date)
			{
				_date=i+1;
				break;
			}
		}

		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -_date);

		Map map=new HashMap();
		map.put("uid", uid);
		map.put("date", _date);
		map.put("datenum", date);
		map.put("starttime", cal.getTime());
		map.put("endtime", new Date());
		System.out.println(_date+""+cal.getTime().toString()+"+iiii_"+(Integer)map.get("date"));
		return stockService.selectProfit(map);
	} 


	/**
	 * 更新缓存里的用户股票信息
	 * @param uid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@CachePut(value="AppCache", key="#uid")
	public Map updateStockInfo(Integer uid,Integer date) throws Exception{  

		Integer _date=0;

		//排除周末
		for(int i=0;i<date*2;i++)
		{
			Calendar caltemp=Calendar.getInstance();
			caltemp.setTime(new Date());
			caltemp.add(Calendar.DATE, -i);
			if(stockService.IsMarketClose(caltemp.getTime())==1)
			{
				_date++;
			}
			if(_date==date)
			{
				_date=i+1;
				break;
			}
		}


		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -_date);

		Map map=new HashMap();
		map.put("uid", uid);
		map.put("date", _date);
		map.put("datenum", date);
		map.put("starttime", cal.getTime());
		map.put("endtime", new Date());

		return stockService.selectProfit(map);
	} 

	/**
	 * 更新缓存里的用户股票信息(直接更新)
	 * @param uid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@CachePut(value="AppCache", key="#uid")
	public Map updateStockInfo(Map map,Integer uid) throws Exception{  
		return map;
	} 

	/**
	 * 清空指定key的缓存
	 * @param uid
	 * @throws Exception
	 */
	@CacheEvict(value="AppCache", key="#key",beforeInvocation=true)
	public void deleteCacheByKey(String key) throws Exception{  
		//写入日志

	} 

	/**
	 * 清空所有缓存
	 * @param uid
	 * @throws Exception
	 */
	@CacheEvict(value="AppCache",allEntries=true,beforeInvocation=true)
	public void deleteAllCache() throws Exception{  
		//写入日志

	} 

	/**
	 * 缓存汇率
	 * @return
	 * @throws Exception
	 */
	@Cacheable(value="AppCache", key="'currency'") 
	public Map getCurrency() throws Exception{
		Map map=new HashMap();
		List<Currency> list=sysService.selectAllCurrency();
		for(int i=0;i<list.size();i++)
		{
			Currency temp=list.get(i);
			map.put(temp.getMarket(), temp.getExchange());
		}

		return map;
	}

	/**
	 * 缓存股票信息
	 * @return
	 * @throws Exception
	 */
	@Cacheable(value="AppCache", key="'stock'") 
	public Map getStock() throws Exception{
		return stockService.selectStock();
	}


	/**
	 * 缓存股票实时数据
	 * @return
	 * @throws Exception
	 */
	@Cacheable(value="AppCache", key="'stock_hq'") 
	public Map getStockData() throws Exception{
		Map map=new HashMap();
		return map;
	}

	/**
	 * 更新缓存里的股票实时数据
	 * @return
	 * @throws Exception
	 */
	@CachePut(value="AppCache", key="'stock_hq'")
	public Map updateStockData(Map map) throws Exception{  
		return map;
	}
}
