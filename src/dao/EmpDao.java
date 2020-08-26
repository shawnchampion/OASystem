package dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import bean.Employee;
import util.Conn;

public class EmpDao {
	
	//计算总页数，根据每页多少行
	public static int getTotalPage(String deptid, String name, int pagesize) throws SQLException {
		List<Employee> list = selectEmpByDeptidName(deptid, name, 1, 999);
		int t=list.size();
		return (t%pagesize==0) ? (t/pagesize) : (t/pagesize+1);
	}
	
	public static List<Employee> selectEmpByDeptidName(String deptid, String name, int cur, int pagesize) throws SQLException{
		Connection conn = Conn.getConnection();// 连接
		String sql = "select * from employee ";
		PreparedStatement ps = null;
		
		if (null == deptid && null == name){
			sql += "limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cur-1)*pagesize);
			ps.setInt(2, pagesize);
		}
		if (null != deptid && null == name) {
			sql += "where deptid=? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deptid);
			ps.setInt(2, (cur-1)*pagesize);
			ps.setInt(3, pagesize);
		}
		if (null == deptid && null != name) {
			sql += "where name like ? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, '%'+name+'%');
			ps.setInt(2, (cur-1)*pagesize);
			ps.setInt(3, pagesize);
		}
		if (null != deptid && null != name) {
			sql += "where deptid=? and name like ? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, deptid);
			ps.setString(2, '%'+name+'%');
			ps.setInt(3, (cur-1)*pagesize);
			ps.setInt(4, pagesize);
		}
		//System.out.println(sql);
		
		ResultSet rs = ps.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while(rs.next()){
			Employee emp = result2Employee(rs); 
			list.add(emp);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	public static List<Employee> selectEmpAll() throws SQLException{
		Connection conn = Conn.getConnection();// 连接
		String sql = "select * from employee";
		PreparedStatement ps = conn.prepareStatement(sql);
		//System.out.println(sql);
		
		ResultSet rs = ps.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while(rs.next()) {
			Employee emp = result2Employee(rs);
			list.add(emp);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return list;
	}
	public static Employee selectEmpByNo(String empid) throws SQLException {
		Employee emp = null;
		Connection conn = Conn.getConnection();// 连接
		String sql = "select * from employee where empid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, empid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String posid = rs.getString("posid");
			String pos = PosDao.selectPosById(posid).getName();
			String deptid = rs.getString("deptid");
			String dept = DeptDao.selectDeptById(deptid).getName();
			String name = rs.getString("name");
			String pass = rs.getString("pass");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String telephone = rs.getString("telephone");
			String address = rs.getString("address");
			String hobby = rs.getString("hobby");
			String introduction = rs.getString("introduction");
			
			emp = new Employee(empid, pos, dept, pass, name, sex, age, email, phone, telephone, address, hobby, introduction);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return emp;
	}
	
	public static int update(Employee emp) throws SQLException{
		Connection conn = Conn.getConnection();
		
		//更新数据，密码单独更新
		String posid = PosDao.selectPosByName(emp.getPos()).getPosid();
		String deptid = DeptDao.selectDeptByName(emp.getDept()).getDeptid();
		String sql = "update employee set name=?, posid=?, deptid=?, introduction=?, sex=?, age=?, email=?, phone=?, telephone=?, address=?, hobby=? where empid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setString(2, posid);
		ps.setString(3, deptid);
		//ps.setString(4, emp.getPass());
		ps.setString(4, emp.getIntroduction());
		ps.setString(5, emp.getSex());
		ps.setInt(6, emp.getAge());
		ps.setString(7, emp.getEmail());
		ps.setString(8, emp.getPhone());
		ps.setString(9, emp.getTelephone());
		ps.setString(10, emp.getAddress());
		ps.setString(11, emp.getHobby());
		ps.setString(12, emp.getEmpid());
		
		int rs = ps.executeUpdate();
		
		//更新密码
		if (null != emp.getPass()){
			sql = "update employee set pass=? where empid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getPass());
			ps.setString(2, emp.getEmpid());
			rs += ps.executeUpdate();
		}
		
		ps.close();
		conn.close();
		return rs;
	}
	
	private static Employee result2Employee(ResultSet rs) throws SQLException{
			String empid = rs.getString("empid");
			String posid = rs.getString("posid");
			String pos = PosDao.selectPosById(posid).getName();
			String deptid = rs.getString("deptid");
			String dept = DeptDao.selectDeptById(deptid).getName();
			String name = rs.getString("name");
			String pass = rs.getString("pass");
			String sex = rs.getString("sex");
			int age = rs.getInt("age");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String telephone = rs.getString("telephone");
			String address = rs.getString("address");
			String hobby = rs.getString("hobby");
			String introduction = rs.getString("introduction");
			
			Employee emp = new Employee(empid, pos, dept, pass, name, sex, age, email, phone, telephone, address, hobby, introduction);
			return emp;
	}
	 public static int downEmp(List<Employee> list) throws Exception
		{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("员工表");
			HSSFRow row = sheet.createRow(0);
			HSSFCellStyle  style = wb.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			HSSFCell cell = row.createCell((short)0);
			cell.setCellValue("员工编号");
			cell.setCellStyle(style);
			cell = row.createCell((short) 1);
			cell.setCellValue("职务");
			cell.setCellStyle(style);
			cell = row.createCell((short) 2);
			cell.setCellValue("部门");
			cell.setCellStyle(style);
			cell = row.createCell((short) 3);
			cell.setCellValue("名字");
			cell.setCellStyle(style);
			cell = row.createCell((short) 4);
			cell.setCellValue("性别");
			cell.setCellStyle(style);
			cell = row.createCell((short) 5);
			cell.setCellValue("年龄");
			cell.setCellStyle(style);
			cell = row.createCell((short) 6);
			cell.setCellValue("电子邮件");
			cell.setCellStyle(style);
			cell = row.createCell((short) 7);
			cell.setCellValue("办公电话");
			cell.setCellStyle(style);
			cell = row.createCell((short) 8);
			cell.setCellValue("移动电话");
			cell.setCellStyle(style);
			cell = row.createCell((short) 9);
			cell.setCellValue("住址");
			cell.setCellStyle(style);
			
			for(int i=0;i < list.size();i++)
			{
				row = sheet.createRow((int) i+1);
				Employee emp = (Employee) list.get(i);
				row.createCell((short)0).setCellValue(emp.getEmpid());
				row.createCell((short)1).setCellValue(emp.getPos());
				row.createCell((short)2).setCellValue(emp.getDept());
				row.createCell((short)3).setCellValue(emp.getName());
				row.createCell((short)4).setCellValue(emp.getSex());
				row.createCell((short)5).setCellValue(emp.getAge());
				row.createCell((short)6).setCellValue(emp.getEmail());
				row.createCell((short)7).setCellValue(emp.getPhone());
				row.createCell((short)7).setCellValue(emp.getTelephone());
				row.createCell((short)8).setCellValue(emp.getAddress());
			}
			try {  
				 FileOutputStream fout = new FileOutputStream("c:\\emp.xls");  
				   wb.write(fout);  
				   fout.close();  
			}  
			catch (Exception e) {  
					e.printStackTrace();   
					return 0;
			}
			
			return 1;
		}
	/*
	 * 删除emp
	 * 
	 */
	public int delete(String deptid) throws SQLException {
		Connection conn = Conn.getConnection();// 连接
		
		String sql = "delete from employee where empid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, deptid);
		int i = ps.executeUpdate();
		
		return i;
	}
}
