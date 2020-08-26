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
		//��Բ�ͬϵͳ��ɫ���ò�ͬsql��ѯ���
		if ("����Ա".equals(role)){
			//System.out.println("���ڲ�ѯ����Ա");
			sql = "select ampass from admin where amid=?";
		}else if ("�쵼".equals(role)){
			//System.out.println("���ڲ�ѯ�쵼");
			sql = "select pass from employee where posid in ('02','03') and empid=?";
		}else if ("ְԱ".equals(role)){
			//System.out.println("���ڲ�ѯְԱ");
			sql = "select pass from employee where posid='01' and empid=?";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		//System.out.println(rs.getString(1));
		//��ȡ�������û�������жԱ�
		if (rs.next() && pass.equals(rs.getString(1))){
			confirmed = true;
		}
		rs.close();
		ps.close();
		conn.close();
		return confirmed;
	}
}
