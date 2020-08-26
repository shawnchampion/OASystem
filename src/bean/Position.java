package bean;

public class Position {
	private String posid;
	private String name;
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position(String posid, String name) {
		super();
		this.posid = posid;
		this.name = name;
	}
}
