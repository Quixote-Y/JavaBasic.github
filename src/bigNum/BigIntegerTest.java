package bigNum;

import java.math.BigInteger;

//BigInteger�÷�
public class BigIntegerTest {

	public static void main(String[] args) {
		//���������ݴ�longҲ�޷�װ�ص�ʱ������ʹ��BigInteger����
		
		BigInteger bigInteger=new BigInteger("21321323299999999999999");
		BigInteger bigInteger2=new BigInteger("100");
		System.out.println(bigInteger);
		//��BigInteger�ļӼ��˳���������ʹ����Ӧ�ķ���������ֱ���������
		
		BigInteger add=bigInteger.add(bigInteger2);
		System.out.println(add);//��
		System.out.println(bigInteger.subtract(bigInteger2));//��
		System.out.println(bigInteger.multiply(bigInteger2));//��
		System.out.println(bigInteger.divide(bigInteger2));//��
		
	}
}
