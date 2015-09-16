package ddq.Dao;

import java.util.*;

import ddq.model.*;

public class CalcDao extends BaseDao {


	/*
	 * calcflow */
	
	public List<Calc> selectAllCalc() throws Exception {  

		List<Calc> List = null;  
		try {  
			List = getSqlMapClientTemplate().queryForList("selectAllCalc");  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return List;  
	}  

	public List<Calc> selectCalcByFLowid(int flowid) throws Exception {  

		List<Calc> List = null;  
		try {  
			List = getSqlMapClientTemplate().queryForList("selectCalcByFLowid",flowid);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return List;  
	} 
	
	public List<Calc> selectCalcInterestByUid(Map map)throws Exception { 
		List<Calc> list=null;
		try{
			list=getSqlMapClientTemplate().queryForList("selectCalcInterestByUid",map);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}


	public int insertCalc(Calc calc) throws Exception {  
		int key;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertCalc",calc);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}  

	public int updateCalcById(Calc calc) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateCalcById",calc);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	} 
	
	public int updateCalcByDebtId(Calc calc) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateCalcByDebtId",calc);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	} 
	
	public int insertCalcByTime(Debt debt) throws Exception 
	{  
		int key=0;  
		try { 
			key=(Integer) getSqlMapClientTemplate().insert("insertCalcByTime",debt);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key; 
	}



	/*
	 * calcflow */

	public List<CalcFlow> selectAllCalcFlow() throws Exception {
		List<CalcFlow> list=null;  
		try {  
			list = getSqlMapClientTemplate().queryForList("selectAllCalcFlow");  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return list;  
	}

	public int insertCalcFlow(CalcFlow calcflow) throws Exception {  
		int key;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertCalcFlow",calcflow);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}  

	public int updateCalcFlow(int debtid) throws Exception {  
		int key=0;  
		try { 
			key=getSqlMapClientTemplate().update("updateCalcFlow",debtid);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key;  
	} 

	public List<Map> selectInterest(int debtid) throws Exception
	{
		List<Map> list=null;  
		try {  
			list = getSqlMapClientTemplate().queryForList("selectInterest",debtid);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return list; 
	}
	

	public int insertCalcFlowByTime(Debt debt) throws Exception
	{  
		int key=0;  
		try { 
			key=(Integer) getSqlMapClientTemplate().insert("insertCalcFlowByTime",debt);
		} catch (Exception e) {  
			e.printStackTrace(); 
			throw e;  
		}  
		return key; 
	}

	/*
	 * calclog*/
	public int insertCalcLog(CalcLog calclog) throws Exception {  
		int key;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertCalcLog",calclog);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}


	/*
	 * calcsyslog*/
	public int insertCalcSysLog(CalcSysLog calcsyslog) throws Exception {  
		int key;  
		try {  
			key = (Integer) getSqlMapClientTemplate().insert("insertCalcSysLog",calcsyslog);  
		} catch (Exception e) {  
			e.printStackTrace();  
			throw e;  
		}  
		return key;  
	}
}
