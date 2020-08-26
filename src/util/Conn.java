package util;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conn {
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动，实例化driver这个类
			String url="jdbc:mysql://localhost:3306/test";
			Connection con=DriverManager.getConnection(url, "root", "123456");
			if(con!=null){
				//System.out.println(ip + ":数据库连接成功");
				return con;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public static void main(String[] args) {
	
}
}
