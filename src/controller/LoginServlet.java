package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String role = request.getParameter("role");
		//System.out.println(role);
		String userid = request.getParameter("userid");
		//System.out.println(userid);
		String pass = request.getParameter("pass");
		request.getSession().setAttribute("userid", userid);
		boolean confirmed = false;
		try {
			confirmed = LoginDao.confirm(role, userid, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (confirmed == true){
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("role", role);
			if (role.equals("职员"))
				response.sendRedirect("staff.jsp");
			else if (role.equals("领导"))
				response.sendRedirect("leader.htm");
			else if (role.equals("管理员"))
				response.sendRedirect("admin.htm");
		}
		else{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.append("<!DOCTYPE html>");
			out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			out.append("<script>alert(\"账号密码错误\");window.location.href='login.jsp';</script></html>");
			out.flush();
			out.close();
			//request.setAttribute("loginResult", "fail");
			//request.getRequestDispatcher("login_index.jsp").forward(request, response);
		}
	}

}
