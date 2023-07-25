package io_Stream;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

//打印流 PrintStream  直接父类 FilterOutputStream  实现接口 OutputStream   字节类
//       PrintWriter  实现接口Writer      字符流
public class Print_ {

	public static void main(String[] args) throws IOException {
		
		PrintStream out=System.out;//System.out就是PrintStream流对象
		//   public static final PrintStream out = null;
		out.println("你好");
		//可以直接调用
		//在默认情况下，PrintStream输出数据的位置默认是标准输出  显示器
		/*
		 public void print(String s) {
               write(String.valueOf(s));
           }
		 //也就是说，print的底层时使用了PrintStream类的write方法将数据写到了显示器上
		 */  
		//那我们也可以直接使用write输出信息
		//因为是字节流，所以write方法里面的参数基本都是byte[],按字节读取
		
		out.write("你好世界".getBytes());//将字符串转换为byte数组
		
		//out.close();
		//本来是直接关闭了，但是后面写PrintWriter的时候发现，被重定向的console输出不知道咋改回来了，只好
		//留下这个PrintStream，之后在setOut为标准输出。
		
		
		//可以看到已经打印出来了
		
		//也可以手动修改打印流输出的位置/对象
		System.setOut(new PrintStream("E:\\javaTestFile\\changeOut.txt"));//使用字符串地址创建一个打印流对象设置为打印的目标设备
		
		/*
		  public static void setOut(PrintStream out) {
                checkIO();
                setOut0(out);      //native方法，修改输出位置 
         }
		 */
		
		System.out.println("你好世界----打印改变");
		
		//文件夹里也得到了相应内容
		
		//把输出重定向会console上
		System.setOut(out);
		System.out.println("这是重定向回来");
		
		//PrintWriter
		PrintWriter pw=new PrintWriter(System.out);//创建一个·PrintWriter对象，传入参数为PrintStream类的对象System.out，标准输出流
		pw.println("你好你好，这是字符打印流");
		pw.close();
		
		PrintWriter pwFile=new PrintWriter(new PrintStream("E:\\javaTestFile\\changeOut.txt"));
		pwFile.println("你好，打印到文件里，字符打印流");
		pwFile.close();//必须关闭，writer类只有flush才会写入文件
		
		//关闭out
		out.close();
		//把out关了，pw就不打印了
	}
}
