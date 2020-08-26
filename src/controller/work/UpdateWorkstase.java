package controller.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActDao;

/**
 * Servlet implementation class UpdateWorkstase
 */
@WebServlet("/UpdateWorkstase")
public class UpdateWorkstase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateWorkstase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int actid = Integer.parseInt(request.getParameter("actid"));

		ActDao adao = new ActDao();
		int rs = adao.finishAct(actid);
		Integer in = (Integer) request.getSession().getAttribute("cur");
		int cur = 1;
		if (in != null) {
			cur = in.intValue();
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		String resp = "<script>alert(\"结束工作STATUS\");window.location.href='SelectWorkplan?cur=CUR';</script></html>";
		resp = resp.replace("CUR", String.valueOf(cur));
		if (0 == rs) {
			resp = resp.replace("STATUS", "失败");
		}else if (1 == rs) {
			resp = resp.replace("STATUS", "成功");
		}
		out.append(resp);
		out.flush();
		out.close();
		//request.getRequestDispatcher("SelectWorkAll?cur=" + cur).forward(request, response);
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
