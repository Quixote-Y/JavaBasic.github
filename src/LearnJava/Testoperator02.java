package LearnJava;
/**
 * *������������Ԫ�������
 * @author 86136
 *
 */

public class Testoperator02 {
	
	public static void main(String[] args) {
		int score = 80;
		//��ǰʽ����ʱ���Ϊ��ǰֵ������Ϊ��ֵ
		String a = score<60 ? "������" : "����";//!!!�𾪣���ֵ����������ʹ��
		
		System.out.println(a);
		
		
		int x =-100;
		int flag = x>0 ? 1 : (x==0 ? 1 : -1);
		System.out.println(flag);
	}

}
