package reflectionTest;
//6种获取Class的方法和场景
public class GetClass6 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//1.在已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName获取
		//         Class.forName(str)         （编译阶段）
		
		String classAllPath="reflectionTest.Cat";
		Class<?> cls1 =Class.forName(classAllPath);
		System.out.println(cls1);
		
		//2.类名.class ,多用于参数传递，像通过反射获取类的构造器传入的参数   （加载阶段）
		Class cls2=Cat.class;
		System.out.println(cls2);
		
		//3.对象.getClass()   ,当已经有对象实例的时候      （）运行阶段
		Cat cat=new Cat();
		Class cls3=cat.getClass();          
		// 这就是运行时类型，这就解释了多态，为什么转换为父类引用后调用函数还会调用子类对象的重写函数，因为他的Class
		// 仍旧是子类的Class
		System.out.println(cls3);
		
		//4.通过类加载器ClassLoader
		//(1)先得到类的加载器
		ClassLoader classLoader=cat.getClass().getClassLoader();
		//(2)通过类的加载器得到Class对象
		Class cls4=classLoader.loadClass(classAllPath);
		System.out.println(cls4);
		
		//5.基本数据类型可以.class
		//6.基本数据类型对应的包装类，可以通过.TYPE 得到Class类对象
	}
}
