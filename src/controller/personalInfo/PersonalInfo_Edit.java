package controller.personalInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmpDao;

/**
 * Servlet implementation class PersonalInfo_Edit
 */
@WebServlet("/PersonalInfo_Edit")
public class PersonalInfo_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInfo_Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String empid = (String) request.getSession().getAttribute("userid");
		String name = request.getParameter("name");
		String pos = request.getParameter("pos");
		String dept = request.getParameter("dept");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String introduction = request.getParameter("introduction");
		Employee emp = new Employee(empid, pos, dept, null, name, sex, age, email,
			phone, telephone, address, hobby, introduction);
		try {
			int rs = EmpDao.update(emp);
			if (1 == rs){
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.append("<!DOCTYPE html>");
				out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
				out.append("<script>alert(\"ÐÞ¸Ä³É¹¦\");window.location.href='PersonalInfo_Self';</script></html>");
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Map<String, String[]> pm = request.getParameterMap();
		for (Map.Entry<String, String[]> entry: pm.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue()[0]);
		}
		*/
	}

}
