package io_Stream;
//ת����  InputStreamReader  OutputStreamWriter       -�ֽ���---���ַ���   ���ܸ��������ʽ
//

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransformationStream {

	public static void main(String[] args) throws IOException {
		String path ="E:\\javaTestFile\\story.txt";//�������ֶ�ȥ��stroy�ļ������Ϊutf-8
		//����һ�����ֽ���ȥ������
		FileInputStream fis=new FileInputStream(path);
		//��������
		byte[] data=new byte[1024];
		int len=0;
		while((len=fis.read(data))!=-1) {
			System.out.println(new String(data,0,len));
		}
		//���Կ�����������������
		//����ʹ��ת��������ת��Ϊ�ַ��������涨ʹ��Utf-8����
		//new InputStreamReader(fis, String)�����������
//		FileInputStream fis2=new FileInputStream(path);
//		InputStreamReader isr=new InputStreamReader(fis2, "UTF-8");
//		//Ȼ���InputStreamReader ��BufferedReader����װ����߶�ȡЧ��
//		BufferedReader bfr=new BufferedReader(isr);
		
		//�������һ��������һ�д���ֱ�ӽ��
		BufferedReader bfr=new BufferedReader(new InputStreamReader(
				                                  new FileInputStream(path),"utf-8"));
		
		//�ٴ����
		System.out.println("==============================");
		
		String datalen="";
		while((datalen=bfr.readLine())!=null) {
			System.out.println(datalen);
		}
		//��ʱ�������ȷ��
		bfr.close();
		//��OutputStreamWriter���ı��ļ����뷽ʽ
		String path2="E:\\javaTestFile\\OutputStreamWriter.txt";
		String charSet="gbk";
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(path2),charSet);//ָ���ַ�����
		osw.write("��ã�����");
		System.out.println("gbk�����ַ�����ɹ�");
		osw.close();
	}
}
