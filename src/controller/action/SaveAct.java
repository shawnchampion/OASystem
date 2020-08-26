package controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Act;
import dao.ActDao;


/**
 * Servlet implementation class AddWorkplan
 */
@WebServlet("/SaveAct")
public class SaveAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String actname=request.getParameter("actname");
		String acttime=request.getParameter("acttime");
		String endtime=request.getParameter("endtime");
		String empname=request.getParameter("empname");
		String actbody=request.getParameter("actbody");
		Act act=new Act(actname,acttime,endtime,empname,actbody);
		ActDao adao=new ActDao();
		adao.saveAct(act);
		Integer in=(Integer)request.getSession().getAttribute("cur");
		int cur=1;
		if(in!=null){
			cur=in.intValue();
		}
		//request.getRequestDispatcher("/workplan/workPlan.jsp").forward(request, response);
		request.getRequestDispatcher("/SelectWorkAll2?cur=1").forward(request, response);
	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
