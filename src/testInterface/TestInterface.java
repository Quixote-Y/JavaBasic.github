package testInterface;
/**
 * �ӿ�һЩҪ�㣺
 * 1.�ӿ���ֻ���г�������Ĭ����public static final���ӿ��еķ���ֻ����public abstract
 * Ҳ��ʡ��
 * 2.�ӿڿ��Զ�̳У���ʵ�֣�
 * 3.����ͨ��Implements��ʵ�ֽӿڹ淶
 * 4.�ӿڲ��ܴ���ʵ�����������������ñ�������
 * 5.һ����ʵ���˽ӿڣ�����ʵ�ֽӿ��е����з�����������Щ����ֻ����public��
 * @author 86136
 *
 */
public class TestInterface {

	public static void main(String[] args) { 
		Angel p =new Angel();
		p.fly();
		p.helpOther();
		System.out.println(Volant.Fly_DISTANCE);
		
		//4.�ӿڲ��ܴ���ʵ�����������������ñ�������
		Volant v=new Angel();//�൱�ڸ������ָ���������
		v.fly();
		//v.heleOther();//helpOther�ڽӿ�Voalnt��û��
		Angel a=(Angel)v;//ǿ������ת��
		a.helpOther();
	}
}
