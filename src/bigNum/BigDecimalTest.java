package bigNum;
//������Ҫ����һ�����Ⱥܸߵ����ݣ�double����װ��ʱ��ʹ��BigDecimal

import java.math.*;
public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bigDecimal=new BigDecimal("1321.213231231239999999999099999");
		BigDecimal bigDecimal2=new BigDecimal("3");
		
		//tͬBigInteger����Ҫ��ָ���ķ���������
		System.out.println(bigDecimal.add(bigDecimal2));//��
		System.out.println(bigDecimal.subtract(bigDecimal2));//��
		System.out.println(bigDecimal.multiply(bigDecimal2));//��
		
		
		//�ڳ������������⣺
		//����������������������ô�죬�����һ�����޲�ѭ��С�����Ǿͻ�һֱִ�г�����
		//������׳������쳣�������Ҫ������ÿ�γ�����ʱ���о��ȿ���
		//bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_CEILING)---
		//---->��˼�ǣ����������������ȷ��������
		//System.out.println(bigDecimal.divide(bigDecimal2));//��
		
		System.out.println(bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_CEILING));
	}

}
