package fileTest;

import java.io.File;

import org.junit.Test;

public class FileInformation {
	public static void main(String[] args) {
		
	}
	
	@Test
	//һЩ��ȡ�ļ�����Ϣ�Ĳ���
	public void info() {
		//�ȴ����ļ�����
		File file=new File("E:\\javaTestFile\\news1.txt");
		
		//������Ӧ�ķ������õ���Ӧ����Ϣ
		System.out.println("�ļ���="+file.getName());//�ļ���
		System.out.println("�ļ�����·��="+file.getAbsolutePath());//����·��
		System.out.println("�ļ�����Ŀ¼="+file.getParent());//����Ŀ¼
		System.out.println("�ļ���С="+file.length());//�ļ���С���ֽڣ�--�����Ϊ���ļ������ʽ��
		                                                    //UTF-8��һ��Ӣ���ַ�8λ��1���ֽڣ�һ������3���ֽ�
		System.out.println("�ļ��Ƿ����="+file.exists());//�ļ��ܷ����
		System.out.println("�ǲ���һ���ļ�="+file.isFile());//�Ƿ����ļ�
		System.out.println("�ǲ���һ��Ŀ¼="+file.isDirectory());//
	
	}
	

}
