package array;

import java.util.Arrays;

//����Object[][]��ά����洢���
public class arrayObject {
	
	public static void main(String[] args) {
		System.out.println("ѧ��\t����\t����\tѧУ\t����");
		
		//Object,������ĸ��࣬Object[],һ�����������飬����ֻ��Ŷ���
		//���ȣ��ַ�����һ������Ҫnew�8������������Ͳ��Ƕ���
		//��java�и��Զ�װ����ƣ����Զ�������ת��Ϊ����������������������������
		Object[] a1= {1,"����",18,"����","2003"};
		Object[] a2= {2,"����",14,"����","2004"};
		Object[] a3= {3,"����ǿ",19,"����","2005"};
		Object[] a4= {4,"������",17,"����","2006"};
		
		Object[][] emps =new Object[4][];
		emps[0]=a1;
		emps[1]=a2;
		emps[2]=a3;
		emps[3]=a4;
		//�����ͽ�����������Ϣ�洢��object��ά��������
		for(Object[] t:emps) {
			System.out.println(Arrays.toString(t));
		}
		
	}

}
