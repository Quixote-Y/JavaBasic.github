package io_Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//BufferedInputStream   BufferedOutputStream使用
//BufferedInputStream的直接父类是FilterInputStream
//BufferedOutputStream的直接父类是FilterOutputStream
//Filter是InputStream和OutputStream的实现类
public class BufferedCopy02 {
	//字节流，处理音频视频图片，也可以处理文本文件
	public static void main(String[] args) {
		
		String srcPath="E:\\javaTestFile\\1.png";
		String desPath="E:\\javaTestFile\\1Copyy2.png";
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		byte[] data=new byte[1024];
		int dataLen=0;
		
		//注意，字节包装流包装的对象一定要是InputStream OutputStream的实现子类不要串到字符流内边
		try {
			bis =new BufferedInputStream(new FileInputStream(srcPath));
			bos =new BufferedOutputStream(new FileOutputStream(desPath,true));
			
			//copy
			while((dataLen=bis.read(data))!=-1) {
				bos.write(data, 0, dataLen);
			}
			System.out.println("文件拷贝成功");
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
