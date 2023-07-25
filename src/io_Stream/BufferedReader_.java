package io_Stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {

	public static void main(String[] args) {
		//用 BufferedReader高效读取文件输出
		
		String path="E:\\javaTestFile\\story.txt";
		BufferedReader bufferedReader=null;
		String line="";
		try {
			bufferedReader=new BufferedReader(new FileReader(path));
			//最好去查API关于看到的方法咋用
			//读一行文字。 一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止。
			//不包括任何行终止字符，如果已达到流的末尾，则为null 
			while((line=bufferedReader.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			//关闭只用关闭外层流即可
			//源码：
			/*
			 public void close() throws IOException {
                   synchronized (lock) {
                   if (in == null)
                       return;
                    try {
                        in.close();
                      } finally {
                          in = null;
                       cb = null;
                   }
                  }
             }
	         里面调用了in.close 
			 */
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
