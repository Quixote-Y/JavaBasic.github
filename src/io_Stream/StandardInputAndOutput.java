package io_Stream;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//��׼���������
public class StandardInputAndOutput {

	public static void main(String[] args) {
		//System.in
		//������public static final InputStream in = null;
        //        ���������ǣ�InputStream        ���������ǣ�BufferedInputStream
		//System.in ��׼������         Ĭ���ǣ�����
		System.out.println(" ���������ǣ�"+System.in.getClass());
		//System.out
		//������    public static final PrintStream out = null;
		//       ���������ǣ�PrintStream        ���������ǣ�PrintStream
		//System.out  ��׼����          Ĭ���ǣ���ʾ��
		System.out.println("���������ǣ�"+System.out.getClass());
		
		Scanner sc=new Scanner(System.in);//����һ����׼������������Scanner�����֪��ȥ����Ѱ����������
		System.out.println("���������ݣ�");
		System.out.println(sc.next());
		//����PrintStream��println�������������ʾ����ȥ
		
	}
}
