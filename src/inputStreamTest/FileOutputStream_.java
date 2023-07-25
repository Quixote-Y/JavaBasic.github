package inputStreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileOutputStream_ {

	@Test
	public void writeFile() {

		// 创建FileOutputStream流对象，根据构造器的不同，可以选择不同的输入方式
		// new FileOutputStream(path),只有一个路径参数，那就是从文件头开始写，覆盖原内容
		// new FileOutputStream(path，true)，选择追加的方式，写到文件尾
		//写文件操作会帮你自动创建对应文件
		
		String path = "E:\\javaTestFile\\write.txt";
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(path);
			//开始写操作
			//1.write(int a); 写一个字符，字符转数字，但写进去的是字符
			//fileOutputStream.write('A');
			
			//2.write(byte[]);写一个字符串
//			String str="hello ,woeld!";//字符串有一个方法能转为byte数组
//			fileOutputStream.write(str.getBytes());//str.getBytes()方法记住
			
			//3.write(byte[],offest,length)
			String str="hello world!";
			fileOutputStream.write(str.getBytes(), 2, 5);//写llo w
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
