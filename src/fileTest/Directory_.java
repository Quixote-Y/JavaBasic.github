package fileTest;
//Ŀ¼�������ļ�ɾ��
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Directory_ {

	@Test
	//�ж� �ļ��Ƿ���ڣ�������ھ�ɾ��
	//deleteֻ��ɾ����Ŀ¼�����ļ�
	public void m1() {
		String path="E:\\javaTestFile\\news1.txt";
		File file=new File(path);
		if(file.exists()) {
			if(file.delete()) {//file.delete()����ֵ��booleanֵ
				System.out.println("ɾ���ɹ�");
				
			}else {
				System.out.println("ɾ��ʧ��");
			}
		}else {
			System.out.println("�ļ������ڣ�");
		}
	}
	
	//�ж� Ŀ¼�Ƿ���ڣ����ھ�ɾ�������򷵻ز�����
	//��java����У�Ŀ¼Ҳ�������ļ�
	@Test
	public void m2() {
		String path="E:\\javaTest";
		File file=new File(path);
		if(file.exists()) {
			if(file.delete()) {//file.delete()����ֵ��booleanֵ
				System.out.println("ɾ���ɹ�");
				
			}else {
				System.out.println("ɾ��ʧ��");
			}
		}else {
			System.out.println("��Ŀ¼�����ڣ�");
		}
		file.mkdir();//����һ��һ��Ŀ¼���´ξͿ��Լ����Ƿ�ɾ���ɹ�
	}
	
	//�ж� Ŀ¼�Ƿ���ڣ�������ھ���ʾ�Ѿ����ڣ�����ʹ���
	@Test
	public void m3() {
		String path="E:\\javaTest\\a\\b\\c";
		File file=new File(path);
		if(file.exists()) {
			System.out.println("Ŀ¼�Ѿ�����");
		}else {
			file.mkdirs();//file.mkdir();ֻ�ܴ���һ��Ŀ¼��file.mkdirs();���Դ����༶Ŀ¼
			System.out.println("Ŀ¼�����ɹ�");//
		}
	}
}
