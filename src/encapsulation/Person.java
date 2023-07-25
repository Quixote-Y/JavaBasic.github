package encapsulation;
/**
 * 测试属性标识符的范围此为1
 * @author 86136
 *
 */

public class Person {

	private    int testPrivate;
	           int testDefault;//上什么都不加就是defaul类
	protected  int testProtected;
	public     int testPublic;
	
	public void study() {
		System.out.println(testPrivate);
		System.out.println(testDefault);
		System.out.println(testProtected);
		System.out.println(testPublic);//同一个类里所有熟悉均可直接调用
	}
}
