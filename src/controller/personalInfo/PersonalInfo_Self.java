package controller.personalInfo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmpDao;

/**
 * Servlet implementation class PersonInfo_Self
 */
@WebServlet("/PersonalInfo_Self")
public class PersonalInfo_Self extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInfo_Self() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = (String) request.getSession().getAttribute("userid");
		//System.out.println(request.getParameter("userid"));
		if (null != request.getParameter("userid")) {
			//访问他人个人页面
			userid = request.getParameter("userid");
			request.setAttribute("userid", userid);
		}
		try {
			Employee emp = EmpDao.selectEmpByNo(userid);
			//System.out.println(emp.getEmpid());
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("PersonalInformation/personalInfo_Self.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
