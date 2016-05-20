package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Common;
import Service.AdminDAO;

/**
 * Servlet implementation class AdminPicListServlet
 */
@WebServlet("/AdminPicListServlet")
public class AdminPicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPicListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		
		try{
			ResultSet imgList=AdminDAO.getImgList();
			ArrayList iid=new ArrayList();
			ArrayList username1=new ArrayList();
			ArrayList uid=new ArrayList();
			ArrayList imgurl=new ArrayList();
			ArrayList uptime=new ArrayList();
			ArrayList status=new ArrayList();
			
			while(imgList.next()){
				iid.add(imgList.getString("iid"));
				username1.add(imgList.getString("user_name"));
				uid.add(imgList.getString("uid"));
				imgurl.add(imgList.getString("img_url"));
				uptime.add(imgList.getString("up_time"));
				status.add(imgList.getString("status_"));
			}
			int length=iid.size();
			
			request.setAttribute("iid", iid);
			request.setAttribute("username1", username1);
			request.setAttribute("uid", uid);
			request.setAttribute("imgurl", imgurl);
			request.setAttribute("uptime", Common.convertDate(uptime, length));
			request.setAttribute("status", Common.convertStatus(status, length));
			request.setAttribute("length", length);
			
			request.getRequestDispatcher("piclist.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
