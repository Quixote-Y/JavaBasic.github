package jdbc;

public class Admin {//�����javaBean�����Ժ����ݿ�ı�ṹӳ�䣬���ڴ����Ӧ�ķ��ؽ���� 

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
