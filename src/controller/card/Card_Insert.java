package controller.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Card;
import dao.CardDao;

/**
 * Servlet implementation class Card_Insert
 */
@WebServlet("/Card_Insert")
public class Card_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Card_Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userid = (String) request.getSession().getAttribute("userid");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String position = request.getParameter("position");
		String ccname = request.getParameter("ccname");
		String phone = request.getParameter("phone");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		Card card = new Card(0,userid, name, company, position, phone, telephone, email, ccname);
		
		int rs = 0;
		try {
			rs = CardDao.insertCard(card);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		String resp = "<script>alert(\"新建STATUS\");window.location.href='URL';</script></html>";
		if (0 == rs) {
			request.getSession().setAttribute("card", card);
			resp = resp.replace("STATUS", "失败").replace("URL", "Card_New");
		}else if (1 == rs) {
			request.getSession().removeAttribute("card");
			resp = resp.replace("STATUS", "成功").replace("URL", "Card_Box");
			//System.out.println(resp);
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
