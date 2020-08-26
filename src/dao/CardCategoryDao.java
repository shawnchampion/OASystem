package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CardCategory;
import util.Conn;

public class CardCategoryDao {
	public static int getTotalPage(String owner, int pagesize) throws SQLException {
		List<CardCategory> list = selectCardCategoryByOwner(owner, 1, 999);
		int t = list.size();
		return (t%pagesize==0) ? (t/pagesize) : (t/pagesize+1);
	}
	public static List<CardCategory> selectCardCategoryByOwner(String owner, int cur, int pagesize) throws SQLException{
		Connection conn = Conn.getConnection();
		String sql = "select * from cardcategory where owner=? limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, owner);
		ps.setInt(2, (cur-1)*pagesize);
		ps.setInt(3, pagesize);
		ResultSet rs = ps.executeQuery();
		List<CardCategory> list = new ArrayList<CardCategory>();
		while(rs.next()) {
			int ccid = rs.getInt("ccid");
			String name = rs.getString("name");
			CardCategory cc = new CardCategory(ccid, owner, name);
			list.add(cc);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	public static int insertCardCategory(CardCategory cc) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "insert into cardcategory(owner, name) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cc.getOwner());
		ps.setString(2, cc.getName());
		int rs = ps.executeUpdate();
		return rs;
	}
	public static CardCategory selectCardCategoryById(int ccid) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "select * from cardcategory where ccid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, ccid);
		ResultSet rs = ps.executeQuery();
		CardCategory cc = null;
		if (rs.next()) {
			String owner = rs.getString("owner");
			String name = rs.getString("name");
			cc = new CardCategory(ccid,owner,name);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return cc;
	}
	
	public static int updateCardCategory(CardCategory cc) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "update cardcategory set name=? where ccid=? and owner=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cc.getName());
		ps.setInt(2, cc.getCcid());
		ps.setString(3, cc.getOwner());
		int rs = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return rs;
	}
	public static int deleteCardCategory(CardCategory cc) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "delete from cardcategory where ccid=? and owner=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, cc.getCcid());
		ps.setString(2, cc.getOwner());
		int rs = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return rs;
	}
}
