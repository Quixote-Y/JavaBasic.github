package LearnJava;

public class User {
	private int id;
	private String name;
	private boolean done;
	//成员属性一般都写为私有类
	
	
	//生成相应的get，set接口来让外部调用数据
	//可以直接编译器生成
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
	
	//生成构造函数
	public User(int id, String name, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.done = done;
	}
	
	

}
