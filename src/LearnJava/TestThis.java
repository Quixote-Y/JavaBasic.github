package LearnJava;
/**
 * this����ʹ��
 * @author 86136
 *
 */
public class TestThis {

	int a,b,c;
	//�޲ι��캯��
	TestThis(){
		System.out.println("�����޲ι��캯����");
	}
	//��������
	TestThis(int a,int b){
		this.a=a;
		this.b=b;
		System.out.println("������2�ι��캯����"+a+b);
	}
	//���캯�����ù��캯��
	TestThis(int a,int b,int c){
		this();//�����޲ι��캯��,�����Ǻ����ĵ�һ������
		this.a=a;
		this.b=b;
		this.c=c;
		System.out.println("����3�ι��캯��"+a+b+c);
	}
	
	//������
	public static void main(String[] args) {
		new TestThis();
		new TestThis(2,3);
		new TestThis(1,2,3);
	}
}
