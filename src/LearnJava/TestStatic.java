package LearnJava;
/**
 * 测试static
 * @author 86136
 *
 */
public class TestStatic {

	int id;
	String name;
	int pwd;
	
	static String school;//静态成员变量
	
	
	//静态成员初始化块
	static {
		System.out.println("启动静态初始化块");
		school="XD";
		printSchool();
	}
	//就算是main方法里没有任何提及也会触发，类加载时就会执行，
	//继承构造函数的使用顺序和静态初始化块执行顺序是一样的、
	//随着类的加载而执行，并且只会执行一次
	
	
	//普通代码块
	{
		System.out.println("调用普通代码块");
	}
	//每创建一个对象就会执行一次
	
	
	TestStatic(int id,String name,int pwd){
		this.id=id;
		this.name=name;
		this.pwd=pwd;
	}
	
	public void login(){
		System.out.println(name);
		System.out.println(school);//调用静态成员变量
	}
	
	public static void printSchool() {
		//login();//调用非静态成员函数报错i
		//System.out.println(name);调用非静态成员变量报错
		System.out.println(school);//调用静态成员变量
	}
	
	public static void main(String[] args) {
		TestStatic.printSchool();//通过类名直接调用静态成员函数
		TestStatic a=new TestStatic(1,"yang",123);
		a.login();
		school="xidian";//直接修改静态成员变量、
		TestStatic.printSchool();//通过类名直接调用静态成员函数
		
		TestStatic b =new TestStatic(2,"li",231);
		//每创建一次对象都会执行一次普通代码快
	}
 }
