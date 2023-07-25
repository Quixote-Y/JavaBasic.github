package reflectionTest;

import java.lang.reflect.Field;

//Class类常用方法
public class ClassMethod {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String str="reflectionTest.Cat";
		//获取到Class类的对象 ？表示不确定的java类型，可写可不写
		Class<?> cls=Class.forName(str);
		
		//显示Class对象是哪个类的Class对象
		System.out.println(cls);//输出的是这个Class类的对象属于哪个类   Cat
		
		//显示运行时类型
		System.out.println(cls.getClass());
		//输出的是运行时类型，他是Class类对象，所以不能直接把Class对象强转为Cat对象
		
		//获取类的路径，到父文件位置
		System.out.println(cls.getPackageName());
		
		//获取类的全名，包含包
		System.out.println(cls.getName());
		
		//创建对象实例-->这个对象o的运行类型就是Cat类的了，你可以强转为Cat
		Object o=cls.newInstance();
		System.out.println("o的运行时类型为："+o.getClass());
		//通过反射获取属性
		Field field=cls.getField("age");
		System.out.println("age 是："+field.get(o));//成员属性用get，方法用invoke
		//设置属性值
		field.set(o, 100);//第一个参数为对象实例，第二个为改变属性的值
		System.out.println("age改了后是："+field.get(o));
		//获取所有属性
		Field[] fields=cls.getFields();
		for(Field f:fields) {
			System.out.print(f.getName()+"\t\t");//输出属性名
		}
		//Class类对象 Constructor类对象  Field类对象 Method类对象 他们包含的API几乎可以拿到类的所有信息并进行操作，碰到他们勤查Api文档
		//在他们的Api中 get ... 一般有两种，像getMethod("A")就只能拿到共有的方法A，一般还有另一种getdeclaredMethod("A")这样就可以拿到私有的方法A，
		//但拿到私有的方法并不能直接进行操作，会报错，得 爆破 .setAccessible(true);
		//私有属性，构造器，方法均是如此
		//直接调用Class.newInstance();实际上调用的是无参构造函数，如果想调用有参构造函数，先得拿到有参构造函数对象，然后对有参构造函数运行.newInstance(参数)方法
		//返回值： 反射有关的返回值都是以Object对象返回，  一个方法返回String类型，但反射调用他，返回的编译类型就是Object，运行类型是String
		
		
	}
}
