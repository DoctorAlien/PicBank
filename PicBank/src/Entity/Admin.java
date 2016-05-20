package Entity;

public class Admin {
	private int aid;
	private int uid;
	private int level;
	private int status;
	
	public Admin(){}
	
	public Admin(int aid, int uid, int level, int status) {
		//super();
		this.aid = aid;
		this.uid = uid;
		this.level = level;
		this.status = status;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
