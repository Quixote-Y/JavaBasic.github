package io_Stream;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//标准输入输出流
public class StandardInputAndOutput {

	public static void main(String[] args) {
		//System.in
		//声明：public static final InputStream in = null;
        //        编译类型是：InputStream        运行类型是：BufferedInputStream
		//System.in 标准输入流         默认是：键盘
		System.out.println(" 运行类型是："+System.in.getClass());
		//System.out
		//声明：    public static final PrintStream out = null;
		//       编译类型是：PrintStream        运行类型是：PrintStream
		//System.out  标准输流          默认是：显示器
		System.out.println("运行类型是："+System.out.getClass());
		
		Scanner sc=new Scanner(System.in);//传入一个标准输入流，这样Scanner对象就知道去键盘寻找输入数据
		System.out.println("请输入内容：");
		System.out.println(sc.next());
		//调用PrintStream的println方法，输出到显示器上去
		
	}
}
