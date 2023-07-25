package LearnJava;
/**
 * 重写toString
 * @author 86136
 *
 */
public class TestToString {

	int number;
	String name;
	
	TestToString(int a,String b){
		number=a;
		name=b;
	}
	//可以编译器直接生成，右键单机找到源码，点击生成tostring方法
	@Override
	public String toString() {
		return "TestToString [number=" + number + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		TestToString s1=new TestToString(1,"yang");
		System.out.println(s1.toString());
		
		//toString为object类的成员方法，所有的类都可以调用是所有类的父类
		//没重写的tostring
		//public String toString() {
        //return getClass().getName() + "@" + 
		//Integer.toHexString(hashCode());
        //}
		
		
		
		
	}
}
