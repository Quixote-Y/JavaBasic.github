package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ExceptionThrows {

	public void f1()  /*throws FileNotFoundException*/{
		//创建一个文件流对象
		//1.会产生一个FileNotFoundException ，编译异常，必须处理，不处理会报错
		//2.可以使用try-catch
		//3.使用throws抛出异常，让调用这个方法的方法去处理
		//4.可以直接抛出exception，包含所有异常类
		//5.也可以跟随一个异常参数表
		try {
			FileInputStream fis=new FileInputStream("d://aa.txt");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void f2() {
		//调用f3（）
		try {
			f3();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//这里的错误是一定会存在的，因为f3（）抛出了一个编译异常，编译异常
		//程序员必须解决
		//在这里可以选择：1.try-catch-finally
		//               2.继续抛出异常给下层
	}
	public static void f3() throws FileNotFoundException{//f3抛出一个编译异常
		FileInputStream fis=new FileInputStream("d://aa.txt");
	}
	
	public static void f4() {
		//调用f5（）
		f5();
		//可以对比上面的编译异常，这里是没有报错的，因为运行时异常编译器不要求
		//程序员必须显式解决，有默认的处理机制throws
	}
	public static void f5() throws RuntimeException{//抛出一个运行时异常
	}
	
}


class Father {
	public void fun() throws RuntimeException{
		//抛出运行时异常
	}
}
class Son extends Father{
	//子类重写父类方法时：
	//所抛出的异常要么于父类一致，要么为父类抛出异常的字类型
	@Override
	public void fun() throws NullPointerException {
		//抛出空指针异常，运行时异常的一种
		//倘若修改为FileNotFoundException：编译时异常，便会发生编译错误
	}
}