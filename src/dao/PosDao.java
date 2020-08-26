package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Position;
import util.Conn;

public class PosDao {
	public static Position selectPosById(String posid) throws SQLException{
		Position pos = null;
		Connection conn = Conn.getConnection();
		String sql = "select * from position where posid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, posid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String name = rs.getString("name");
			
			pos = new Position(posid, name);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return pos;
	}
	
	public static Position selectPosByName(String name) throws SQLException{
		Position pos = null;
		Connection conn = Conn.getConnection();
		String sql = "select * from position where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String posid = rs.getString("posid");
			
			pos = new Position(posid, name);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return pos;
	}
}
