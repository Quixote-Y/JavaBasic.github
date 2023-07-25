package reflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Practice1 {

	public static void main(String[] args) throws Exception {
		//创建，获取类对象
		Class<?> testClass=Class.forName("reflectionTest.PrivateTest");
		//实例化
		Object tmp=testClass.newInstance();
		
		//获取私有属性
		Field name=testClass.getDeclaredField("name");
		//因为要修改值，爆破,不对，连输出都会报错，对私有属性操作比爆破
		//System.out.println(name.get(testClass));
		name.setAccessible(true);//爆破
		name.set(tmp, "Bob");
		Method getName=testClass.getDeclaredMethod("getName");//没有参数，所以只用名字就可以了，如果有参数就添加参数.class
		getName.setAccessible(true);
		System.out.println(getName.invoke(tmp));
	}
}
class PrivateTest{
	private String name="hellokitty";
	public String getName() {
		return name;
	}
}
