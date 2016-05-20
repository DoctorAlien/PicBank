package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Common;
import Entity.Users;
import Service.UsersDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Users u=new Users();
		String username=request.getParameter("login_name");
		String password=request.getParameter("login_pass");
		if(Common.isNullString(username)||Common.isNullString(password)){
			response.sendRedirect("../action.html?action=loginNull");
		}else{
			u.setUser_name(username);
			u.setPassword(password);
			if(UsersDAO.userLogin(u.getUser_name(), u.getPassword()))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				try {
					if(UsersDAO.IsAdmin(username)){
						System.out.println("Admin");
						response.sendRedirect("../admin/DashBoardServlet");
					}else{
						if(UsersDAO.isBan(username)){
							response.sendRedirect("../action.html?action=loginBaned");
						}else{
							response.sendRedirect("../DisplayServlet");
						}
						
						//System.out.println("Not Admin");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				System.out.println("failed");
				response.sendRedirect("../action.html?action=loginFailed");
			}
		}
	}
	

}
