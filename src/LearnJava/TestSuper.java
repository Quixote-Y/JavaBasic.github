package LearnJava;
/**
 * 继承相当于在父类外面包了一层膜，子类重写的方法在外面，但父类的并不会消失，你可以通过
 * 在子类中调用super关键字来访问父类的内容
 * 每个构造函数中均会先在第一行调用super（）方法，没有显式定义编译器也会自动加上
 * 所以会出现继承树的追溯，子类调用构造函数时会向上追溯，然后从根开始执行构造函数
 * 静态初始化块也是如此
 * super关键字
 * @author 86136
 *
 */
public class TestSuper {

	public static void main(String[] args) {
		FatherClass f1=new FatherClass();
		ChildClass c1=new ChildClass();
		f1.f();
		System.out.println("\n");
		c1.f();
	}
}

class FatherClass{

	public int value;
	public int age;
	
	public void f() {
		value=100;
		System.out.println("调用father中f()");
		
	}
	
}
class ChildClass extends FatherClass{
	public int value;
	public int age;
	public void f() { 
		super.f();//调用父类的f()方法
		value=200;
		System.out.println("调用子类的f()");
		System.out.println("子类的value为："+value);
		System.out.println("父类的value为： "+super.value);
	}
	
	public void f2() {
		
	}
}