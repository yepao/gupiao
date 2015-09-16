package ddq.model;

import java.io.Serializable;
import java.util.Date;

public class StockSysLog implements Serializable{
	private static final long serialVersionUID = 5138984773718311004L;
	 /*id int NOT NULL AUTO_INCREMENT,
	 timestamp timestamp, 
	 uid int,
	 stockid varchar(10),
	 operation int,
	 price double,
cashflowid int COMMENT '现金流水ID',
debtflowid int COMMENT '融资流水ID',
	 feeprice double,*/
	
	int id;
	Date timestamp;
	int operation;
	double price;
	int uid;
	String stockid;
	int debtflowid;
	int cashflowid;
	double feeprice;
	int position;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}

	public double getFeeprice() {
		return feeprice;
	}
	public void setFeeprice(double feeprice) {
		this.feeprice = feeprice;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getDebtflowid() {
		return debtflowid;
	}
	public void setDebtflowid(int debtflowid) {
		this.debtflowid = debtflowid;
	}
	public int getCashflowid() {
		return cashflowid;
	}
	public void setCashflowid(int cashflowid) {
		this.cashflowid = cashflowid;
	}


	
}

