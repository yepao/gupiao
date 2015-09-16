package ddq.Dao;

import java.util.*;
import ddq.model.*;


public class CashDao extends BaseDao 
{
   public List<Cash> queryAllCash() throws Exception {  
	  
        List<Cash> cashList = null;  
        try {  
        	cashList = getSqlMapClientTemplate().queryForList("selectAllCash",null);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return cashList;  
    }  
      
    public int addCash(Cash cash) throws Exception {  
        int key;  
        try {  
            key = (Integer) getSqlMapClientTemplate().insert("insertCash",cash);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return key;  
    }  
    
    public int updateCashByUid(Cash cash) throws Exception {  
        int key=0;  
        try { 
        	key=getSqlMapClientTemplate().update("updateCashByUid", cash);
        } catch (Exception e) {  
            e.printStackTrace(); 
            throw e;  
        }  
        return key;  
    }  
    
    /*
     * 彻底删除cash*/
    public int deleteCashById(Cash cash) throws Exception {
    	  int key;  
          try {  
              key = getSqlMapClientTemplate().delete("deleteCashById",cash);  
          } catch (Exception e) {  
              e.printStackTrace();  
              throw e;  
          }  
          return key;  
    }
    
    /*
     * 把cash状态置为无效*/
    public int SetCashStatus(Cash cash) throws Exception {
  	  int key;  
        try {  
            key = getSqlMapClientTemplate().delete("delCashByUid",cash);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return key;  
    }
    
    
    public List<Cash> queryCashByUid(Integer uid) throws Exception {
    	 List<Cash> cashList = null;  
         try {  
         	cashList = getSqlMapClientTemplate().queryForList("selectCashByUid",uid);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return cashList;  
    }
    
    
    
    /*
     * CashFlow */
    
    public List<CashFlow> selectAllCashFlow() throws Exception { 
    	List<CashFlow> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectAllCashFlow",null);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public List<CashFlow> selectCashFlowByUid(CashFlow cashflow) throws Exception { 
    	List<CashFlow> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectCashFlowByUid",cashflow);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public List<CashFlow>  seleteCashFlowById(int id) throws Exception { 
    	List<CashFlow> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("seleteCashFlowById",id);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    
    public List<CashFlow> queryCashFlowByTime(Date starttime,Date endtime,CashFlow cashflow)throws Exception
    {
    
      List<CashFlow> list = null;  
       
      HashMap<String,Object> map=new HashMap<String,Object>();
      map.put("starttime", starttime);
      map.put("endtime", endtime);
      map.put("uid", cashflow.getUid());
      map.put("status", cashflow.getStatus());
      
      try {  
    	  list = getSqlMapClientTemplate().queryForList("selectCashFlowByTime",map);  
      } catch (Exception e) {  
          e.printStackTrace();  
          throw e;  
      }  
      
      return list;
    }
    
    public int addCashFlow(CashFlow cashflow) throws Exception{
    	 int key;  
         try {  
             key = (Integer) getSqlMapClientTemplate().insert("insertCashFlow",cashflow);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key;  
    }
    
    public int deleteCashFlowById(int cashflowid)  throws Exception{
    	 int key;  
         try {  
             key = getSqlMapClientTemplate().delete("deleteCashFlowById",cashflowid);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key;  
    }
    
    /*
     * 把cash状态置为无效*/
    public int SetCashFlowById(int cashflowid) throws Exception{
    	 int key;  
         try {  
             key = getSqlMapClientTemplate().update("delCashFlowById",cashflowid);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key;  
    }
    
    public int updateCashFlowById(CashFlow cashflow) throws Exception{
    	 int key;  
         try {  
             key = getSqlMapClientTemplate().update("updateCashFlowById",cashflow);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key; 
    }
    
    
    
    /*
     * CashLog */
    
    public List<CashLog> queryAllCashLog() throws Exception { 
    	List<CashLog> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectAllCashLog",null);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public List<CashLog> queryCashLogByUid(CashLog cashlog) throws Exception { 
    	List<CashLog> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectCashLogByUid",cashlog);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public int addCashLog(CashLog cashlog) throws Exception { 
    	 int key;  
         try {  
             key = (Integer) getSqlMapClientTemplate().insert("insertCashLog",cashlog);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key;  
    }
    
    /*
     * CashSysLog */
    
    
    public List<CashSysLog> queryAllCashSysLog() throws Exception { 
    	List<CashSysLog> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectAllCashSysLog",null);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public List<CashSysLog> queryCashSysLogByUid(CashSysLog cashsyslog) throws Exception { 
    	List<CashSysLog> list = null;  
        try {  
        	list = getSqlMapClientTemplate().queryForList("selectCashSysLogByUid",cashsyslog);  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw e;  
        }  
        return list;  
    }
    
    public int addCashSysLog(CashSysLog cashsyslog) throws Exception { 
    	 int key;  
         try {  
             key = (Integer) getSqlMapClientTemplate().insert("insertCashSysLog",cashsyslog);  
         } catch (Exception e) {  
             e.printStackTrace();  
             throw e;  
         }  
         return key;  
    }
}
