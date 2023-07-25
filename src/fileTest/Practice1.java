package fileTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Practice1 {

	public static void main(String[] args) {
		String path = "E:\\javaTestFile\\mytemp";
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdir();
			System.out.println("Create File mytemp");
		}
		File file2 = new File(path + "\\hello.txt");
		if (file2.exists()) {
			System.out.println("hello.txt  exists");
		} else {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		BufferedWriter bufferedWriter=null;
		try {
			bufferedWriter =new BufferedWriter(new FileWriter(path+"\\hello.txt"));
			bufferedWriter.write("Hello World!");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
