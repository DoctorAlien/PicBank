package Entity;

public class Users {
	private int uid;
	private String user_name;
	private String password;
	private String user_ip;
	private int reg_time;
	private int status;
	
	public Users(){}
	
	public Users(int uid, String user_name, String password, String user_ip,
			int reg_time, int status) {
		//super();
		this.uid = uid;
		this.user_name = user_name;
		this.password = password;
		this.user_ip = user_ip;
		this.reg_time = reg_time;
		this.status = status;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public int getReg_time() {
		return reg_time;
	}
	public void setReg_time(int reg_time) {
		this.reg_time = reg_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
