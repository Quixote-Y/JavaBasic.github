package io_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

//反序列化
public class ObjectInputStream_ {

	public static void main(String[] args) {
		//指定反序列化文件
		String path="E:\\javaTestFile\\ObjectOutput.txt";
		
		ObjectInputStream ois=null;
		//
		
		try {
			ois=new ObjectInputStream(new FileInputStream(path));
			//反序列化读的顺序和写的顺序一定要一致
			System.out.println(ois.readInt());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readUTF());
			Object dog=null;
			//读类对象的时候需要抛出异常
			try {
				dog=ois.readObject();//返回值是Object类型

			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}		
			//dog的编译类型是Object
			System.out.println("dog的运行类型是："+dog.getClass());
			System.out.println(dog);
			
			//使用dog的方法操作dog
			//因为dog的编译类型是Object，我们想调用dog的方法，需要向下转型
			Dog dog2=(Dog)dog;
			System.out.println(dog2.getName());
			//System.out.println(dog2.getWife());
			//除此之外还有一些细节需要注意：
			//是否你调用ObjectInputStream的这个文件能拿到他读取到的Object对象的类定义，要是你拿不到类定义，那么你就不能向下转型，不能对他进行操作
			//就像如果Dog是在别的包里，又是Default类，那这个文件就无法转型为DOg类，无法操作，一般我们会选择让这个对象成为一个public类，这样导入包就可以访问了
			//default 权限只有本包的类能访问其中的方法和属性
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
