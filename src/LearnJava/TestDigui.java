package LearnJava;
/**
 * �ݹ�׳�
 * @author 86136
 *
 */
public class TestDigui {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
		long result =factorial(20);
		long endTime = System.currentTimeMillis();
		System.out.println("�ݹ����� "+result);
		System.out.println("�ݹ��ʱ�� "+(endTime-startTime));
		
	}
	
	private static long factorial(int a) {
		if(a==1) {
			return 1;
		}
		else {
			return a*factorial(a-1);
		}
	}
}
