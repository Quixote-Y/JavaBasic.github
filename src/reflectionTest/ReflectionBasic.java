package reflectionTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;



/**
 * �������
 * @author 86136
 *
 */
public class ReflectionBasic {

	public static void main(String[] args) throws Exception {
		/*1.�����������������Reflection APIȡ���κ�����ڲ���Ϣ����Ա����Field��������Constructor����Ա����Method�ȣ������ܹ�������������Լ�����
		 *2.java�����ڼ��������3���׶Σ�
		 *   1.����׶Σ�������׶Σ�������Աд�´�������� ��.java�ļ��� ��.java�ļ�����Javac���룬���� ��.class�ֽ����ļ���
		 *               ����� ��.class�ֽ����ļ���Ͱ���������ԣ��������������ȣ����ֽ������ʽ�洢��
		 *   
		 *   2.Class��׶Σ������ؽ׶Σ�������׶��� ��.class�ļ������������ClassLoader �ڶ��м�������һ�� Class�����
		 *                   Ȼ������������class�ļ��ĳ�Ա���� ת��Ϊ һ��Field���� field���飬
		 *                   �� ������ ת��Ϊһ�� Constructor���� cons���飬��Ա���� ת��ΪMethod�������� 
		 *                   Class�������һ�����ݽṹ�����Բ�������Ķ���
		 *   3.Runtime���н׶Σ�������ҵ�������ڣ��������ʼִ��
		 *                   ��������������ɵĶ��󣬸ö����б����Լ����Ǹ�  Class�����  ������
		 *                    ��˿���ͨ��ʵ������������ҵ����� Class ��
		 *   Ӧ�ã�   ��ˣ������õ�Class�������ԣ�
		 *                    �������󣬵��ö��󷽷�
		 *                    �������Ե�
		 *   ����������ڵڶ��׶Σ�������ClassLoader���ص�ʱ��--------������
		 * 
		 *   
		 *   ClassҲ���࣬�̳�Object��
		 *   Class�������new�����ģ�����ϵͳ������
		 *   һ����ֻ��һ��Class������ֻ����һ��
		 *   �ڼ��ؽ׶Σ���.Class�ļ�����ClassLoader�е�classLoader��������������⣬�����ڷ�����������Ķ��������ݣ���Ϊ���Ԫ����
		 * 
		 *   �ڵ�һ��ʵ������ĵط����¶ϵ㣬׷��ȥ���Կ���ClassLoader��ļ��ط���Դ��
		 *     public Class<?> loadClass(String name) throws ClassNotFoundException {
                          return loadClass(name, false);
                    }
                 ֻ�е�һ��ʵ�������������ط�����ֻ��ʼ��һ��
		 * 
		 * 
		 * 
		 * 
		 */
		/*
		 * һ��ʾ����   ������÷�
		 *  һ��Peoperties�ļ���Ҫ������������������г��򣬵����ĸ�����Ǹ�����
		 */
		
		Properties pin=new Properties();
		pin.load(new FileInputStream("src\\reflectionTest\\re.properties"));
		String classfullpath=(String)pin.get("classfullpath");
		String methodName=(String)pin.get("method");
		System.out.println("classfullpath :"+classfullpath);
		System.out.println("methodName :"+methodName);
		
		//�Լ���һ��Ҫ���ʹ��������String����ȥ����һ��classfullpath"Cat"�����Ȼ���������methodName"hi"����
		
		//1.�����࣬����Class���͵�cls
		Class cls =Class.forName(classfullpath);
		
		//2.ͨ��cls�õ����ص��� classfullpath �Ķ����ʵ��
		Object o=cls.newInstance();
		System.out.println("o������ʱ���ͣ� "+o.getClass());
		
		//3.ͨ��cls�õ����ص��� methodName �� ����
		//�ڷ����У�����Զ��󣬷��������ԣ�������ȫ�Ƕ���
		
		Method method1=cls.getMethod(methodName);
		//ͨ��Method����method1���÷���
		System.out.println("========================");
		method1.invoke(o);//������Ƶ��÷��� ����.invoke(����)
		
		//�õ���ĳ�Ա����
		//Field name=cls.getField("name");//�ᱨ�����ܻ�ȡ˽�б���
		Field age=cls.getField("age");
		System.out.println(age.get(o));//��ͳд��������.��Ա���� �����䣺��Ա��������.get������
		
		//�õ�������
		Constructor constructor=cls.getConstructor();//()ָ�������������Ƿ����޲ι�����
		
		Constructor constructor2=cls.getConstructor(String.class,Integer.class);//ָ��������.classҲ�ǻ�ȡ��Ӧ��Class��
		
		
		//������ţ�
		//�����ŵ㣺���Զ�̬�Ĵ�����ʹ�ö��󣨿�ܵĵײ���ģ���ʹ�����
		//    ȱ�㣺 �����ǽ���ִ�У��ٶ���
		
		//�Ա�һ��
		//�����ҹ��˷�����������ֻ������ʱ��
		System.out.println("============���ܱȽ�==============");
		m1();
		m2();
		m3();
		
		
		//дһ�·�����ŵ�ԭ��Field Method Constructor �ȶ�ʵ����Accessible�࣬������ֶ���������Ϊtrue������
		//�ڷ���ʱ�ͻ�ȡ�����ʼ�飬��߷�������
	}
	public static void m1() {
		Cat cat=new Cat();
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			cat.hi();
		}
		long end =System.currentTimeMillis();
		System.out.println("��ͳ���û���ʱ�䣺"+(end-start));
	}
	public static void m2() throws Exception {
		Class cls=Class.forName("reflectionTest.Cat");
		Object o=cls.newInstance();
		Method hi=cls.getMethod("hi");
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			hi.invoke(o);//�������
		}
		long end =System.currentTimeMillis();
		System.out.println("������û���ʱ�䣺"+(end-start));
	}
	//�������
	public static void m3() throws Exception {
		Class cls=Class.forName("reflectionTest.Cat");
		Object o=cls.newInstance();
		Method hi=cls.getMethod("hi");
		hi.setAccessible(true);//�ڷ�����÷���ʱ��ȡ�����ʼ��
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			hi.invoke(o);//�������
		}
		long end =System.currentTimeMillis();
		System.out.println("������ź���û���ʱ�䣺"+(end-start));
	}
	
}
