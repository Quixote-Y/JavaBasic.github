package io_Stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1 {

	public static void main(String[] args) {
		String path ="E:\\javaTestFile\\story.txt";
		BufferedReader bufferedReader=null;
		String data="";
		int line=0;
		
		try {
			bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
			//�ֽ���ת�ַ��� �����ṩ�ַ�����ѡ��ӿڣ��� ��װ�������Ч�ʣ�
			while((data=bufferedReader.readLine())!=null) {
				System.out.println((++line)+":"+data);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
