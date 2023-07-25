package io_Stream;
//转换流  InputStreamReader  OutputStreamWriter       -字节流---》字符流   还能附带编码格式
//

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransformationStream {

	public static void main(String[] args) throws IOException {
		String path ="E:\\javaTestFile\\story.txt";//这里我手动去把stroy文件编码改为utf-8
		//尝试一下用字节流去访问他
		FileInputStream fis=new FileInputStream(path);
		//读出数据
		byte[] data=new byte[1024];
		int len=0;
		while((len=fis.read(data))!=-1) {
			System.out.println(new String(data,0,len));
		}
		//可以看到出现了中文乱码
		//我们使用转换流把他转换为字符流，并规定使用Utf-8编码
		//new InputStreamReader(fis, String)；这个构造器
//		FileInputStream fis2=new FileInputStream(path);
//		InputStreamReader isr=new InputStreamReader(fis2, "UTF-8");
//		//然后把InputStreamReader 用BufferedReader来包装，提高读取效率
//		BufferedReader bfr=new BufferedReader(isr);
		
		//上面的这一串可以用一行代码直接解决
		BufferedReader bfr=new BufferedReader(new InputStreamReader(
				                                  new FileInputStream(path),"utf-8"));
		
		//再次输出
		System.out.println("==============================");
		
		String datalen="";
		while((datalen=bfr.readLine())!=null) {
			System.out.println(datalen);
		}
		//这时输出就正确了
		bfr.close();
		//用OutputStreamWriter来改变文件编码方式
		String path2="E:\\javaTestFile\\OutputStreamWriter.txt";
		String charSet="gbk";
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(path2),charSet);//指定字符编码
		osw.write("你好，世界");
		System.out.println("gbk编码字符保存成功");
		osw.close();
	}
}
