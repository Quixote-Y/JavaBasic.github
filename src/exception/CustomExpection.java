package exception;
//自定义异常
//throws在方法声明处，后面是异常类型
//throw在方法中，后面跟的是异常对象
public class CustomExpection {

	public static void main(String[] args) {
		int age =231;
		//要求范围在10---120，否则抛出一个异常
		if(!(age>=10&&age<=120)) {
			throw new AgeException("你的年龄不对，需要在10--120之间");
		}
		System.out.println("年龄正确");
	}
	//运行结果：
	/*
	 * Exception in thread "main" exception.AgeException: 你的年龄不对，需要在10--120之间
	  at exception.CustomExpection.main(CustomExpection.java:9)

	 */
}
//自定义一个异常类AgeException
//继承RuntimeException为运行时异常，继承Exception为编译异常
//一般使用RuntimeException,因为可以使用默认的异常抛出机制，更加简单
class AgeException extends RuntimeException{
	public AgeException(String message) {//建立一个构造器就可以啦
		super(message);//关键在这
	}
}
