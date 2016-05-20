package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Common;
import Service.UsersDAO;

/**
 * Servlet implementation class AdminAddPeopleServlet
 */
@WebServlet("/AdminAddPeopleServlet")
public class AdminAddPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddPeopleServlet() {
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
		String username=request.getParameter("reg_name");
		String password="111111";
		if(Common.isNullString(username)){
			response.sendRedirect("action.html?action=regFailed");
		}else{
			if(UsersDAO.userRegister(username, password,1)){
				response.sendRedirect("action.html?action=regSuccess");
			}else{
				System.out.println("failed");
			}
			
		}
	}

}
