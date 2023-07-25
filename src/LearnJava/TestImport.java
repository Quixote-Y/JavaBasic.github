package LearnJava;
/**
 * 测试import导入操作
 * @author 86136
 *
 */
//import LearnJava.TestThis; 这是多此一举，TestThis为public类，
//同一个包中可以互相访问
//import java.lang.*;//这个包中包含有java基础的语法，像System.out之类的，
//java默认导入不用显示定义

//静态导入
import static java.lang.Math.*;//导入Math类中的所有静态方法
import static java.lang.Math.PI;//导入Math类中的PI属性

//如果不静态导入
//调用Math.random（）得输入Math.random（）；
//调用PI得Math.PI；通过类名去调用

public class TestImport {

	int a;
	 

	public static void main(String[] args) {
		new TestThis(1,2,3);
		System.out.println("This is import");
		
		//静态导入后
		System.out.println(PI);
		System.out.println(random());
		//不用在通过类名引用
		
	}
	
}
