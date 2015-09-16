package ddq.model;

import java.io.Serializable;
import java.util.*;

public class DebtFlow implements Serializable {
	private static final long serialVersionUID = 5138984773718311911L;
	
	/* id int(11) NOT NULL AUTO_INCREMENT,
	   uid int(2),
	   debt double,
	   timestamp  timestamp ,
	   operation int(2) COMMENT '操作',
	   rate double COMMENT '利率',
	   starttime timestamp COMMENT '开始时间',
	   status int(2) COMMENT '是否有效',
	   currency int(2) COMMENT '币种',
	   flowid int(11) COMMENT '现金流水id',*/
	
	int id;
	int uid;
	double debt;
	Date timestamp;
	int operation;
	double rate;
	Date starttime;
	int status;
	int currency;
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
	public double getDebt() {
		return debt;
	}
	public void setDebt(double debt) {
		this.debt = debt;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
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
