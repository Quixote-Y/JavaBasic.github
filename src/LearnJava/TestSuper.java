package LearnJava;
/**
 * �̳��൱���ڸ����������һ��Ĥ��������д�ķ��������棬������Ĳ�������ʧ�������ͨ��
 * �������е���super�ؼ��������ʸ��������
 * ÿ�����캯���о������ڵ�һ�е���super����������û����ʽ���������Ҳ���Զ�����
 * ���Ի���ּ̳�����׷�ݣ�������ù��캯��ʱ������׷�ݣ�Ȼ��Ӹ���ʼִ�й��캯��
 * ��̬��ʼ����Ҳ�����
 * super�ؼ���
 * @author 86136
 *
 */
public class TestSuper {

	public static void main(String[] args) {
		FatherClass f1=new FatherClass();
		ChildClass c1=new ChildClass();
		f1.f();
		System.out.println("\n");
		c1.f();
	}
}

class FatherClass{

	public int value;
	public int age;
	
	public void f() {
		value=100;
		System.out.println("����father��f()");
		
	}
	
}
class ChildClass extends FatherClass{
	public int value;
	public int age;
	public void f() { 
		super.f();//���ø����f()����
		value=200;
		System.out.println("���������f()");
		System.out.println("�����valueΪ��"+value);
		System.out.println("�����valueΪ�� "+super.value);
	}
	
	public void f2() {
		
	}
}