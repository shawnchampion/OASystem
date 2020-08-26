package bean;

public class CardCategory {
	private int ccid;
	private String owner;
	private String name;
	public int getCcid() {
		return ccid;
	}
	public void setCcid(int ccid) {
		this.ccid = ccid;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CardCategory(int ccid, String owner, String name) {
		super();
		this.ccid = ccid;
		this.owner = owner;
		this.name = name;
	}
}
