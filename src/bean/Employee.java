package bean;

public class Employee {
	private String empid;
	private String pos;
	private String dept;
	private String pass;
	private String name;
	private String sex;
	private int age;
	private String email;
	private String phone;
	private String telephone;
	private String address;
	private String hobby;
	private String introduction;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Employee(String empid, String pos, String dept, String pass, String name, String sex, int age, String email,
			String phone, String telephone, String address, String hobby, String introduction) {
		super();
		this.empid = empid;
		this.pos = pos;
		this.dept = dept;
		this.pass = pass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.telephone = telephone;
		this.address = address;
		this.hobby = hobby;
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", pos=" + pos + ", dept=" + dept + ", pass=" + pass + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", email=" + email + ", phone=" + phone + ", telephone=" + telephone
				+ ", address=" + address + ", hobby=" + hobby + ", introduction=" + introduction + "]";
	}
	
	
	
}
