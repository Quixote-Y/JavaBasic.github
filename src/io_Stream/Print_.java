package io_Stream;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

//��ӡ�� PrintStream  ֱ�Ӹ��� FilterOutputStream  ʵ�ֽӿ� OutputStream   �ֽ���
//       PrintWriter  ʵ�ֽӿ�Writer      �ַ���
public class Print_ {

	public static void main(String[] args) throws IOException {
		
		PrintStream out=System.out;//System.out����PrintStream������
		//   public static final PrintStream out = null;
		out.println("���");
		//����ֱ�ӵ���
		//��Ĭ������£�PrintStream������ݵ�λ��Ĭ���Ǳ�׼���  ��ʾ��
		/*
		 public void print(String s) {
               write(String.valueOf(s));
           }
		 //Ҳ����˵��print�ĵײ�ʱʹ����PrintStream���write����������д������ʾ����
		 */  
		//������Ҳ����ֱ��ʹ��write�����Ϣ
		//��Ϊ���ֽ���������write��������Ĳ�����������byte[],���ֽڶ�ȡ
		
		out.write("�������".getBytes());//���ַ���ת��Ϊbyte����
		
		//out.close();
		//������ֱ�ӹر��ˣ����Ǻ���дPrintWriter��ʱ���֣����ض����console�����֪��զ�Ļ����ˣ�ֻ��
		//�������PrintStream��֮����setOutΪ��׼�����
		
		
		//���Կ����Ѿ���ӡ������
		
		//Ҳ�����ֶ��޸Ĵ�ӡ�������λ��/����
		System.setOut(new PrintStream("E:\\javaTestFile\\changeOut.txt"));//ʹ���ַ�����ַ����һ����ӡ����������Ϊ��ӡ��Ŀ���豸
		
		/*
		  public static void setOut(PrintStream out) {
                checkIO();
                setOut0(out);      //native�������޸����λ�� 
         }
		 */
		
		System.out.println("�������----��ӡ�ı�");
		
		//�ļ�����Ҳ�õ�����Ӧ����
		
		//������ض����console��
		System.setOut(out);
		System.out.println("�����ض������");
		
		//PrintWriter
		PrintWriter pw=new PrintWriter(System.out);//����һ����PrintWriter���󣬴������ΪPrintStream��Ķ���System.out����׼�����
		pw.println("�����ã������ַ���ӡ��");
		pw.close();
		
		PrintWriter pwFile=new PrintWriter(new PrintStream("E:\\javaTestFile\\changeOut.txt"));
		pwFile.println("��ã���ӡ���ļ���ַ���ӡ��");
		pwFile.close();//����رգ�writer��ֻ��flush�Ż�д���ļ�
		
		//�ر�out
		out.close();
		//��out���ˣ�pw�Ͳ���ӡ��
	}
}
