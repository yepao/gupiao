package ddq.model;

import java.io.Serializable;
import java.util.*;

public class CalcSysLog implements Serializable {
	private static final long serialVersionUID = 5138984773718311916L;

	/*
   id int(11) NOT NULL AUTO_INCREMENT,
   flowid int(11) COMMENT '负债流水id',
   interest double COMMENT '利息',
   time timestamp,
   currency int(2) COMMENT '币种',
   Operation int,
   Cashflowid int,*/
	
	int id;
	int flowid;
	int interest;
	Date time;
	int currency;
	int operation;
	int cashflowid;
	int calcid;
	
	public int getCalcid() {
		return calcid;
	}
	public void setCalcid(int calcid) {
		this.calcid = calcid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlowid() {
		return flowid;
	}
	public void setFlowid(int flowid) {
		this.flowid = flowid;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public int getCashflowid() {
		return cashflowid;
	}
	public void setCashflowid(int cashflowid) {
		this.cashflowid = cashflowid;
	}
}
