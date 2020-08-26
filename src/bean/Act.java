package bean;

public class Act {
	
	private int actid;
	private String actname;
	private String acttime;
	private String endtime;
	private String empname;
	private String actbody;
	private int finish;
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public String getActname() {
		return actname;
	}
	public void setActname(String actname) {
		this.actname = actname;
	}
	public String getActtime() {
		return acttime;
	}
	public void setActtime(String acttime) {
		this.acttime = acttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getActbody() {
		return actbody;
	}
	public void setActbody(String actbody) {
		this.actbody = actbody;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	public Act() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Act(int actid, String actname, String acttime, String endtime, String empname, String actbody) {
		super();
		this.actid = actid;
		this.actname = actname;
		this.acttime = acttime;
		this.endtime = endtime;
		this.empname = empname;
		this.actbody = actbody;
	}
	public Act(int actid,String actname, String acttime,String endtime,String actbody) {
		super();
		this.actid = actid;
		this.actname = actname;
		this.acttime = acttime;
		this.endtime =endtime;
		this.actbody = actbody;
	}
	public Act(int actid,String actname, String acttime,String endtime,String empname,String actbody,int finish) {
		super();
		this.actid = actid;
		this.actname = actname;
		this.acttime = acttime;
		this.endtime =endtime;
		this.actbody = actbody;
		this.finish=finish;
		this.empname=empname;
	}
	public Act(String actname, String acttime,String endtime,String empname,String actbody) {
		super();
	
		this.actname = actname;
		this.acttime = acttime;
		this.endtime =endtime;
		this.empname=empname;
		this.actbody = actbody;
	}
	public Act(int actid){
		super();
		this.actid=actid;
	}
}
