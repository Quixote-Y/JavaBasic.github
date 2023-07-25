package inputStreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileOutputStream_ {

	@Test
	public void writeFile() {

		// ����FileOutputStream�����󣬸��ݹ������Ĳ�ͬ������ѡ��ͬ�����뷽ʽ
		// new FileOutputStream(path),ֻ��һ��·���������Ǿ��Ǵ��ļ�ͷ��ʼд������ԭ����
		// new FileOutputStream(path��true)��ѡ��׷�ӵķ�ʽ��д���ļ�β
		//д�ļ�����������Զ�������Ӧ�ļ�
		
		String path = "E:\\javaTestFile\\write.txt";
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(path);
			//��ʼд����
			//1.write(int a); дһ���ַ����ַ�ת���֣���д��ȥ�����ַ�
			//fileOutputStream.write('A');
			
			//2.write(byte[]);дһ���ַ���
//			String str="hello ,woeld!";//�ַ�����һ��������תΪbyte����
//			fileOutputStream.write(str.getBytes());//str.getBytes()������ס
			
			//3.write(byte[],offest,length)
			String str="hello world!";
			fileOutputStream.write(str.getBytes(), 2, 5);//дllo w
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
