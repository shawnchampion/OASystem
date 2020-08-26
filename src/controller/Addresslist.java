package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Department;
import bean.Employee;
import dao.DeptDao;
import dao.EmpDao;

/**
 * Servlet implementation class Addresslist
 */
@WebServlet("/Addresslist")
public class Addresslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addresslist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		List<Employee> emps = null;
		List<Department> depts = null;
		//默认打开第一页
		int cur = 1;
		int pagesize = 3;
		int total = 1;
		//请求访问页面号
		String ccur = request.getParameter("ccur");
		if (null != ccur && !"".equals(ccur)) {
			cur = Integer.parseInt(ccur);
		}
		//System.out.println(ccur);
		String deptname = request.getParameter("select");
		String name = request.getParameter("name");
		String deptid = null;
		String submit2 = request.getParameter("submit2");
		//System.out.println(submit2);
		try {
			if (!"全部".equals(deptname) && null != deptname) {
				deptid = DeptDao.selectDeptByName(deptname).getDeptid();
			}
			if ("".equals(name)) {
				name = null;
			}
			//System.out.println(deptid);
			//System.out.println(name);
			depts = DeptDao.selectDeptAll();
			total = EmpDao.getTotalPage(deptid, name, pagesize);
			emps = EmpDao.selectEmpByDeptidName(deptid,name,cur,pagesize);
			if ("导出Excel".equals(submit2)) {
				int rs = EmpDao.downEmp(EmpDao.selectEmpByDeptidName(deptid,name,1,999));
				//System.out.println("导出成功");
				
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.append("<!DOCTYPE html>");
				out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
				String resp = "<script>alert(\"导出STATUS\");window.location.href='Addresslist';</script></html>";
				if (0 == rs) {
					resp = resp.replace("STATUS", "失败");
				}else if (1 == rs) {
					resp = resp.replace("STATUS", "成功");
				}
				out.append(resp);
				out.flush();
				out.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("deptname", deptname);
		request.setAttribute("name", name);
		request.setAttribute("emps", emps);
		request.setAttribute("depts", depts);
		request.setAttribute("total", total);
		request.setAttribute("cur", cur);

		request.getRequestDispatcher("addresslist/addresslist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
