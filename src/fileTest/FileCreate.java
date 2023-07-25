package fileTest;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

//3重创文件的方法
public class FileCreate {

	//1.new File(String pathname)//根据路径创建一个FIle对象
	@Test
	public void create01() {
		String fileName="E:\\javaTestFile\\news1.txt";//文件路径，记着加文件
		File file1=new File(fileName);//创建一个file对象
		
		try {
			file1.createNewFile();//创建文件
			System.out.println("文件创建成功");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Test
	//2.new File(File parent,String child)//根据父目录文件+子路径构建
	public void create02() {
		File parent=new File("E:\\javaTestFile");
		File file2=new File(parent,"news2.txt");
		try {
			file2.createNewFile();
			System.out.println("文件创建成功");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Test
	//3.new File(String parent,String child)//根据父目录+子路径构建，两个String
	public void create03() {
		String parentPath="E:\\";  //文件路径中的\\是一个转义字符\和一个标识\,然后你也可以用/来替换，但推荐用\\
		String filePath="javaTestFile\\news3.txt";
		File file3=new File(parentPath,filePath);
		try {
			file3.createNewFile();
			System.out.println("文件创建成功");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
