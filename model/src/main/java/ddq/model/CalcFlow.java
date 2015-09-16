package ddq.model;

import java.io.Serializable;
import java.util.*;


public class CalcFlow implements Serializable {
	private static final long serialVersionUID = 5138984773718311915L;
	/*id int(11) NOT NULL AUTO_INCREMENT,
	   Calcid int,
	   Cashflowid int,
	   interest double,
	   currency int(2) COMMENT '币种',*/
	int id;
	int calcid;
	int cashflowid;
	double interest;
	int currency;
	Date timestamp;
	int status;
	int operation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public int getCalcid() {
		return calcid;
	}
	public void setCalcid(int calcid) {
		this.calcid = calcid;
	}
	public int getCashflowid() {
		return cashflowid;
	}
	public void setCashflowid(int cashflowid) {
		this.cashflowid = cashflowid;
	}
	
	
}
