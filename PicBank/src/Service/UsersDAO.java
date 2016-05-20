package Service;

import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Common;
import DB.DataBase;

public class UsersDAO {
	private static DataBase db=new DataBase();
	//�û���¼
	public static boolean userLogin(String user_name,String password){
		try{
			//MD5����
			password=Common.getMD5(password.getBytes());
			//String sql="select * from t_users_base where user_name ="+user_name+" and password_ ="+password;
			String sql="select * from t_users_base where user_name='"+user_name+"' and password_ ='"+password+"'"; 
			if(db.IsExist(sql)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//�û�ע��
	public static void userRegister(String user_name,String password){
		try{
			//��ȡʱ��
			long now=System.currentTimeMillis();
			//��ȡIP
			InetAddress address = InetAddress.getLocalHost();
			String ip=address.getHostAddress();
			//MD5����
			password=Common.getMD5(password.getBytes());
			//String sql="insert into t_users_base values('"+user_name+"','"+password+"'"+ip+"','"+now+"')";
			String sql="INSERT INTO `pic`.`t_users_base` (`uid`, `user_name`, `password_`, `user_ip`, `reg_time`, `status_`) VALUES (NULL, '"+user_name+"', '"+password+"', '"+ip+"', '"+now+"', '1')";
			db.UpdateData(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//�û�ע�� boolean
	public static boolean userRegister(String user_name,String password,int a){
		try{
			//��ȡʱ��
			long now=System.currentTimeMillis();
			//��ȡIP
			InetAddress address = InetAddress.getLocalHost();
			String ip=address.getHostAddress();
			//MD5����
			password=Common.getMD5(password.getBytes());
			//String sql="insert into t_users_base values('"+user_name+"','"+password+"'"+ip+"','"+now+"')";
			String sql="INSERT INTO `pic`.`t_users_base` (`uid`, `user_name`, `password_`, `user_ip`, `reg_time`, `status_`) VALUES (NULL, '"+user_name+"', '"+password+"', '"+ip+"', '"+now+"', '1')";
			if(db.UpdateData(sql,1)){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	//�����û�����
	public static void userChangePWD(String user_name,String old_pass,String new_pass){
		try{
			old_pass=Common.getMD5(old_pass.getBytes());
			new_pass=Common.getMD5(new_pass.getBytes());
			String sql="update `t_users_base` set `password_`='"+new_pass+"' WHERE user_name='"+user_name+"' and password_='"+old_pass+"'";
			db.UpdateData(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//�ж��û��Ƿ����
	public static boolean isBan(String user_name) throws SQLException{
		String sql="select * from `t_users_base` where user_name='"+user_name+"' and `status_`=0";
		if(db.IsExist(sql)){
			return true;
		}else{
			return false;
		}
	}
	//�Ƿ���й���ԱȨ��
	public static boolean IsAdmin(String user_name) throws SQLException{
		String sql="select * from `t_users_admin` as a where a.uid=(select uid from t_users_base as u where u.user_name='"+user_name+"' and u.status_=1) and a.status_=1";
		if(db.IsExist(sql)){
			return true;
		}else{
			return false;
		}
	}
	//�û��ϴ�ͼƬ
	public static void uploadImg(String username,String url){
		try{
			//��ȡʱ��
			long now=System.currentTimeMillis();
			
			String sql="INSERT INTO `t_images_base`(`uid`, `img_url`, `up_time`) VALUES ((select uid from t_users_base where user_name='"+username+"'),'"+url+"',"+now+")";
			db.UpdateData(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//����û�ͼ���б�
	public static ResultSet displayImg(String username) throws SQLException{
		String sql="select * from `t_images_base` where uid=(select uid from `t_users_base` where user_name ='"+username+"') and status_=1";
		return db.GetDataSet(sql);
	}
	//��ȡ���е��û�������ͼƬ
	public static ResultSet displayImgAll(String username) throws SQLException{
		String sql="select * from `t_images_base` where uid=(select uid from `t_users_base` where user_name ='"+username+"')";
		return db.GetDataSet(sql);
	}
	//ɾ��ͼƬ
	public static boolean delPic(int iid) throws SQLException{
		String sql="delete from `t_images_base` where `iid`="+iid;
		if(db.UpdateData(sql, 1)){
			return true;
		}else{
			return false;
		}
	}
	//�༭ͼƬ״̬
	public static boolean editPic(int iid,int status) throws SQLException{
		String sql="update `t_images_base` set `status_`="+status+" where iid="+iid;
		if(db.UpdateData(sql, 1)){
			return true;
		}else{
			return false;
		}
	}
	
}
