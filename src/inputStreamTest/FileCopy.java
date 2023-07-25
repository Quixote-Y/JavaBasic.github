package inputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		String path ="E:\\javaTestFile\\1.png";
		String path2 ="E:\\javaTestFile\\copy1.png";
		
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		byte[] buf=new byte[20];
		int length=0;
		
		try {
			fileInputStream=new FileInputStream(path);
			fileOutputStream=new FileOutputStream(path2,true);//���Ӵ洢
			while((length=fileInputStream.read(buf))!=-1) {
				fileOutputStream.write(buf, 0, length);//����Ҫȡһ���ִ�һ���֣�����ڴ�������
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
