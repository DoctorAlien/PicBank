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
import Service.UsersDAO;

/**
 * Servlet implementation class DisplayBasicServlet
 */
@WebServlet("/DisplayBasicServlet")
public class DisplayBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		
		try{
			ResultSet img=UsersDAO.displayImgAll(username);
			
			ArrayList iid=new ArrayList();
			ArrayList uptime=new ArrayList();
			ArrayList status=new ArrayList();
			ArrayList url=new ArrayList();
			
			while(img.next()){
				iid.add(img.getString("iid"));
				uptime.add(img.getString("up_time"));
				status.add(img.getString("status_"));
				url.add(img.getString("img_url"));
			}
			int length=iid.size();
			request.setAttribute("iid", iid);
			request.setAttribute("uptime", Common.convertDate(uptime, length));
			request.setAttribute("status", Common.convertStatus(status, length));
			request.setAttribute("url", url);
			request.setAttribute("length", length);
			
			request.getRequestDispatcher("/user-basic.jsp").forward(request, response);
			
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
