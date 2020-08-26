package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Job;
import util.Conn;

public class JobDao {
	public List<Job> selectJobs(){
		Connection c= Conn.getConnection();
		String sql="select * from job ";
		List<Job> list = new ArrayList<Job>();
		try {
			PreparedStatement sp =c.prepareStatement(sql);
		 
		    ResultSet rs = sp.executeQuery();
		    while(rs.next()){
		    	int jobid =rs.getInt("jobid");
		    	String jobname=rs.getString("jobname");
		    	Job emp = new Job(jobid ,jobname);
		    	list.add(emp);
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
		return list;
	  
  }
}
