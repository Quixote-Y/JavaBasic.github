package wapper;

//��װ�����֪ʶ
public class Wapper {
  
	public static void main(String[] args) {
	/*
	 * boolean-->Boolean
	 * char-->Character
	 * byte-->Byte
	 * int-->Integer
	 * long-->Long
	 * short-->Short----------------------->����������Ķ��̳���Number����
	 * double-->Double
	 * float-->Float
	 */
	/*
	 * ��װ��ͻ����������͵�ת��   װ�䣺������������-->��װ���ͣ���֮�����䣬
	 * jdk5��ǰ���ֶ�װ��Ͳ���
	 * 
	 */
	//�ֶ�װ��
	//int-->Integer
	int n1 =100;
	Integer integer =new Integer(n1);
	Integer integer1=Integer.valueOf(n1);
	
	//�ֶ�����
    //Integer-->int
	int n2=integer.intValue();
	
	
	//jdk5֮������Զ�װ�����
	int n3=100;
	Integer integer2=n3;//�ײ���Ȼ��Integer integer1=Integer.valueOf(n1);
	//�Զ�����
	int n4=integer2;//�ײ�ʹ�õ���int n2=integer.intValue();
	
	//��Ԫ�������һ�����壬���������
	Object a =true? Integer.valueOf(1):Double.valueOf(2.0);//�����1.0�����Ȱ�
	//�����ture����ѡInteger.valueof(1),����Ԫ�������һ�����壬�����Զ������������
	//�ķ��򣬵���ΪDoubl���ͣ�1.0
	System.out.println(a);	
	Object b;
	if(true) {
		b=new Integer(1);
	}else {
		b=new Double(2.0);
	}
	System.out.println(b);//���1���Ƿֿ������Σ��������ת��
	}
}
