package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DataBase;

public class AdminDAO {
	static DataBase db=new DataBase();
	//获取图片数量
	public static ResultSet  getImgCount() throws SQLException{
		String sql="select count(`uid`) from `t_images_base`";
		return db.GetDataSet(sql);
	}
	//获取用户数量
	public static ResultSet getUsersCount() throws SQLException{
		String sql="select count(`uid`) from `t_users_base`";
		return db.GetDataSet(sql);
	}
	//获取Userlist
	public static ResultSet getUserList() throws SQLException{
		String sql="select * from `t_users_base`";
		return db.GetDataSet(sql);
	}
	//编辑用户
	public static boolean editUser(String uid,String username,String password,int status) throws SQLException{
		int uid1=Integer.parseInt(uid);
		String sql="update `t_users_base` set `password_`='"+password+"',`status_`="+status+"  where uid="+uid1+" and user_name='"+username+"'";
		return db.UpdateData(sql, 1);
	}
	//删除用户
	public static boolean deleteUser(String uid) throws SQLException{
		int uid1=Integer.parseInt(uid);
		String sql="delete from `t_users_base` where uid="+uid1;
		return db.UpdateData(sql, 1);
	}
	//获取PicList
	public static ResultSet getImgList() throws SQLException{
		//String sql="select * from `t_images_base";
		String sql="select i.iid,u.user_name,u.uid,i.img_url,i.up_time,i.status_ from `t_images_base` as i,`t_users_base` as u where i.uid=u.uid";
		return db.GetDataSet(sql);
	}
	//删除图片
	public static boolean deleteImg(int iid) throws SQLException{
		String sql="delete from `t_images_base` where `iid`="+iid;
		return db.UpdateData(sql, 1);
	}
	//禁用/启用 用户
	public static boolean banUser(int uid,int status) throws SQLException{
		String sql="update `t_users_base` set `status_`="+status+" where `uid`="+uid;
		if(db.UpdateData(sql, 1)){
			return true;
		}else{
			return false;
		}
	}
}
