package bean;

public class Department {
	private String deptid;
	private String name;
	private String phone;
	private String info;
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Department(String deptid, String name, String phone, String info) {
		super();
		this.deptid = deptid;
		this.name = name;
		this.phone = phone;
		this.info = info;
	}
	
}
