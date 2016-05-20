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
 * Servlet implementation class ChangePWD
 */
@WebServlet("/ChangePWD")
public class ChangePWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePWDServlet() {
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
			response.sendRedirect("../user.jsp");
		}else{
			if(UsersDAO.userLogin(username, old_pass)){
				UsersDAO.userChangePWD(username, old_pass, new_pass);
				response.sendRedirect("../index.jsp");
			}else{
				response.sendRedirect("../user.jsp");
			}	
		}
	}

}
