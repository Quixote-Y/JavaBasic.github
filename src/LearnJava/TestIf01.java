package LearnJava;
/**
 * һ����������Ϸ
 * @author 86136
 *
 */
import java.math.*;//����math��.random�������������
public class TestIf01 {

	public static void main(String[] args) {
		
		//�������������
		int i = (int)(Math.random()*6)+1;//random�������һ��double���͵�С������0-1������1��ת��Ϊint����ȡ��
		int j = (int)(Math.random()*6)+1;
		int k = (int)(Math.random()*6)+1;
		
		int count = i+j+k;
//      switch(count) {
//		case 1 : System.out.println();
//		case 2 :
//		default :
//	    }switch�����ڶ�ֵ
		
		System.out.println(count);
		if(count>15) {
			System.out.println("good");
		}
		else if(count>=10) {
			System.out.println("simple");
		}
		else {
			System.out.println("bad");
		}
	}
}
