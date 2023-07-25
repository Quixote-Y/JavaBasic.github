package io_Stream;
//FileReader����������FileInputStreamһ��
//FileReader��ֱ�Ӹ�����InputStreamReader�����ߵĸ��ӿ���Reader

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

	public static void main(String[] args) {
		
		//
		String path="E:\\javaTestFile\\story.txt";
		int data=0;
		char[] data2=new char[16];
		int length=0;
		FileReader fileReader=null;
		
		try {
			fileReader=new FileReader(path);
			//1.reader--����
//			while((data=fileReader.read())!=-1){
//				System.out.print((char)data);
//			}
			
			//2.reader(char[])
			while((length=fileReader.read(data2))!=-1) {
				System.out.print(new String(data2,0,length));//String(char[],offest,length)//������캯������
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
//ʹ��FileReader�޷�ָ�����������ֻ��ʹ��ISO-8859-1 or US-ASCII���������룬utf-8��������ķ���������룬���ĵ�ת��βansi���� 
//��������˵��վ��ס�ţ�����Ӧ���Ǳ������ı����ʽ����ΪesclipseĬ��ʹ�õ���gbk�����룬ansiҲ�ǹ����룬���Կ�����ʾ��
//�ҿ�������ide��Utf-8���룬����FileReader�Ϳ���������ʾutf-8��������ת��ansi
/*
FileReader�ڲ�û������ָ������Ĳ�����ֻ��ʹ��ISO-8859-1 or US-ASCII���������롣���������ҵ��˾������
�滻������

InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(filePath)), ��UTF-8��);
BufferedReader br = new BufferedReader(isr);
��������������������������������
*/