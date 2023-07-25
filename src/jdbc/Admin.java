package jdbc;

public class Admin {//这就是javaBean，属性和数据库的表结构映射，用于存放相应的返回结果集 

	private String king;
	private String password;
	public Admin(String king, String password) {
		super();
		this.king = king;
		this.password = password;
	}
	public Admin() {
		super();
	}
	public String getKing() {
		return king;
	}
	public void setKing(String king) {
		this.king = king;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "\nAdmin [king=" + king + ", password=" + password + "]";
	}
	
}
