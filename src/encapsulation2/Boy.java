package encapsulation2;
/**
 * 此为测试属性标识符生效范围，此为不同包的子类
 * @author 86136
 *
 */
import encapsulation.Person;

public class Boy extends Person{

	public void play() {
		//System.out.println(testPrivate);
		//System.out.println(testDefault);//无法访问private和default类
		System.out.println(testProtected);
		System.out.println(testPublic);
		
		Person a1=new Person();
		//System.out.println(a1.testPrivate);
		//System.out.println(a1.testDefault);
		//System.out.println(a1.testProtected);
		System.out.println(a1.testPublic);
	}
	
	//关于protected的一些细节：
	//1.如果父类和子类在同一个包里，则子类可以访问父类的protected成员，
	//也可以访问父类对象的protected成员
	//2.如果父类和子类不在同一个包里，则子类可以访问父类的protected成员，而
	//不能访问父类对象的protected成员。
	
	

}
