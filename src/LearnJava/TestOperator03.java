package LearnJava;
/**
 * ���Է�>��>��
 * @author 86136
 *
 */
public class TestOperator03 {
	
	public static void main(String[] args) {
		
		//���ȼ������÷�
		boolean s1 = true,s2= true, s3=false;
		System.out.println(s1||s2&&s3);//�ǡ��롷���������������
		
		//����ʱӦ��ʹ��С����
		boolean s4= (3>1||4>3)&&(3<5);
		System.out.println(s4);
	}

}
