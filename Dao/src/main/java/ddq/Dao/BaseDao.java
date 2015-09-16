package ddq.Dao;

import java.sql.SQLException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;  

import com.ibatis.sqlmap.client.SqlMapClient;  
  
public class BaseDao extends SqlMapClientDaoSupport {  
      
   
   private SqlMapClient sqlMapClient;  
      
   public void initSqlMapClient(){  
        super.setSqlMapClient(sqlMapClient); 
   } 
   
   public void endTransaction(){  
    	try {
    		super.getSqlMapClient().endTransaction();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
    }
    
} 