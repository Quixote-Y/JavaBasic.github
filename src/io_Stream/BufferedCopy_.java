package io_Stream;
//BufferedReader     ,BufferedWriter使用
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopy_ {

	public static void main(String[] args) {
		
		String srcPath="E:\\javaTestFile\\story.txt";
		String desPath="E:\\javaTestFile\\storyCopy.txt";
		
		File file=new File(desPath);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("已存在复制文件，已删除");
			}else {
				System.out.println("放心，该文件不存在");
			}
		}
		
		//BufferedReader     ,BufferedWriter是字符操作的流
		//不要用来处理二进制文件（音频，视频，图片等）会损毁，应该处理文本文件
		BufferedReader bufferedReader=null;
		BufferedWriter bufferedWriter=null;
		String line="";
		
		try {
			bufferedReader=new BufferedReader(new FileReader(srcPath));
			bufferedWriter=new BufferedWriter(new FileWriter(desPath,true));//内层文件流选择追加写入的方式
		    
			//开始复制文件
			while((line=bufferedReader.readLine())!=null) {
				bufferedWriter.write(line);
				//readLine不会读换行符，所以需要手动添加换行符
				bufferedWriter.newLine();//添加换行符
			}
		
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			//关闭外层流
			try {
				bufferedReader.close();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
	}
}
