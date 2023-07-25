package io_Stream;
//FileReader操作基本与FileInputStream一致
//FileReader的直接父类是InputStreamReader，后者的父接口是Reader

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

	public static void main(String[] args) {
		
		//
		String path="E:\\javaTestFile\\story.txt";
		int data=0;
		char[] data2=new char[16];
		int length=0;
		FileReader fileReader=null;
		
		try {
			fileReader=new FileReader(path);
			//1.reader--》慢
//			while((data=fileReader.read())!=-1){
//				System.out.print((char)data);
//			}
			
			//2.reader(char[])
			while((length=fileReader.read(data2))!=-1) {
				System.out.print(new String(data2,0,length));//String(char[],offest,length)//这个构造函数极好
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
//使用FileReader无法指定编码参数，只能使用ISO-8859-1 or US-ASCII的西方编码，utf-8编码的中文符会出现乱码，把文档转换尾ansi即可 
//好像这种说法站不住脚，看的应该是编译器的编码格式，因为esclipse默认使用的是gbk国标码，ansi也是国标码，所以可以显示，
//我看到别人ide是Utf-8编码，他的FileReader就可以正常显示utf-8，而不能转换ansi
/*
FileReader内部没有设置指定编码的参数，只能使用ISO-8859-1 or US-ASCII的西方编码。所以问题找到了就是这里。
替换方案：

InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(filePath)), “UTF-8”);
BufferedReader br = new BufferedReader(isr);
————————————————
*/