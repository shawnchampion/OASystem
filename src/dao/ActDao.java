package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Act;
import util.Conn;


public class ActDao {
	public int saveAct(Act act){
		Connection c=Conn.getConnection();//连接
		int i=0;
		String sql="insert into act(actname,acttime,endtime,empname,actbody) values(?,?,?,?,?)";
		try {
			PreparedStatement sp= c.prepareStatement(sql);//获得语句集对象
			sp.setString(1, act.getActname());
			sp.setString(2, act.getActtime());
			sp.setString(3, act.getEndtime());
			sp.setString(4, act.getEmpname());
			sp.setString(5, act.getActbody());
			i=sp.executeUpdate();//执行语句			 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public int selectMaxworkno(){
		Connection c=Conn.getConnection();//连接
		String sql="select max(actid) from act";		
		try {
			PreparedStatement sp= c.prepareStatement(sql);
			ResultSet rs=sp.executeQuery();
			rs.next();
			int wno=rs.getInt(1);
			return wno;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获得语句集对象
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public List<Act> selectAct(){
		Connection c=Conn.getConnection();//连接
		List<Act> list=new ArrayList<Act>();
		String sql="SELECT * FROM act";
		try {
			PreparedStatement sp= c.prepareStatement(sql);		
			ResultSet rs=sp.executeQuery();
			while(rs.next()){
				int aid=rs.getInt("actid");
		    	int finish=rs.getInt("finish");
		    	String actname=rs.getString("actname");
		    	Date a=rs.getDate("acttime");
		        Date e=rs.getDate("endtime");
		        String actbody=rs.getString("actbody");
		    	String acttime=null;
		    	String endtime=null;
		    	if(a!=null){
		    		acttime=a.toString();
		    	}
		    	if(e!=null){
		    		endtime=e.toString();
		    	}
		    
		    	String empname=rs.getString("empname");
		    	Act act=new Act(aid,actname,acttime,endtime,empname,actbody,finish);
		    	list.add(act);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获得语句集对象
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<Act> selectActsByPage(int cur,int pagesize){
		Connection c=Conn.getConnection();//连接
		List<Act> list=new ArrayList<Act>();
		String sql="SELECT * FROM act   LIMIT ?,?";
		try {
			PreparedStatement sp= c.prepareStatement(sql);
			
			sp.setInt(1, (cur-1)*pagesize);
			sp.setInt(2, pagesize);
			ResultSet rs=sp.executeQuery();
			while(rs.next()){
				int aid=rs.getInt("actid");
		    	int finish=rs.getInt("finish");
		    	String actname=rs.getString("actname");
		    	Date a=rs.getDate("acttime");
		        Date e=rs.getDate("endtime");
		        String empname=rs.getString("empname");
		        String actbody=rs.getString("actbody");
		    	String acttime=null;
		    	String endtime=null;
		    	if(a!=null){
		    		acttime=a.toString();
		    	}
		    	if(e!=null){
		    		endtime=e.toString();
		    	}
		    
		    	
		    	Act act=new Act(aid,actname,acttime,endtime,empname,actbody,finish);
		    	list.add(act);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获得语句集对象
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int getTotalPages(int pagesize){
		Connection c=Conn.getConnection();//连接
		String sql="select count(*) from act where finish=0";
		int t=0;
		try {
			PreparedStatement sp=c.prepareStatement(sql);
			ResultSet rs=sp.executeQuery();
			
			if(rs.next()){
				t=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return t%pagesize==0?t/pagesize:t/pagesize+1;
	}
	
	public Act selectActByid(int actid){
		Connection c=Conn.getConnection();//连接
		String sql="select * from act where actid=?";
		try {
			PreparedStatement sp= c.prepareStatement(sql);
			sp.setInt(1,actid);
			ResultSet rs=sp.executeQuery();
			if(rs.next()){
				int aid=rs.getInt("actid");
		    	String actname=rs.getString("actname");
		    	Date a=rs.getDate("acttime");
		        Date e=rs.getDate("endtime");
		       
		        String actbody=rs.getString("actbody");
		    	String acttime=null;
		    	String endtime=null;
		    	if(a!=null){
		    		acttime=a.toString();
		    	}
		    	if(e!=null){
		    		endtime=e.toString();
		    	}
		    
		    	String empname=rs.getString("empname");
		    	Act act=new Act(aid,actname,acttime,endtime,empname,actbody);
		    	return act;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获得语句集对象
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
	public int deleteAct(int actid){
		Connection c=Conn.getConnection();//连接
		int i=0;
		String sql="delete from act where actid=?";
		try {
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setInt(1, actid);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	public int finishAct(int actid){//更新
		Connection c=Conn.getConnection();
		int i=0;
		String sql="update act set finish=1 where actid=?";
		try {
			PreparedStatement sp=c.prepareStatement(sql);
			
			sp.setInt(1, actid);
			 i=sp.executeUpdate();
				if(i>=1){
					System.out.println("sec");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return i;
	}
	
	public int getTotalPages2(int pagesize){
		Connection c=Conn.getConnection();//连接
		String sql="select count(*) from act";
		int t=0;
		try {
			PreparedStatement sp=c.prepareStatement(sql);
			ResultSet rs=sp.executeQuery();
			
			if(rs.next()){
				t=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return t%pagesize==0?t/pagesize:t/pagesize+1;
	}
	
	
	public List<Act> selectActsByPage2(int cur,int pagesize){
		Connection c=Conn.getConnection();//连接
		List<Act> list=new ArrayList<Act>();
		String sql="SELECT * FROM act LIMIT ?,?";
		try {
			PreparedStatement sp= c.prepareStatement(sql);
			sp.setInt(1, (cur-1)*pagesize);
			sp.setInt(2, pagesize);
			ResultSet rs=sp.executeQuery();
			while(rs.next()){
				int aid=rs.getInt("actid");
		    	int finish=rs.getInt("finish");
		    	String actname=rs.getString("actname");
		    	Date a=rs.getDate("acttime");
		        Date e=rs.getDate("endtime");
		        String empname=rs.getString("empname");
		        String actbody=rs.getString("actbody");
		    	String acttime=null;
		    	String endtime=null;
		    	if(a!=null){
		    		acttime=a.toString();
		    	}
		    	if(e!=null){
		    		endtime=e.toString();
		    	}
		    
		    	
		    	Act act=new Act(aid,actname,acttime,endtime,empname,actbody,finish);
		    	list.add(act);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获得语句集对象
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public int updateAct(Act act){
		Connection c=Conn.getConnection();//连接
		int i=0;
		String sql="update act set actname=?,acttime=?,endtime=?,actbody=? where actid=?";
		try {
			PreparedStatement sp= c.prepareStatement(sql);//获得语句集对象
			sp.setString(1, act.getActname());
			sp.setString(2, act.getActtime());
			sp.setString(3, act.getEndtime());
			//sp.setString(4, act.getEmpsname());
			sp.setString(4, act.getActbody());
			sp.setInt(5, act.getActid());
			 i=sp.executeUpdate();//执行语句		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	
}
