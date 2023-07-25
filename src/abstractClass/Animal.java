package abstractClass;
/**
 * 抽象类使用要点：
 * 1.由抽象方法的类只能定义为抽象类
 * 2.抽象类不能实例化，既不能用new来实例化对象
 * 3.抽象类可以包含属性，方法，构造方法，但构造方法不能用new实例化，只能被子类调用
 * 4.抽象类只能被用来继承
 * 5.抽象方法必须被子类实现
 * @author 86136
 *
 */
public abstract class Animal {//包含抽象函数的类必须为抽象类

	int age;
	public abstract void run();//只有函数名没有实现
	public abstract void reset();
	
	public void shout() {
		System.out.println("Animal shout");
	}
	
	Animal(){
		System.out.println("抽象类Animal构造方法调用");
	}
}


class Dog extends Animal{
//继承的子类必须实现抽象类里的抽象方法
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void reset() {
		// TODO 自动生成的方法存根
		
	}
	Dog(){
		System.out.println("子类Dog构造函数调用！");
	}
}
