package fileTest;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

//3�ش��ļ��ķ���
public class FileCreate {

	//1.new File(String pathname)//����·������һ��FIle����
	@Test
	public void create01() {
		String fileName="E:\\javaTestFile\\news1.txt";//�ļ�·�������ż��ļ�
		File file1=new File(fileName);//����һ��file����
		
		try {
			file1.createNewFile();//�����ļ�
			System.out.println("�ļ������ɹ�");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	@Test
	//2.new File(File parent,String child)//���ݸ�Ŀ¼�ļ�+��·������
	public void create02() {
		File parent=new File("E:\\javaTestFile");
		File file2=new File(parent,"news2.txt");
		try {
			file2.createNewFile();
			System.out.println("�ļ������ɹ�");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	@Test
	//3.new File(String parent,String child)//���ݸ�Ŀ¼+��·������������String
	public void create03() {
		String parentPath="E:\\";  //�ļ�·���е�\\��һ��ת���ַ�\��һ����ʶ\,Ȼ����Ҳ������/���滻�����Ƽ���\\
		String filePath="javaTestFile\\news3.txt";
		File file3=new File(parentPath,filePath);
		try {
			file3.createNewFile();
			System.out.println("�ļ������ɹ�");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
