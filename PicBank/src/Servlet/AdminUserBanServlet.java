package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.AdminDAO;

/**
 * Servlet implementation class AdminUserBanServlet
 */
@WebServlet("/AdminUserBanServlet")
public class AdminUserBanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserBanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid= Integer.parseInt(request.getParameter("uid"));
		int status=Integer.parseInt(request.getParameter("status"));
		try{
			if(status==1){
				if(AdminDAO.banUser(uid, status)){
					response.sendRedirect("AdminUserListServlet");
				}
			}else if(status==0){
				if(AdminDAO.banUser(uid, status)){
					response.sendRedirect("AdminUserListServlet");
				}
			}
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
