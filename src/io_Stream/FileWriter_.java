package io_Stream;

import java.io.FileWriter;
import java.io.IOException;

//��OutputStream�÷�����
//һ���ؼ����ǣ���д����һ��Ҫclose����flush����Ȼ���ݻ���ڻ���������û��д���ļ���
public class FileWriter_ {

	public static void main(String[] args) {
		String path="E:\\javaTestFile\\FileWriter.txt";
		FileWriter fileWriter =null;
		
		try {
			fileWriter=new FileWriter(path,true);//ʹ��׷������
			//input
			//1����һ���ַ�
			fileWriter.write('A');
			fileWriter.write(' ');
			
			//2������һ���ַ���
			String str ="Beijing Shanghai Sichuan";
			fileWriter.write(str);
			fileWriter.write(' ');
			//3�������ַ�����ָ��ƫ���������ݳ���
			fileWriter.write(str, 0, 7);
			fileWriter.write(' ');
			//4������һ���ַ�����
			char[] array=str.toCharArray();
			fileWriter.write(array);
			fileWriter.write(' ');
			//5.���ַ������ƫ�ƺͳ���
			fileWriter.write(array, 0, 7);
			fileWriter.write(' ');
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				//fileWriter.flush();
				           //fileWriter�ײ㻹��OutputStream,
				fileWriter.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
