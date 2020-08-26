package controller.work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Act;
import dao.ActDao;


/**
 * Servlet implementation class UpdateWorkplan2
 */
@WebServlet("/UpdateWorkplan2")
public class UpdateWorkplan2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWorkplan2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		int actid=Integer.parseInt(request.getParameter("actid"));
		String actname=request.getParameter("actname");
		String acttime=request.getParameter("acttime");
		String endtime=request.getParameter("endtime");
		//String empsname=request.getParameter("empsname");
		String actbody=request.getParameter("actbody");
		Act act=new Act(actid,actname,acttime,endtime,/*empsname,*/actbody);
		ActDao adao=new ActDao();
		adao.updateAct(act);
		Integer in=(Integer)request.getSession().getAttribute("cur");
		int cur=1;
		if(in!=null){
			cur=in.intValue();
		}
		request.getRequestDispatcher("/SelectWorkAll2?cur="+cur).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
