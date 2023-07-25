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
			fileOutputStream=new FileOutputStream(path2,true);//附加存储
			while((length=fileInputStream.read(buf))!=-1) {
				fileOutputStream.write(buf, 0, length);//必须要取一部分存一部分，提高内存利用率
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
