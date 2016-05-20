package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class AdminUserListServlet
 */
@WebServlet("/AdminUserListServlet")
public class AdminUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserListServlet() {
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
			ResultSet userList=AdminDAO.getUserList();
			ArrayList uid =new ArrayList();
			ArrayList username1 =new ArrayList();
			ArrayList password =new ArrayList();
			ArrayList userip =new ArrayList();
			ArrayList regtime =new ArrayList();
			ArrayList status =new ArrayList();
			
			while(userList.next()){
				uid.add(userList.getString("uid"));//�û����
				username1.add(userList.getString("user_name"));//�û���
				password.add(userList.getString("password_"));//�û�����
				userip.add(userList.getString("user_ip"));//ע��ip
				regtime.add(userList.getString("reg_time"));//ע��ʱ��
				status.add(userList.getString("status_"));//�û�״̬
			}
			
			int length=uid.size();
			
			//ʱ���תʱ���ʽ
			//Long[] dateStr=new Long[length];
			//for(int i=0;i<length;i++){
			//	dateStr[i]=Long.parseLong(regtime.get(i).toString());
			//}
			//for(int i=0;i<length;i++){			
			//	Date date=new Date(dateStr[i]);
			//	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//	String str=format.format(date);
			//	System.out.println(str);
			//}
			//System.out.println(Common.convertDate(regtime, length));
						
			request.setAttribute("uid", uid);
			request.setAttribute("username1", username1);
			request.setAttribute("userip", userip);
			request.setAttribute("regtime", Common.convertDate(regtime, length));
			request.setAttribute("status", Common.convertStatus(status, length));
			request.setAttribute("length", length);
			//request.setAttribute("dateStr", dateStr);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
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
