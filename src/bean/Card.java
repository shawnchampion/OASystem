package bean;

public class Card {
	private int cid;
	private String owner;
	private String name;
	private String company;
	private String position;
	private String phone;
	private String telephone;
	private String email;
	private String ccname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public Card(int cid, String owner, String name, String company, String position, String phone, String telephone,
			String email, String ccname) {
		super();
		this.cid = cid;
		this.owner = owner;
		this.name = name;
		this.company = company;
		this.position = position;
		this.phone = phone;
		this.telephone = telephone;
		this.email = email;
		this.ccname = ccname;
	}
}
