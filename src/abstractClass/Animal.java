package abstractClass;
/**
 * ������ʹ��Ҫ�㣺
 * 1.�ɳ��󷽷�����ֻ�ܶ���Ϊ������
 * 2.�����಻��ʵ�������Ȳ�����new��ʵ��������
 * 3.��������԰������ԣ����������췽���������췽��������newʵ������ֻ�ܱ��������
 * 4.������ֻ�ܱ������̳�
 * 5.���󷽷����뱻����ʵ��
 * @author 86136
 *
 */
public abstract class Animal {//�����������������Ϊ������

	int age;
	public abstract void run();//ֻ�к�����û��ʵ��
	public abstract void reset();
	
	public void shout() {
		System.out.println("Animal shout");
	}
	
	Animal(){
		System.out.println("������Animal���췽������");
	}
}


class Dog extends Animal{
//�̳е��������ʵ�ֳ�������ĳ��󷽷�
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void reset() {
		// TODO �Զ����ɵķ������
		
	}
	Dog(){
		System.out.println("����Dog���캯�����ã�");
	}
}
