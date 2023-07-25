package inputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * 数据流在Java中分为两大类：
 *     字节流：（一次读1个字节）InputStream  OutputStream--》抽象类，无法实例化
 *            实现子类-> FileInputStream      BufferedInputStream           ObjectInputStream
 *                      文件输入流            缓冲字节输入流                 对象字节输入流
 *                     OUtput也是相同
 *             
 *     
 *    
 *     字符流：（取决与字符的编码格式） Reader  Writter-->都是抽象类，无法实例化
 *     
 *     对二进制文件进行操作，字节流更好，对字符文件操作，字符流更好
 * @author 86136
 *
 */
public class FileInputStream_ {
	
	/*使用read（）读取的缺点，读取效率低下一次只能读取一个字节
	 * 字节流一次读取一个字节，中文字符乱码
	 */

    //练习FileInputStream使用  ，文件--》程序
	public void readeFile01() {
		String filePath="E:\\javaTestFile\\hello.txt";
		int read=0;
		FileInputStream fileInputStream=null;//先初始化为空，提高作用域，可以被finally调用
		try {
			fileInputStream=new FileInputStream(filePath);//编译异常，必须处理
			while((read=fileInputStream.read())!=-1) {//read（），一次读取一个字节数据，返回数据的ascall码，读取到数据尾没数据了返回-1
				System.out.print((char)read);	//把读取出来的数据转换为char类型输出
			}
		} catch (Exception e) {//这里try catch的时候注意，read也会抛出异常，可以直接把catch异常修改位最高异常来一次性捕获
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {//所有的流操作都必须手动关闭，否则资源浪费
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}//这里也会抛出异常，在捕获一次
			
		}
		
	}
	
	/*使用read（byte【】）来读取
	 * 
	 */
	@Test
	public void readFile02() {
		String filePath="E:\\javaTestFile\\hello.txt";
		byte[] buf=new byte[8];//创建一个8个大小的byte数组，用来存储读取的字节
		int read=0;
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream(filePath);
			while((read=fileInputStream.read(buf))!=-1) {
				//read(byte[])，一次读取数组大小的字节数，读取成功返回读取的字节数，读取失败返回-1
				System.out.print(new String(buf,0,read));//把byte类型的数组转换为字符！！
			//这里暂时没有想到别的方法替换创建新的字符串，最初打算用Arrays.toString,但输出的是字符的Ascall码值
			}
		} catch (Exception e) {//这里try catch的时候注意，read也会抛出异常，可以直接把catch异常修改位最高异常来一次性捕获
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {//所有的流操作都必须手动关闭，否则资源浪费
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}//这里也会抛出异常，在捕获一次
			
		}
	}
}
