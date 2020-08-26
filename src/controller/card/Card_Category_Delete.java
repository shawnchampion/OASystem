package controller.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CardCategory;
import dao.CardCategoryDao;
import dao.CardDao;

/**
 * Servlet implementation class Card_Category_Delete
 */
@WebServlet("/Card_Category_Delete")
public class Card_Category_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Card_Category_Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ccid = Integer.parseInt(request.getParameter("ccid"));
		int rs = 0;
		try {
			CardCategory cc = CardCategoryDao.selectCardCategoryById(ccid);
			rs = CardCategoryDao.deleteCardCategory(cc);
			CardDao.updateCategory(cc, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		String resp = "<script>alert(\"É¾³ýSTATUS\");window.location.href='Card_Category';</script></html>";
		if (0 == rs) {
			resp = resp.replace("STATUS", "Ê§°Ü");
		}else if (1 == rs) {
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
