package LearnJava;
/*
 * 内部类使用测试
 */
public class Outer {

	private int age =10;
	private static int sta=100;
	
	public void testNiInner(A a) {
		a.run();
	}
	public void show() {
		System.out.println("外部类.show");
		System.out.println(age);
	}
	
	//定义内部类，相当于一个外部类的成员，属性标识符用法相同，
	//public protected default private
	//非静态内部类：
	//内部不能包含有静态语句块
	//外部类访问内部类要  new inner()
	//外部类以外的地方访问非静态内部类：   
	//Outer.Inner 变量名 = new Outer().new Inner()
	public class Inner {
		int age=20;
		public void show() {
			System.out.println("非静态内部类.show");
			System.out.println(age);
			//非静态内部类可以通过   外部类名.this.属性/方法  来使用外部成员
			
			System.out.println(Outer.this.age);
			Outer.this.show();
		}
	}
	
	
	
	//静态·内部类
	//对外部而言，相当于一个静态成员
	//外部如何使用静态内部类： new Outer.Inner()，不像非静态内部类需要new两次
	static class Inner2{
		public void show() {
			System.out.println("静态内部类.show");
			//System.out.println(age);//age是非静态变量，非静态内部类不能访问
			System.out.println(sta);//静态内部类可以直接调用外部类的静态变量和方法
		}
	}
	
	//方法内部类：
	//定义在方法里的内部类，作用域仅限于该方法
	public void show2() {
		class Inner3{
			public void fun() {
				System.out.println("调用方法内部类");
			}
		}
		new Inner3().fun();
	}
	
	public static void main(String[] args) {
		//调用给非静态内部类
		Outer.Inner inner =new Outer().new Inner();
		System.out.println(inner.age);
		inner.show();
		//调用静态内部类
		Outer.Inner2 inner2=new Outer.Inner2();
		inner2.show();
		//调用匿名内部类
		Outer outer =new Outer();
		//outer.testNiInner(new AImpl());
		//这是一般正常的接口调用，必须new一个接口A的实现类来作为参数
		//使用匿名内部类则可以不用
		outer.testNiInner(new A() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println("第一个匿名内部类");
			}
			
		});//注意看结构，newA（）{接口实现}整体作为一个参数传递给testNiinner方法
		//相当于在这个位置创建了一个类，这个类还有完整的接口实现，思考起来没什么问题
		//这个类只存在使用一次
		outer.testNiInner(new A() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println("第二个匿名内部类");
			}
			
		});
		//调用含方法内部类的方法
		outer.show2();
	}
}


//定义一个接口，本来接口不能实例化，必须被类继承重写才能实例化类，
//但匿名内部类能生成一个没有名称的内部类，该内部类只生效一次
interface A{
	void run();
}
//实现接口A的类，正常调用testNiinner时调用的
class AImpl implements A{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("AImpl.run");
	}
	
}