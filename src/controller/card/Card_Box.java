package controller.card;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Card;
import bean.CardCategory;
import dao.CardCategoryDao;
import dao.CardDao;

/**
 * Servlet implementation class Card_Box
 */
@WebServlet("/Card_Box")
public class Card_Box extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Card_Box() {
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
		List<Card> cards = null;
		List<CardCategory> categories = null;
		String ccname = request.getParameter("ccname");
		String name = request.getParameter("name");
		//System.out.println(ccname);
		//System.out.println(name);
		try {
			if ("È«²¿".equals(ccname)) {
				ccname=null;
			}
			if ("".equals(name)) {
				name = null;
			}
			cards = CardDao.selectCardByOwner(userid,ccname,name);
			categories = CardCategoryDao.selectCardCategoryByOwner(userid, 1, 999);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cards", cards);
		request.setAttribute("ccname", ccname);
		request.setAttribute("name", name);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("card/card_box.jsp").forward(request, response);
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
