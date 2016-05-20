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

import Service.AdminDAO;

/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stsub
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		try{
			//获取图片数量
			ResultSet imgCount=AdminDAO.getImgCount();
			ArrayList  counts1=new ArrayList();
			if(imgCount.next()){
				counts1.add(imgCount.getString(1));
			}
			request.setAttribute("imgsCount", counts1);
			//获取用户数量
			ResultSet usersCount=AdminDAO.getUsersCount();
			ArrayList counts2=new ArrayList();
			if(usersCount.next()){
				counts2.add(usersCount.getString(1));
			}
			request.setAttribute("usersCount", counts2);
			request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
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
