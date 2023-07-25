package io_Stream;
//BufferedReader     ,BufferedWriterʹ��
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopy_ {

	public static void main(String[] args) {
		
		String srcPath="E:\\javaTestFile\\story.txt";
		String desPath="E:\\javaTestFile\\storyCopy.txt";
		
		File file=new File(desPath);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("�Ѵ��ڸ����ļ�����ɾ��");
			}else {
				System.out.println("���ģ����ļ�������");
			}
		}
		
		//BufferedReader     ,BufferedWriter���ַ���������
		//��Ҫ��������������ļ�����Ƶ����Ƶ��ͼƬ�ȣ�����٣�Ӧ�ô����ı��ļ�
		BufferedReader bufferedReader=null;
		BufferedWriter bufferedWriter=null;
		String line="";
		
		try {
			bufferedReader=new BufferedReader(new FileReader(srcPath));
			bufferedWriter=new BufferedWriter(new FileWriter(desPath,true));//�ڲ��ļ���ѡ��׷��д��ķ�ʽ
		    
			//��ʼ�����ļ�
			while((line=bufferedReader.readLine())!=null) {
				bufferedWriter.write(line);
				//readLine��������з���������Ҫ�ֶ���ӻ��з�
				bufferedWriter.newLine();//��ӻ��з�
			}
		
		
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			//�ر������
			try {
				bufferedReader.close();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
	}
}
