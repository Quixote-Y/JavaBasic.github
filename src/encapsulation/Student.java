package encapsulation;
/**
 * 测试属性标识符的范围，此为Person同一包里的类
 * @author 86136
 *
 */
public class Student extends Person{

	public void study() {
		//System.out.println(testPrivate);子类不能调用父类的private
		System.out.println(testDefault);
		System.out.println(testProtected);
		System.out.println(testPublic);
	}
}
