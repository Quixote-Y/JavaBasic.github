package testInterface;
/**
 * �ӿڳ�����
 * @author 86136
 *
 */
//���нӿ�
public interface Volant {

	public static final int Fly_DISTANCE =100;
	/*public static final */int Fly_HIGHT =100;//�ӿ��еĳ���Ĭ����ֻ����
	                                            //public static final��ʽ,д��д��һ��
	/*public abstract*/ void fly();//���󷽷�
	
}
//�����ӿ�
interface Honest {
	void helpOther();

}

class GoodMan implements Honest{
//���Ա������Զ���ӣ�ʵ�ֽӿڵ������ʵ�ֽӿڣ�implements
	@Override
	public void helpOther() {
		// TODO �Զ����ɵķ������
		
		System.out.println("���˷������̹���·");
		
	}
	
}

class BirdMan implements Volant{

	@Override
	public void fly() {
		// TODO �Զ����ɵķ������
		System.out.println("BirdFly");
	}
	
}

class Angel implements Volant,Honest{
//ʵ�������ӿ�
	@Override
	public void helpOther() {
		// TODO �Զ����ɵķ������
		System.out.println("angel��������");
		
	}

	@Override
	public void fly() {
		// TODO �Զ����ɵķ������
		System.out.println("angel��");
	}
	
}

class Plane implements Volant{

	@Override
	public void fly() {
		// TODO �Զ����ɵķ������
		System.out.println("�ɻ����");
	}
	
}

