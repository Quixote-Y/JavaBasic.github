package array;
//���Զ�ά����
import java.util.Arrays;
public class array2Wei {

	public static void main(String[] args) {
		//��̬��ʼ��
		int[][] a= {
				{1,2,3},
				{2,4},
				{3,4,5,6,7,8,9},
				{1}
		};//������һ����ά����
		//System.out.println(Arrays.toString(a));
		//Arrays.toStringֻ��ת��һά���飻
		for(int[] t:a) {
			System.out.println(Arrays.toString(t));
		}
		//��̬��ʼ��
		//java�ж�ά����������ͳ�ʼ��Ӧ�ôӵ�ά����λ��˳�����
		int[][] b=new int[4][];//��ȷ��һά�Ĵ�С
		b[0]=new int[2];
		b[1]=new int[2];
		b[3]=new int[3];
		b[2]=new int[10];//�ص����ڲ���c�Ķ�ά������һ�������ľ��󣬶��Ƕ�ά���Բ�һ����
		//�������
		b[0][0]=100;
		b[0][1]=200;//....�Դ����������ֵ
		
		
		//��̬ʱ��ά�ĳ�ʼ������������
		int[][] c=new int[3][];
		
		c[0]=new int[] {1,2};
		c[1]=new int[] {2,3,4,4};
		//c[2]=new int[] {3,4,5,6,7,8,3};
		//�״�����Ҫnewһ���µ����鸳��һά�����鳣�������ʼ������ʹ��
		//System.out.println(Arrays.toString(b));
		//System.out.println(Arrays.toString(c));
		for(int[] t:b) {
			System.out.println(Arrays.toString(t));
		}
		for(int[] t:c) {
			System.out.println(Arrays.toString(t));
		}
	}
}
