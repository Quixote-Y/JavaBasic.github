package reflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Practice1 {

	public static void main(String[] args) throws Exception {
		//��������ȡ�����
		Class<?> testClass=Class.forName("reflectionTest.PrivateTest");
		//ʵ����
		Object tmp=testClass.newInstance();
		
		//��ȡ˽������
		Field name=testClass.getDeclaredField("name");
		//��ΪҪ�޸�ֵ������,���ԣ���������ᱨ����˽�����Բ����ȱ���
		//System.out.println(name.get(testClass));
		name.setAccessible(true);//����
		name.set(tmp, "Bob");
		Method getName=testClass.getDeclaredMethod("getName");//û�в���������ֻ�����־Ϳ����ˣ�����в�������Ӳ���.class
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
