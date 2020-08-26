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
 * Servlet implementation class Card_Update
 */
@WebServlet("/Card_Update")
public class Card_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Card_Update() {
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
		request.setCharacterEncoding("utf-8");
		String userid = (String) request.getSession().getAttribute("userid");
		String action = request.getParameter("button");
		System.out.println(action);
		int rs = 0;
		try {
			if ("移动".equals(action)) {
				int cid = Integer.parseInt(request.getParameter("cid"));
				String ccname = request.getParameter("ccname");
				Card card = CardDao.selectCardByOwnerCid(cid, userid);
				card.setCcname(ccname);
				rs = CardDao.updateCard(card);
			}else if ("提交".equals(action)) {
				int cid = Integer.parseInt(request.getParameter("cid"));
				String name = request.getParameter("name");
				String company = request.getParameter("company");
				String position = request.getParameter("position");
				String phone = request.getParameter("phone");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				String ccname = request.getParameter("ccname");
				
				Card card = new Card(cid, userid, name,company, position, phone, telephone, email, ccname);
				
				rs = CardDao.updateCard(card);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		String resp = "<script>alert(\"ACTIONSTATUS\");window.location.href='Card_Box';</script></html>";
		resp = resp.replace("ACTION", action);
		if (0 == rs) {
			resp = resp.replace("STATUS", "失败");
		}else if (1 == rs) {
			resp = resp.replace("STATUS", "成功");
		}
		out.append(resp);
		out.flush();
		out.close();
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
