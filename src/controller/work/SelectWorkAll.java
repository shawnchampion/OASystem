package controller.work;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Act;
import dao.ActDao;

/**
 * Servlet implementation class SelectWorkAll
 */
@WebServlet("/SelectWorkAll")
public class SelectWorkAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectWorkAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c=request.getParameter("cur");
		int cur=1;
		if(c!=null&&!"".equals(c)){
			cur=Integer.parseInt(c);
		}//SelectActions
		int pagesize=5;	
		ActDao wdao=new ActDao();
		List<Act> list=wdao.selectActsByPage(cur, pagesize);
		request.setAttribute("acts", list);
		int total=wdao.getTotalPages(pagesize);
		request.getSession().setAttribute("cur", cur);//当前页放到范围内
		request.setAttribute("total", total);//总页数范围
		request.getRequestDispatcher("/workplan/pendingWork.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
