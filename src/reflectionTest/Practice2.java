package reflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Practice2 {

	public static void main(String[] args) throws Exception {
		
		Class fileClass=Class.forName("java.io.File");
		
		Constructor[] allConstructors=fileClass.getDeclaredConstructors();
		
		for(Constructor t:allConstructors) {
			System.out.println(t.getName());
			Type[] formal=t.getGenericParameterTypes();
			for(int i=0;i<formal.length;i++) {
				System.out.println("参数类型是："+formal[i].getTypeName());
			}
			System.out.println("完整描述：\t"+t.toGenericString());
		}
		//获取带参构造器
		Constructor constructor=fileClass.getDeclaredConstructor(String.class);//带一个String参数的构造器
		//创建文件对象
		Object file=constructor.newInstance("E:\\javaTestFile\\反射创建.txt");
	    //创建文件
		Method createNewFile=fileClass.getDeclaredMethod("createNewFile");
		createNewFile.invoke(file);
	}
}
