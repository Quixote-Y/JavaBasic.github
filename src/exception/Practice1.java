package exception;

import java.util.Scanner;

//����û�������Ĳ�������������ʾ���������룬ֱ������һ������Ϊֹ
public class Practice1 {
	
	public static void main(String[] args) {
	
		int num;
		System.out.println("������һ�������� ");
		for(;;) {
	        try {
	        	
		        Scanner scanner = new Scanner(System.in);//System.in
		        num = scanner.nextInt();
		        break;//tryʱ�����쳣�Ͳ��ټ�������ִ���ˣ�û�����쳣�Ż��������
	        } catch (Exception e) {
		        // TODO: handle exception
	        	System.out.println("������������������������룺");
	    	    continue;
	        }
		}
		System.out.println(num);
	}
}
//���̣����̣�������


//Ҳ����
//String input=""; //�ַ���Ҫ��ʼ��������������
//input=scanner.next();//������������������ȵ��ַ����洢����
//num=Inter.parseInteger(input);//ʹ�õ�������ʱ��ת���쳣�������Ļ��͸�����ȷ