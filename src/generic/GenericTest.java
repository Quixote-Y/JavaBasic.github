package generic;

import java.util.ArrayList;

//泛型解析
public class GenericTest {

	public static void main(String[] args) {
		//1.常规的方法中，我们不能对加入到ArrayList中的数据类型进行约束，
		//然后遍历list的时候list类返回类型是Object，必须手动转型为指定的类型，对效率有影响，期间容易发生类型转换错无
		// 为了杜绝类似的情况出现，我们使用泛型
		
		//2.泛型，又称参数化类型，也就是指定类型是什么的类型，在你初始化对象的时候指定泛型
		//那么在编译的时候编译器就能发现输入值和你指定的对象是不是一个类型，然后把错误情况报错给你
		//而不是留到运行时抛出异常
		
		//3.泛型可以在类或接口声明时通过一个标识符（T，E等）表示类中的某个属性，或是某个方法的返回值类型，或者是参数类型
		//  迭代器也可以，在迭代器初始化的时候指定迭代器具体的返回值
	
		//泛型的一些细节：
		//泛型不能替换基本数据类型只能是引用类型--》Integer String Dog
		//再给泛型指定具体类型后，可以传入该类型或其子类型
		//编译器会自动进行类型推断，你可以只在左边写泛型的值，右边的编译器会自动补全
		//如果泛型没有指定，他默认是Object
		
		//泛型定义的数组不能初始化，因为泛型在对象创建之前是不知道泛型所指向的具体类型的，底层无法确定给数组分配多大的地址空间
		//泛型不能出现在静态方法和属性里，静态方法属于类，在类建立时初始化，这时泛型还没有值，所以无法创建
		
		//泛型接口中静态成员不能用泛型，然后接口中的属性默认都是static，里面的属性都不能用泛型
		 //     泛型接口在继承和实现的时候指定泛型类型，然后替换接口里的泛型
		//             没有定义泛型，默认Object---别不写用默认，宁愿写两个Object
		
		//泛型方法可以定义在普通类中，也可以定义在泛型类中
		//   public<T,R> void fly(T t,R r){}//泛型方法
		//     //当调用泛型方法时，传入参数，编译器就会确定类型
		//    car.fly("宝马",100);
		//    car.fly(100,100.2);//当调用泛型方法时，传入参数，编译器就会确定类型,不用程序员再去写啥多余的
		//    public void hi(T t){}//这不是泛型方法，他只是泛型类里的普通方法
		//  泛型方法可以调用自己声明的泛型，也可以使用泛型类声明的泛型
		//  public<K> void fun(K k,T t){}//T为泛型类的泛型参数是可以的---》感觉关键点就在于你调用泛型方法不用管别的，直接给他传值就好了，编译器会帮你判断他的类型
		
		//泛型没有继承性，不能像：
		// List<Object> list=new ArrayList<String>(),想着String继承Object，是错误的
		
		//泛型和通配符
		//   <? >            :可以接收任何数据类型
		//   <? extends A >  :可以接受A类及其子类，表示上限
		//   <? super A >    :可以接收A类及其父类，表示下限		
		
		
		//自定义泛型类：也就是正常的类使用了泛型
		
	    Dog<Integer> dog1=new Dog<>("dmy",21);
	    Dog<String> dog2=new Dog<>("dmy","年龄21");//泛型的作用
	    ArrayList<Dog> list=new ArrayList<>();//初始化的时候声明泛型的类型
	    //这样的化编译器就可一识别你加入到里面的对象类型是否是Dog类型，然后给你反馈了
	    list.add(dog1);
	    list.add(dog2);
	    //加个Cat进去就会报错
	    //list.add(new Cat("zyx" ,10));
	    //类型 ArrayList<Dog> 中的方法 add（Dog）对于参数（Cat）不适用
	    //看看两个age的类型有没有差别
	    dog1.show();
	    dog2.show();
	}
}
class Dog<E>{
	String name;
	E age;
	public Dog(String name, E age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	public void show() {
		System.out.println(age.getClass());//返回age的运行时类型
	}
}
class Cat<E>{
	String name;
	E age;
	public Cat(String name, E age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	public void show() {
		System.out.println(age.getClass());//返回age的运行时类型
	}
}

