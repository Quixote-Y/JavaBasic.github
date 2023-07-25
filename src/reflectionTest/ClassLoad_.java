package reflectionTest;

import java.lang.reflect.Method;
import java.util.Scanner;


//类加载机制
public class ClassLoad_ {

	public static void main(String[] args) throws Exception {
		/*1.静态加载：   在编译时加载所有相关的类，如果没有则报错，依赖性很强
		 *             像当你new一个对象，静态加载，当你编译时没有这个对象，那么就会直接给你报错，编译失败
		 *2.动态加载：   在运行时加载相关的类，如果运行时不用该类，则不报错，降低了依赖性
		 *
		 *类加载时机：
		 *        1.当创建对象时new  --静态加载
		 *        2.当子类被加载时，父类也加载 ---静态加载
		 *        3.调用类中的静态成员时     ----静态加载
		 *        4.通过反射                  -----动态加载		  
		 */
		/*  类加载三个阶段：（不是对象初始化，类加载！！！！）
		 *        1.加载：将类的class文件读入内存，将字节码文件转换为二进制字节流存入方法区，由ClassLoader类加载器将.class生成Class类对象，，此过程由类加载器完成
		 *        2.链接：  验证：文件安全性校验，
		 *                 准备：静态变量默认初始化（0，true，null等）和分配空间，如果是final类型的静态常量，直接赋值
		 *                 解析：符号引用转为直接引用，逻辑地址换物理地址
		 *         --》将类的二进制数据合并到JRE中
		 *        3.初始化：主要对静态成员变量按程序员给的值进行初始化赋值
		 *                 到初始化阶段才真正开始执行类中定义的java程序代码，此阶段执行<clinit>方法
		 *                 <clinit>方法编译器按语句在源文件中出现的顺序，依次收集类中所有的静态变量的赋值动作和静态代码块中的语句，进行合并（重复赋值取后者）
		 *                 在多线程环境中,多个线程取同时初始化一个类，只有一个线程会去执行这个类的<clinit>方法，其他线程都需要阻塞，这保证了一个类只有一个Class对象
		 */
		/* java程序从开始到运行的流程：
		 *        1.程序员写出.java文件
		 *        2.javac编译生成.class字节码文件
		 *        3.先是将字节码文件转换为二进制字节流存入方法区，由ClassLoader类加载器将.class生成Class类对象，引用方法区里的二进制元数据进行操作
		 *           这是类加载阶段
		 *        4.运行程序
		 * 
		 */
		
		
		
		//列如
		//Dog dog=new Dog();//想要编译通过就必须显式定义Dog类
		
		//动态加载
		Scanner scanner=new Scanner(System.in);
		String a=scanner.next();
		switch(a) {
		case "1":
			Class cls=Class.forName("reflectionTest.Dog");//显然没有这个类
			Object o=cls.newInstance();
			Method method=cls.getMethod("cry");//显然也没这个方法
			method.invoke(o);
			break;
		case "2":
			System.out.println("程序正常运行");
			break;
		default:
			System.out.println("ok");
		    break;
		}
	//运行一下程序就可以发现，只有在你输入1的时候，程序进入动态加载的时候才会抛出异常，如果输入其他的，程序正常进行
	}
	
}
