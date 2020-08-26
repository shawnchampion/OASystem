package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conn;

public class LoginDao {
	public static boolean confirm(String role, String id, String pass) throws SQLException{
		boolean confirmed = false;
		Connection conn = Conn.getConnection();
		String sql = null;
		//System.out.println(role);
		//针对不同系统角色设置不同sql查询语句
		if ("管理员".equals(role)){
			//System.out.println("正在查询管理员");
			sql = "select ampass from admin where amid=?";
		}else if ("领导".equals(role)){
			//System.out.println("正在查询领导");
			sql = "select pass from employee where posid in ('02','03') and empid=?";
		}else if ("职员".equals(role)){
			//System.out.println("正在查询职员");
			sql = "select pass from employee where posid='01' and empid=?";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		//System.out.println(rs.getString(1));
		//获取密码与用户输入进行对比
		if (rs.next() && pass.equals(rs.getString(1))){
			confirmed = true;
		}
		rs.close();
		ps.close();
		conn.close();
		return confirmed;
	}
}
