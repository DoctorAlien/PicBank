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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String password=request.getParameter("reg_pass");
		if(Common.isNullString(username)||Common.isNullString(password)){
			response.sendRedirect("../action.html?action=regFull");
//			String msg="×¢²áÊ§°Ü!Çë¼ì²éÓÃ»§ÃûÃÜÂë";
//			request.setAttribute("msg", msg);
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}else{
			if(UsersDAO.userRegister(username, password,1)){
				response.sendRedirect("../action.html?action=regSuccess");
			}else{
				response.sendRedirect("../action.html?action=regFailed");
			}
//			String msg="×¢²á³É¹¦!";
//			request.setAttribute("msg", msg);
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
			
		}
	}

}
