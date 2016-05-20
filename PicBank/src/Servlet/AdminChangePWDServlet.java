package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Common;
import Service.UsersDAO;

/**
 * Servlet implementation class AdminChangePWDServlet
 */
@WebServlet("/AdminChangePWDServlet")
public class AdminChangePWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePWDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String old_pass=request.getParameter("old_pass");
		String new_pass=request.getParameter("new_pass");
		if(Common.isNullString(username)||Common.isNullString(old_pass)||Common.isNullString(new_pass)){
			System.out.println("1");
			response.sendRedirect("setting.jsp");
		}else{
			if(UsersDAO.userLogin(username, old_pass)){
				UsersDAO.userChangePWD(username, old_pass, new_pass);
				System.out.println("2");
				response.sendRedirect("../index.jsp");
			}else{
				System.out.println("3");
				response.sendRedirect("setting.jsp");
			}	
		}
	}

}
