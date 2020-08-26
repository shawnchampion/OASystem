package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Department;
import util.Conn;

public class DeptDao {
	/*
	public List<Dept> selectDepts(){
		Connection c=Conn.getConnection();//连接
		List<Dept> list=new ArrayList<Dept>();
		String sql="SELECT * FROM dept";
		try {
			PreparedStatement sp= c.prepareStatement(sql);
		
			ResultSet rs=sp.executeQuery();
			while(rs.next()){
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				Dept emp=new Dept(deptno,dname,loc);
				list.add(emp);
				
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
	*/
	public static Department selectDeptById(String deptid) throws SQLException{
		Department dept = null;
		Connection conn = Conn.getConnection();
		String sql = "select * from department where deptid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, deptid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String info = rs.getString("info");
			dept = new Department(deptid, name, phone, info);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return dept;
	}
	public static Department selectDeptByName(String name) throws SQLException{
		Department dept = null;
		Connection conn = Conn.getConnection();
		String sql = "select * from department where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String deptid = rs.getString("deptid");
			String phone = rs.getString("phone");
			String info = rs.getString("info");
			dept = new Department(deptid, name, phone, info);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return dept;
	}
	public static List<Department> selectDeptAll() throws SQLException{
		Connection conn = Conn.getConnection();
		String sql = "select * from department";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Department> list = new ArrayList<Department>();
		
		while(rs.next()) {
			String deptid = rs.getString("deptid");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String info = rs.getString("info");
			Department dept = new Department(deptid,name,phone,info);
			list.add(dept);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
}
