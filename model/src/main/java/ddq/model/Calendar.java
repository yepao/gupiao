package ddq.model;

import java.io.Serializable;
import java.util.Date;

public class Calendar implements Serializable {
	private static final long serialVersionUID = 5138984773718311945L;
	String tempdate;
	int isclose;
	int id;
	public String getTempdate() {
		return tempdate;
	}
	public void setTempdate(String tempdate) {
		this.tempdate = tempdate;
	}
	public int getIsclose() {
		return isclose;
	}
	public void setIsclose(int isclose) {
		this.isclose = isclose;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
