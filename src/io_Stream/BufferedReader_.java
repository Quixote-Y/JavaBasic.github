package io_Stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {

	public static void main(String[] args) {
		//�� BufferedReader��Ч��ȡ�ļ����
		
		String path="E:\\javaTestFile\\story.txt";
		BufferedReader bufferedReader=null;
		String line="";
		try {
			bufferedReader=new BufferedReader(new FileReader(path));
			//���ȥ��API���ڿ����ķ���զ��
			//��һ�����֡� һ�б���Ϊ�ɻ��з���'\ n'�����س�����'\ r'���е��κ�һ�������Ļ��з���ֹ��
			//�������κ�����ֹ�ַ�������Ѵﵽ����ĩβ����Ϊnull 
			while((line=bufferedReader.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			//�ر�ֻ�ùر����������
			//Դ�룺
			/*
			 public void close() throws IOException {
                   synchronized (lock) {
                   if (in == null)
                       return;
                    try {
                        in.close();
                      } finally {
                          in = null;
                       cb = null;
                   }
                  }
             }
	         ���������in.close 
			 */
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
