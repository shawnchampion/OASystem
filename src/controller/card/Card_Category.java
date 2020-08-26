package controller.card;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CardCategory;
import dao.CardCategoryDao;


/**
 * Servlet implementation class Card_Category
 */
@WebServlet("/Card_Category")
public class Card_Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Card_Category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = (String) request.getSession().getAttribute("userid");
		List<CardCategory> list = null;
		//默认打开第一页
		int cur = 1;
		int pagesize = 3;
		int total = 1;
		//请求访问页面号
		String ccur = request.getParameter("ccur");
		if (null != ccur && !"".equals(ccur)) {
			cur = Integer.parseInt(ccur);
		}
		try {
			total = CardCategoryDao.getTotalPage(userid, pagesize);
			list = CardCategoryDao.selectCardCategoryByOwner(userid,cur,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ccur);
		request.setAttribute("total", total);
		request.setAttribute("cur", cur);
		request.setAttribute("categories", list);
		request.getRequestDispatcher("card/card_category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
