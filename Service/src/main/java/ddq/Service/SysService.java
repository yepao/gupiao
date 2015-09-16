package ddq.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ddq.Dao.*;
import ddq.model.*;

@Component
@Transactional
public class SysService  {

	@Autowired
	private SysDao sysDao;

	public List<Currency> selectAllCurrency() throws Exception { 

		return sysDao.selectAllCurrency();
	}

	public int updateCurrencyByCode(Currency currency) throws Exception { 

		return sysDao.updateCurrencyByCode(currency);
	}

	public String selectUid(String wid,String openid) throws Exception
	{
		User user=new User();
		String uid="";
		try{
			user.setOpenid(openid);
			user.setWid(wid);
			List<User> list=sysDao.selectUserByOpenIdOrWid(user);
			if(list.size()>0)
			{
				uid=list.get(0).getUid();
			}
			else
			{
				// 创建 GUID 对象
				UUID uuid = UUID.randomUUID();
				// 得到对象产生的ID
				uid= uuid.toString().toLowerCase();
				
				user.setName(wid);
				user.setPwd("123456");
				user.setUid(uid);
				
				if(sysDao.insertUser(user)<=0)
				{
					uid="";
				}
			}

		}catch(Exception e)
		{
			uid="";
			e.printStackTrace();
			throw e;
		}

		return uid;
	}

	public int addUserLog(UserLog userlog) throws Exception
	{ 
		int key=0;
		try{
			key=sysDao.insertUserLog(userlog);
			Global.userlogid.set(key);
		}
		catch(Exception e){
			e.printStackTrace();
			key=0;
			throw e;

		}
		return key;
	}

	public int deleteUserLog(Integer id) throws Exception { 
		id=id==null?0:id;
		return sysDao.deleteUserLogById(id);
	}

	public List<ddq.model.Calendar> selectCalendarByDate(ddq.model.Calendar temp) throws Exception { 

		return sysDao.selectCalendarByDate(temp);
	}

}
