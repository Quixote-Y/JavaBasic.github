package LearnJava;
/**
 * ���������Զ�ת����ǿ������ת��
 * @author 86136
 *
 */
public class TestOperator04 {
	
	public static void main(String[] args) {
		
		//����С�����Ϳ����Զ�ת��Ϊ�����������
		int a =2345;
		long b =a;
		//int c = b;//����long�����Զ�ת��Ϊint
		double d = b;
		float f =b ;
		
		//���У����ͳ�����int���ͣ��������Զ�ת��Ϊ��byte/short/char
		//��ֵ���ܳ�����Ӧ������ֵ��Χ��byte��-128--127
		//int h0 =123;
		//byte h1 =h0;����
		byte h0 =123;
		//byte h1 =1234;����
		
		char h2 =97;//a��ascall��
		System.out.println(h2);
		
		
		//ǿ������ת��
		double cast1 = 3.123321;
		int cast2= (int) cast1;//����С������
		System.out.println(cast2);
		
		//��ǿ��ת����ֵ���ʱ���һ���޹�ֵ
		//������ʶ�𱨴�byte cast3 =(int)300;
		
		//�������
		int money = 1000000000;//10��
		int years =20;
		
		int total = money*years;//�����Ѿ������total�Ǹ���
		System.out.println("total   "+total);
		//һ������������
		long total2 = money*years;
		System.out.println("total2  "+total2);
		//��Ϊ�Ҳ�����Ѿ�������ڸ�ֵ����
		
		//��ȷ�ⷨ
		long total3 = 1L*money*years;//1L���Ҳ����ݼ���ת��Ϊlong����
		System.out.println("total3  "+total3);
		//���߰��Ҳ����һ������ǿ����������ת��Ϊlong
		
	}

}