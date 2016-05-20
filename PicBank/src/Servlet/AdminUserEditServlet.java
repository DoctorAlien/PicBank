package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Common;
import Service.AdminDAO;

/**
 * Servlet implementation class AdminUserEditServlet
 */
@WebServlet("/AdminUserEditServlet")
public class AdminUserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserEditServlet() {
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
		String uid=request.getParameter("uid");
		String username=request.getParameter("username");
		String password=Common.getMD5(request.getParameter("password").getBytes());
		int status=Integer.parseInt(request.getParameter("status"));
		
		try {
			if(Common.isNullString(uid)||Common.isNullString(username)||Common.isNullString(password)){
				response.sendRedirect("action.html?action=editNullFailed");
			}else{
				if(AdminDAO.editUser(uid, username, password,status)){
					response.sendRedirect("action.html?action=editSuccess");
				}else{
					response.sendRedirect("action.html?action=editFailed");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
