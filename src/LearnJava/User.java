package LearnJava;

public class User {
	private int id;
	private String name;
	private boolean done;
	//��Ա����һ�㶼дΪ˽����
	
	
	//������Ӧ��get��set�ӿ������ⲿ��������
	//����ֱ�ӱ���������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	//���ɹ��캯��
	public User(int id, String name, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.done = done;
	}
	
	

}
