package ddq.model;

import java.util.*;
import java.io.Serializable;

public class UserLog implements Serializable {
	private static final long serialVersionUID = 5138984773718311900L;
	
	  /* Id int NOT NULL AUTO_INCREMENT,
	   Uid int,
	   Ip nvarchar(10),
	   Time timestamp,
	   Operation nvarchar,
	   Remark  nvarchar(250),
	   PRIMARY KEY (`id`)
	   Flowid int*/
	
	int id;
	int uid;
	String ip;
	Date time;
    String operation;
    int flowid;
    String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getFlowid() {
		return flowid;
	}
	public void setFlowid(int flowid) {
		this.flowid = flowid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
