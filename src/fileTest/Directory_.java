package fileTest;
//目录操作即文件删除
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Directory_ {

	@Test
	//判断 文件是否存在，如果存在就删除
	//delete只能删除空目录或者文件
	public void m1() {
		String path="E:\\javaTestFile\\news1.txt";
		File file=new File(path);
		if(file.exists()) {
			if(file.delete()) {//file.delete()返回值是boolean值
				System.out.println("删除成功");
				
			}else {
				System.out.println("删除失败");
			}
		}else {
			System.out.println("文件不存在！");
		}
	}
	
	//判断 目录是否存在，存在就删除，否则返回不存在
	//在java编程中，目录也被当作文件
	@Test
	public void m2() {
		String path="E:\\javaTest";
		File file=new File(path);
		if(file.exists()) {
			if(file.delete()) {//file.delete()返回值是boolean值
				System.out.println("删除成功");
				
			}else {
				System.out.println("删除失败");
			}
		}else {
			System.out.println("该目录不存在！");
		}
		file.mkdir();//创建一个一级目录，下次就可以检验是否删除成功
	}
	
	//判断 目录是否存在，如果存在就提示已经存在，否则就创建
	@Test
	public void m3() {
		String path="E:\\javaTest\\a\\b\\c";
		File file=new File(path);
		if(file.exists()) {
			System.out.println("目录已经存在");
		}else {
			file.mkdirs();//file.mkdir();只能创建一级目录，file.mkdirs();可以创建多级目录
			System.out.println("目录创建成功");//
		}
	}
}
