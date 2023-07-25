package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ExceptionThrows {

	public void f1()  /*throws FileNotFoundException*/{
		//����һ���ļ�������
		//1.�����һ��FileNotFoundException �������쳣�����봦��������ᱨ��
		//2.����ʹ��try-catch
		//3.ʹ��throws�׳��쳣���õ�����������ķ���ȥ����
		//4.����ֱ���׳�exception�����������쳣��
		//5.Ҳ���Ը���һ���쳣������
		try {
			FileInputStream fis=new FileInputStream("d://aa.txt");
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public static void f2() {
		//����f3����
		try {
			f3();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//����Ĵ�����һ������ڵģ���Ϊf3�����׳���һ�������쳣�������쳣
		//����Ա������
		//���������ѡ��1.try-catch-finally
		//               2.�����׳��쳣���²�
	}
	public static void f3() throws FileNotFoundException{//f3�׳�һ�������쳣
		FileInputStream fis=new FileInputStream("d://aa.txt");
	}
	
	public static void f4() {
		//����f5����
		f5();
		//���ԶԱ�����ı����쳣��������û�б���ģ���Ϊ����ʱ�쳣��������Ҫ��
		//����Ա������ʽ�������Ĭ�ϵĴ������throws
	}
	public static void f5() throws RuntimeException{//�׳�һ������ʱ�쳣
	}
	
}


class Father {
	public void fun() throws RuntimeException{
		//�׳�����ʱ�쳣
	}
}
class Son extends Father{
	//������д���෽��ʱ��
	//���׳����쳣Ҫô�ڸ���һ�£�ҪôΪ�����׳��쳣��������
	@Override
	public void fun() throws NullPointerException {
		//�׳���ָ���쳣������ʱ�쳣��һ��
		//�����޸�ΪFileNotFoundException������ʱ�쳣����ᷢ���������
	}
}