package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Message;
import util.Conn;

public class MessageDao {
	public static int insertMessage(Message msg) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "insert into message(senderid,receiverid,sendername,receivername,header,content,sendtime,sended) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, msg.getSenderid());
		ps.setString(2, msg.getReceiverid());
		ps.setString(3, msg.getSendername());
		ps.setString(4, msg.getReceivername());
		ps.setString(5, msg.getHeader());
		ps.setString(6, msg.getContent());
		ps.setTimestamp(7, msg.getSendtime());
		ps.setBoolean(8, msg.isSended());
		
		int rs = ps.executeUpdate();
		
		ps.close();
		conn.close();
		
		return rs;
	}
	
	public static List<Message> getMsgById(String id, String name, String role1, String role2) throws SQLException{
		Connection conn = Conn.getConnection();
		String sql = "select * from message where ROLEid=? ".replace("ROLE", role1);
		PreparedStatement ps = null;
		if (null == name) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		}else {
			sql += "and ROLEname like ?".replace("ROLE", role2);
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, '%'+name+'%');
		}
		List<Message> list = new ArrayList<Message>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Message msg = result2Message(rs);
			list.add(msg);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	
	private static Message result2Message(ResultSet rs) throws SQLException{
		int msgid = rs.getInt("msgid");
		String senderid = rs.getString("senderid");
		String receiverid = rs.getString("receiverid");
		String sendername = rs.getString("sendername");
		String receivername = rs.getString("receivername");
		String header = rs.getString("header");
		String content = rs.getString("content");
		Timestamp sendtime = rs.getTimestamp("sendtime");
		Timestamp receivetime = rs.getTimestamp("receivetime");
		boolean sended = rs.getBoolean("sended");
		boolean readed = rs.getBoolean("readed");
		Message msg = new Message(msgid,senderid,receiverid,sendername,receivername,header,content,sendtime,receivetime,sended,readed);
		
		return msg;
	}
	
	public static Message getMsgByMsgid(int msgid) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "select * from message where msgid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, msgid);
		ResultSet rs = ps.executeQuery();
		Message msg = null;
		if (rs.next()) {
			String senderid = rs.getString("senderid");
			String receiverid = rs.getString("receiverid");
			String sendername = rs.getString("sendername");
			String receivername = rs.getString("receivername");
			String header = rs.getString("header");
			String content = rs.getString("content");
			Timestamp sendtime = rs.getTimestamp("sendtime");
			Timestamp receivetime = rs.getTimestamp("receivetime");
			boolean sended = rs.getBoolean("sended");
			boolean readed = rs.getBoolean("readed");
			
			msg = new Message(msgid, senderid, receiverid, sendername, receivername, header, content, sendtime, receivetime, sended, readed);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return msg;
	}
	
	public static int updateMessage(Message msg) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "update message set receivetime=?,readed=? where msgid=? and receiverid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setTimestamp(1, msg.getReceivetime());
		ps.setBoolean(2, msg.isReaded());
		ps.setInt(3, msg.getMsgid());
		ps.setString(4, msg.getReceiverid());
		int rs = ps.executeUpdate();
		ps.close();
		conn.close();
		return rs;
	}
	public static int deleteMessageById(int msgid) throws SQLException {
		Connection conn = Conn.getConnection();
		String sql = "delete from message where msgid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, msgid);
		int rs = ps.executeUpdate();
		ps.close();
		conn.close();
		return rs;
	}
}
