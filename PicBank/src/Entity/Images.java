package Entity;

public class Images {
	private int iid;
	private int uid;
	private String img_url;
	private int up_time;
	private int status;
	
	public Images(){}
	
	public Images(int iid, int uid, String img_url, int up_time, int status) {
		//super();
		this.iid = iid;
		this.uid = uid;
		this.img_url = img_url;
		this.up_time = up_time;
		this.status = status;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getUp_time() {
		return up_time;
	}
	public void setUp_time(int up_time) {
		this.up_time = up_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
}
