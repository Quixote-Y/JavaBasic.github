package testInterface;
/**
 * 测试jdk8以后接口中的新特性： 默认方法使用，静态方法的使用
 * @author 86136
 *
 */
public class TestDefault implements TestInterfaceDefault {

	//重写抽象接口
	@Override
	public void printf() {
		// TODO 自动生成的方法存根
		System.out.println("进入printf函数");
	}

	public static void testStatic() {
		System.out.println("进入实现类里的静态方法");
	}
	
	//接口中的默认函数可以重写也可以不重写
	public static void main(String[] args) {
		TestInterfaceDefault t =new TestDefault();
		t.moren();
		t.printf();
		
		//测试静态方法
		//t.testStatic();错误的，访问类中的静态方法用类名访问
		TestDefault.testStatic();
		//访问接口中的testStatic
		TestInterfaceDefault.testStatic();
		
		//注意：
		//实现类里的testStatci并不是接口里的静态方法的重写，他们没有关系，
		//通过接口的实现类无法访问接口的静态放法，只能通过接口名
	}
	
	
	
	
}
