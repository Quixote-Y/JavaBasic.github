package io_Stream;

import java.io.FileWriter;
import java.io.IOException;

//与OutputStream用法相似
//一个关键点是：书写结束一定要close或者flush，不然数据会存在缓冲区，而没有写到文件里
public class FileWriter_ {

	public static void main(String[] args) {
		String path="E:\\javaTestFile\\FileWriter.txt";
		FileWriter fileWriter =null;
		
		try {
			fileWriter=new FileWriter(path,true);//使用追加输入
			//input
			//1输入一个字符
			fileWriter.write('A');
			fileWriter.write(' ');
			
			//2。输入一个字符串
			String str ="Beijing Shanghai Sichuan";
			fileWriter.write(str);
			fileWriter.write(' ');
			//3。输入字符串，指定偏移量和数据长度
			fileWriter.write(str, 0, 7);
			fileWriter.write(' ');
			//4。输入一个字符数组
			char[] array=str.toCharArray();
			fileWriter.write(array);
			fileWriter.write(' ');
			//5.。字符数组带偏移和长度
			fileWriter.write(array, 0, 7);
			fileWriter.write(' ');
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				//fileWriter.flush();
				           //fileWriter底层还是OutputStream,
				fileWriter.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
