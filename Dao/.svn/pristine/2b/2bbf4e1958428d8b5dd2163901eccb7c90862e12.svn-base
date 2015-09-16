package ddq.Dao;

import java.util.*;

import ddq.model.*;

public class DebtDao extends BaseDao {


	//debt

	public List<Debt> selectAllDebt() throws Exception { 
		List<Debt> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectAllDebt");
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public List<Debt> selectDebtByUidCur(Debt debt) throws Exception { 
		List<Debt> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtByUidCur",debt);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<Debt> selectDebtByUid(int uid) throws Exception { 
		List<Debt> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtByUid",uid);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<Debt> selectDebtById(int id) throws Exception { 
		List<Debt> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtById",id);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<Debt> selectDebtByFlowid(int flowid) throws Exception
	{
		List<Debt> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtByFlowid",flowid);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<HashMap<String,Object>> selectDebtSUMByUid(Debt debt) throws Exception {

		List<HashMap<String,Object>> list=null;
		try{
			list= getSqlMapClientTemplate().queryForList("selectDebtSUMByUid",debt);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public int insertDebt(Debt debt) throws Exception {  
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertDebt",debt);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}  

	public int updateDebt(Debt debt) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateDebt", debt);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	}  
	
	public int updateDebtInterest(Map map) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateDebtInterest", map);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key; 
	}
	
	public int updateAllDebtInterest() throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateAllDebtInterest");
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key; 
	}

	public int deleteDebtById(int debtid) throws Exception
	{
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().delete("deleteDebtById", debtid);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	}


	// debtflow
	public List<DebtFlow> selectAllDebtFlow() throws Exception { 
		List<DebtFlow> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectAllDebtFlow");
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public List<DebtFlow> selectDebtFlowByUid(DebtFlow debtflow) throws Exception { 
		List<DebtFlow> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtFlowByUid",debtflow);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<DebtFlow> selectDebtFlowById(int flowid) throws Exception { 
		List<DebtFlow> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectDebtFlowById",flowid);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public List<DebtFlow> selectAssetsHistoryByUid(int uid) throws Exception { 
		List<DebtFlow> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectAssetsHistoryByUid",uid);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public int insertDebtFlow(DebtFlow debtflow) throws Exception {  
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertDebtFlow",debtflow);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}  

	public int updateDebtFlow(DebtFlow debtflow) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateDebtFlow", debtflow);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	}  

	public int delDebtFlowById(int id) throws Exception
	{
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().delete("delDebtFlowById", id);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	}



	//<!-- debtlog -->
	public int insertDebtLog(DebtLog debtlog) throws Exception {  
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertDebtLog",debtlog);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	} 



	//<!-- debtsyslog -->
	public int insertDebtSysLog(DebtSysLog debtsyslog) throws Exception {  
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertDebtSysLog",debtsyslog);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	} 

	public List<DebtSysLog> selectDebtSysLogByDebtid(int debtid) throws Exception
	{
		List<DebtSysLog> list=null;  
		try {  
			list = getSqlMapClientTemplate().queryForList("selectDebtSysLogByDebtid",debtid);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return list; 
	}

	public List<DebtSysLog> selectDebtSysLogByFlowid(int flowid) throws Exception
	{
		List<DebtSysLog> list=null;  
		try {  
			list = getSqlMapClientTemplate().queryForList("selectDebtSysLogByFlowid",flowid);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return list; 
	}
	
	public int updateDebtSysLog(DebtSysLog debtsyslog) throws Exception
	{
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().update("updateDebtSysLog",debtsyslog);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}
	
	
	//<!-- debtcalc -->
	public int insertDebtCalc(Calc calc) throws Exception {  
		int key=0;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertDebtCalc",calc);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}

	public int updateDebtCalc(Calc calc) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateDebtCalc", calc);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	} 


}
