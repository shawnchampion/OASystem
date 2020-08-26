package controller.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import bean.Message;
import dao.EmpDao;
import dao.MessageDao;

/**
 * Servlet implementation class Message_Send
 */
@WebServlet("/Message_New")
public class Message_New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message_New() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("button");
		boolean sended = false;
		if ("·¢ËÍ".equals(action)) {
			sended = true;
		}else if ("´æ²Ý¸å".equals(action)) {
			sended = false;
		}
		String userid = (String) request.getSession().getAttribute("userid");
		String receiverid = request.getParameter("receiverid");
		String receivername = request.getParameter("receivername");
		String header = request.getParameter("header");
		String content = request.getParameter("content");
		Timestamp sendtime = new Timestamp(System.currentTimeMillis());
		
		int rs = 0;
		Message msg = null;
		try {
			Employee emp = EmpDao.selectEmpByNo(userid);
			String sendername = emp.getName();
			msg = new Message(0, userid, receiverid, sendername, receivername, header, content, sendtime, null, sended, false);
			rs = MessageDao.insertMessage(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		String resp = "<script>alert(\"ACTIONSTATUS\");window.location.href='message/message_new.jsp';</script></html>";
		resp = resp.replace("ACTION", action);
		if (0 == rs) {
			request.getSession().setAttribute("msg", msg);
			resp = resp.replace("STATUS", "Ê§°Ü");
		}else if (1 == rs) {
			request.getSession().removeAttribute("msg");
			resp = resp.replace("STATUS", "³É¹¦");
		}
		out.append(resp);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
