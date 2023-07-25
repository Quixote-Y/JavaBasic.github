package testInterface;
/**
 * 接口默认方法
 * @author 86136
 *
 */
public interface TestInterfaceDefault {

	/*public abstract*/void printf();
	
	
	//默认方法
	default void moren() {
		System.out.println("进入默认方法");
		//调用静态方法
		testStatic();
	}
	
	//静态方法
	//静态方法只能通过接口类去调用，而不能通过实现接口的对象去调用
	//静态方法中不能调用默认方法，但默认方法里可以调用静态方法
	public static void testStatic() {
		System.out.println("进入静态方法");
	}
	
}
