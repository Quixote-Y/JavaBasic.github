package LearnJava;
/*
 * �ڲ���ʹ�ò���
 */
public class Outer {

	private int age =10;
	private static int sta=100;
	
	public void testNiInner(A a) {
		a.run();
	}
	public void show() {
		System.out.println("�ⲿ��.show");
		System.out.println(age);
	}
	
	//�����ڲ��࣬�൱��һ���ⲿ��ĳ�Ա�����Ա�ʶ���÷���ͬ��
	//public protected default private
	//�Ǿ�̬�ڲ��ࣺ
	//�ڲ����ܰ����о�̬����
	//�ⲿ������ڲ���Ҫ  new inner()
	//�ⲿ������ĵط����ʷǾ�̬�ڲ��ࣺ   
	//Outer.Inner ������ = new Outer().new Inner()
	public class Inner {
		int age=20;
		public void show() {
			System.out.println("�Ǿ�̬�ڲ���.show");
			System.out.println(age);
			//�Ǿ�̬�ڲ������ͨ��   �ⲿ����.this.����/����  ��ʹ���ⲿ��Ա
			
			System.out.println(Outer.this.age);
			Outer.this.show();
		}
	}
	
	
	
	//��̬���ڲ���
	//���ⲿ���ԣ��൱��һ����̬��Ա
	//�ⲿ���ʹ�þ�̬�ڲ��ࣺ new Outer.Inner()������Ǿ�̬�ڲ�����Ҫnew����
	static class Inner2{
		public void show() {
			System.out.println("��̬�ڲ���.show");
			//System.out.println(age);//age�ǷǾ�̬�������Ǿ�̬�ڲ��಻�ܷ���
			System.out.println(sta);//��̬�ڲ������ֱ�ӵ����ⲿ��ľ�̬�����ͷ���
		}
	}
	
	//�����ڲ��ࣺ
	//�����ڷ�������ڲ��࣬����������ڸ÷���
	public void show2() {
		class Inner3{
			public void fun() {
				System.out.println("���÷����ڲ���");
			}
		}
		new Inner3().fun();
	}
	
	public static void main(String[] args) {
		//���ø��Ǿ�̬�ڲ���
		Outer.Inner inner =new Outer().new Inner();
		System.out.println(inner.age);
		inner.show();
		//���þ�̬�ڲ���
		Outer.Inner2 inner2=new Outer.Inner2();
		inner2.show();
		//���������ڲ���
		Outer outer =new Outer();
		//outer.testNiInner(new AImpl());
		//����һ�������Ľӿڵ��ã�����newһ���ӿ�A��ʵ��������Ϊ����
		//ʹ�������ڲ�������Բ���
		outer.testNiInner(new A() {

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				System.out.println("��һ�������ڲ���");
			}
			
		});//ע�⿴�ṹ��newA����{�ӿ�ʵ��}������Ϊһ���������ݸ�testNiinner����
		//�൱�������λ�ô�����һ���࣬����໹�������Ľӿ�ʵ�֣�˼������ûʲô����
		//�����ֻ����ʹ��һ��
		outer.testNiInner(new A() {

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				System.out.println("�ڶ��������ڲ���");
			}
			
		});
		//���ú������ڲ���ķ���
		outer.show2();
	}
}


//����һ���ӿڣ������ӿڲ���ʵ���������뱻��̳���д����ʵ�����࣬
//�������ڲ���������һ��û�����Ƶ��ڲ��࣬���ڲ���ֻ��Чһ��
interface A{
	void run();
}
//ʵ�ֽӿ�A���࣬��������testNiinnerʱ���õ�
class AImpl implements A{

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		System.out.println("AImpl.run");
	}
	
}