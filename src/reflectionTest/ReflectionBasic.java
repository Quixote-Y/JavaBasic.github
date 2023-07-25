package reflectionTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;



/**
 * 反射机制
 * @author 86136
 *
 */
public class ReflectionBasic {

	public static void main(String[] args) throws Exception {
		/*1.反射机制允许程序借助Reflection API取得任何类的内部信息（成员变量Field，构造器Constructor，成员方法Method等），并能够操作对象的属性及方法
		 *2.java程序在计算机里有3个阶段：
		 *   1.代码阶段：（编译阶段），程序员写下代码后，生成 类.java文件， 类.java文件经由Javac编译，生成 类.class字节码文件，
		 *               在这个 类.class字节码文件里就包含类的属性，方法，构造器等，以字节码得形式存储着
		 *   
		 *   2.Class类阶段：（加载阶段），这个阶段是 类.class文件经由类加载器ClassLoader 在堆中加载生成一个 Class类对象，
		 *                   然后类加载器会把class文件的成员变量 转换为 一个Field【】 field数组，
		 *                   把 构造器 转换为一个 Constructor【】 cons数组，成员方法 转换为Method【】数组 
		 *                   Class类对象是一个数据结构，可以操作里面的对象。
		 *   3.Runtime运行阶段：计算机找到程序入口，进入程序开始执行
		 *                   在这个过程中生成的对象，该对象含有表明自己是那个  Class类对象  的属性
		 *                    因此可以通过实例化的类对象找到它的 Class 类
		 *   应用：   因此，我们拿到Class对象后可以：
		 *                    创建对象，调用对象方法
		 *                    操作属性等
		 *   反射就体现在第二阶段，加载器ClassLoader加载的时候--------不明白
		 * 
		 *   
		 *   Class也是类，继承Object类
		 *   Class类对象不是new出来的，而是系统创建的
		 *   一个类只有一个Class对象，类只加载一次
		 *   在加载阶段，把.Class文件经由ClassLoader中的classLoader方法生成类对象外，还会在方法区生成类的二进制数据，称为类的元数据
		 * 
		 *   在第一个实例化类的地方打下断点，追进去可以看到ClassLoader类的加载方法源码
		 *     public Class<?> loadClass(String name) throws ClassNotFoundException {
                          return loadClass(name, false);
                    }
                 只有第一次实例化会调用类加载方法，只初始化一次
		 * 
		 * 
		 * 
		 * 
		 */
		/*
		 * 一个示例，   反射的用法
		 *  一个Peoperties文件，要按照里面的内容来运行程序，调用哪个类的那个方法
		 */
		
		Properties pin=new Properties();
		pin.load(new FileInputStream("src\\reflectionTest\\re.properties"));
		String classfullpath=(String)pin.get("classfullpath");
		String methodName=(String)pin.get("method");
		System.out.println("classfullpath :"+classfullpath);
		System.out.println("methodName :"+methodName);
		
		//自己想一下要如何使用这两个String对象去创建一个classfullpath"Cat"类对象，然后调用他的methodName"hi"方法
		
		//1.加载类，返回Class类型的cls
		Class cls =Class.forName(classfullpath);
		
		//2.通过cls得到加载的类 classfullpath 的对象的实例
		Object o=cls.newInstance();
		System.out.println("o的运行时类型： "+o.getClass());
		
		//3.通过cls得到加载的类 methodName 的 方法
		//在反射中，万物皆对象，方法，属性，构造器全是对象
		
		Method method1=cls.getMethod(methodName);
		//通过Method对象method1调用方法
		System.out.println("========================");
		method1.invoke(o);//反射机制调用方法 方法.invoke(对象)
		
		//得到类的成员变量
		//Field name=cls.getField("name");//会报错，不能获取私有变量
		Field age=cls.getField("age");
		System.out.println(age.get(o));//传统写法：对象.成员变量 ，反射：成员变量对象.get（对象）
		
		//得到构造器
		Constructor constructor=cls.getConstructor();//()指定参数，现在是返回无参构造器
		
		Constructor constructor2=cls.getConstructor(String.class,Integer.class);//指定参数，.class也是获取对应的Class类
		
		
		//反射调优：
		//反射优点：可以动态的创建和使用对象（框架的底层核心），使用灵活
		//    缺点： 反射是解释执行，速度慢
		
		//对比一下
		//这里我关了方法里的输出，只看调用时间
		System.out.println("============性能比较==============");
		m1();
		m2();
		m3();
		
		
		//写一下反射调优的原理：Field Method Constructor 等都实现了Accessible类，你可以手动把他设置为true，这样
		//在访问时就会取消访问检查，提高访问速率
	}
	public static void m1() {
		Cat cat=new Cat();
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			cat.hi();
		}
		long end =System.currentTimeMillis();
		System.out.println("传统调用花费时间："+(end-start));
	}
	public static void m2() throws Exception {
		Class cls=Class.forName("reflectionTest.Cat");
		Object o=cls.newInstance();
		Method hi=cls.getMethod("hi");
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			hi.invoke(o);//反射调用
		}
		long end =System.currentTimeMillis();
		System.out.println("反射调用花费时间："+(end-start));
	}
	//反射调优
	public static void m3() throws Exception {
		Class cls=Class.forName("reflectionTest.Cat");
		Object o=cls.newInstance();
		Method hi=cls.getMethod("hi");
		hi.setAccessible(true);//在反射调用方法时，取消访问检查
		long start =System.currentTimeMillis();
		for(int i=0;i<900000000;i++) {
			hi.invoke(o);//反射调用
		}
		long end =System.currentTimeMillis();
		System.out.println("反射调优后调用花费时间："+(end-start));
	}
	
}
