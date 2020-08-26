package controller.personalInfo;

import java.io.IOException;
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
 * Servlet implementation class PersonalInfo_Others
 */
@WebServlet("/PersonalInfo_Others")
public class PersonalInfo_Others extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalInfo_Others() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * for (Employee emp: list){ System.out.println(emp.getEmpid()); }
		 */
		request.setAttribute("deptname", deptname);
		request.setAttribute("name", name);
		request.setAttribute("emps", emps);
		request.setAttribute("depts", depts);
		request.setAttribute("total", total);
		request.setAttribute("cur", cur);
		request.getRequestDispatcher("PersonalInformation/personalInfo_Others.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
