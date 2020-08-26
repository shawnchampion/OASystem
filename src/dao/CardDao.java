package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Card;
import bean.CardCategory;
import util.Conn;

public class CardDao {
	public static List<Card> selectCardByOwner(String owner) throws SQLException{
		Connection conn = Conn.getConnection();
		String sql = "select * from card where owner=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, owner);
		ResultSet rs = ps.executeQuery();
		List<Card> list = new ArrayList<Card>();
		while(rs.next()) {
			int cid = rs.getInt("cid");
			String name = rs.getString("name");
			String company = rs.getString("company");
			String position = rs.getString("position");
			String phone = rs.getString("phone");
			String telephone = rs.getString("telephone");
			String email = rs.getString("email");
			String ccname = rs.getString("ccname");
			Card card = new Card(cid, owner, name, company, position, phone, telephone, email, ccname);
			list.add(card);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	public static List<Card> selectCardByOwner(String owner, String ccname, String name) throws SQLException{
		Connection conn = Conn.getConnection();
		String sql = "select * from card where owner=? ";
		PreparedStatement ps = null;
		
		if (null == ccname && null == name){
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner);
		}
		if (null != ccname && null == name) {
			sql += "and ccname=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner);
			ps.setString(2, ccname);
		}
		if (null == ccname && null != name) {
			sql += "and name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner);
			ps.setString(2, '%'+name+'%');
		}
		if (null != ccname && null != name) {
			sql += "and ccname=? and name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, owner);
			ps.setString(2, ccname);
			ps.setString(3, '%'+name+'%');
		}

		ResultSet rs = ps.executeQuery();
		List<Card> list = new ArrayList<Card>();
		while(rs.next()) {
			int cid = rs.getInt("cid");
			name = rs.getString("name");
			String company = rs.getString("company");
			String position = rs.getString("position");
			String phone = rs.getString("phone");
			String telephone = rs.getString("telephone");
			String email = rs.getString("email");
			ccname = rs.getString("ccname");
			Card card = new Card(cid, owner, name, company, position, phone, telephone, email, ccname);
			list.add(card);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
	public static Card selectCardByOwnerCid(int cid, String owner) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "select * from card where cid=? and owner=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cid);
		ps.setString(2, owner);
		ResultSet rs = ps.executeQuery();
		Card card = null;
		if (rs.next()) {
			String name = rs.getString("name");
			String company = rs.getString("company");
			String position = rs.getString("position");
			String phone = rs.getString("phone");
			String telephone = rs.getString("telephone");
			String email = rs.getString("email");
			String ccname = rs.getString("ccname");
			card = new Card(cid, owner, name, company, position, phone, telephone, email, ccname);
		}

		rs.close();
		ps.close();
		conn.close();
		
		return card;
		
	}
	
	public static int insertCard(Card card) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "insert into card(owner, name, company, position, phone, telephone, email, ccname) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, card.getOwner());
		ps.setString(2, card.getName());
		ps.setString(3, card.getCompany());
		ps.setString(4, card.getPosition());
		ps.setString(5, card.getPhone());
		ps.setString(6, card.getTelephone());
		ps.setString(7, card.getEmail());
		ps.setString(8, card.getCcname());
		int rs = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return rs;
	}
	public static int updateCategory(CardCategory cc, String newName) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "update card set ccname=? where owner=? and ccname=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newName);
		ps.setString(2, cc.getOwner());
		ps.setString(3, cc.getName());
		int rs = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return rs;
	}
	public static int updateCard(Card card) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "update card set name=?,company=?,position=?,phone=?,telephone=?,email=?,ccname=? where cid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, card.getName());
		ps.setString(2, card.getCompany());
		ps.setString(3, card.getPosition());
		ps.setString(4, card.getPhone());
		ps.setString(5, card.getTelephone());
		ps.setString(6, card.getEmail());
		ps.setString(7, card.getCcname());
		ps.setInt(8, card.getCid());
		int rs = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return rs;
		
	}
	
	public static int deleteCardById(int cid) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "delete from card where cid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cid);
		int rs = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return rs;
	}
}
