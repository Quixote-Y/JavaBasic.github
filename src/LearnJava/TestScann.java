package LearnJava;

import java.util.Scanner;//����scanner��

public class TestScann {
	
	public static void main(String[] args) 
	{
		
		
		//�˴��и����⣬������������֣���ô�ڶ���scann.nextline�ͻ�ʧЧ�����ǿ��ܺͻ����������йء�-->
		Scanner scan = new Scanner(System.in);
		System.out.println("������������ ");
		String name = scan.nextLine();
		System.out.println("�����ǣ� "+name);
		System.out.println("\n\n");
		System.out.println("���������ݣ� ");
		int data = scan.nextInt();
		System.out.println("���ݣ� "+data);
		
		
		//�ر�scan��
		scan.close();
		
		
		
	}

}
