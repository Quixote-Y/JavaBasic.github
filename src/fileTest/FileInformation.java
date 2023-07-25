package fileTest;

import java.io.File;

import org.junit.Test;

public class FileInformation {
	public static void main(String[] args) {
		
	}
	
	@Test
	//一些获取文件的信息的操作
	public void info() {
		//先创建文件对象
		File file=new File("E:\\javaTestFile\\news1.txt");
		
		//调用相应的方法，得到对应的信息
		System.out.println("文件名="+file.getName());//文件名
		System.out.println("文件绝对路径="+file.getAbsolutePath());//绝对路径
		System.out.println("文件父级目录="+file.getParent());//父级目录
		System.out.println("文件大小="+file.length());//文件大小（字节）--》另存为看文件编码格式：
		                                                    //UTF-8，一个英文字符8位，1个字节，一个汉字3个字节
		System.out.println("文件是否存在="+file.exists());//文件受否存在
		System.out.println("是不是一个文件="+file.isFile());//是否是文件
		System.out.println("是不是一个目录="+file.isDirectory());//
	
	}
	

}
