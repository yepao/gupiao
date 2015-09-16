package ddq.model;

import java.io.Serializable;
import java.util.*;

public class StockProfit implements Serializable{
	private static final long serialVersionUID = 5138984773718311005L;
	
	/*
	 *   id int NOT NULL AUTO_INCREMENT,
timestamp timestamp,
uid int ,
stockid varchar(10),
market int,
    profit double,
flowid int COMMENT '股票流水id',
status int,
ctype int  1 平仓盈亏 2 日盈亏  3累计盈亏,
	 */
	
	int id;
	Date timestamp;
	int uid;
	String stockid;
	int market;
	double profit;
	Integer flowid;
	int status;
	int ctype; //1 平仓盈亏 2 股票日盈亏  3 股票累计盈亏 4 人日盈亏  5 人累计盈亏 6 市场日盈亏  7 市场累计盈亏 
	int currency;
	double total;
	Integer ytdposition;
	
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStockid() {
		return stockid==null?"":stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public int getMarket() {
		return market;
	}
	public void setMarket(int market) {
		this.market = market;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public int getFlowid() {
		return flowid==null?0:flowid;
	}
	public void setFlowid(Integer flowid) {
		this.flowid = flowid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	
	public int getYtdposition() {
		return ytdposition==null?0:ytdposition;
	}
	public void setYtdposition(Integer ytdposition) {
		this.ytdposition = ytdposition;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
