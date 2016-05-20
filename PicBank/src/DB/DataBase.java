package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	//数据库 驱动 地址 用户名 密码
	public static final String URL="jdbc:mysql://localhost:3306/pic";
	public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	public static final String USER="root";
	public static final String PWD="";
	
	public Connection conn=null;
	public PreparedStatement pst=null;
	
	public static ResultSet rs=null;
	//链接数据库
	public void OpenConnection(){
		try{
			Class.forName(DRIVER_NAME);
			conn=DriverManager.getConnection(URL,USER,PWD);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//是否存在数据
	public boolean IsExist(String sql) throws SQLException{
		OpenConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	//获取数据集
	public ResultSet GetDataSet(String sql) throws SQLException{			
		OpenConnection();	
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();			
		return rs;	
	}
	//更新数据  insert update delete
	public void UpdateData(String sql) throws SQLException{
		OpenConnection();
		pst=conn.prepareStatement(sql);
		pst.executeUpdate();
	}
	//更新数据  insert update delete
	public boolean UpdateData(String sql,int a) throws SQLException{
		OpenConnection();
		pst=conn.prepareStatement(sql);
		int i=pst.executeUpdate();
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

}
