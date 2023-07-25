package threadTest;
//通过实现Runnable接口，重写run方法来实现多线程
//当一个类已经继承了另一个类，由于java是单继承那么想通过继承Thread来实现多线程就不可能了，所以增加一个实现接口的方式
//实现runnable接口更适合多个线程共用一个资源，你可以创建多个线程，然后传入的参数都是同一个，让他们共享一个资源
//一般常用实现Runnable接口的方式来实现多线程
public class ThreadBasicUse2 {

	public static void main(String[] args) {
		Dog dog=new Dog();
		//肯定是不能直接调用dog.run,这样只会有一个main线程
		//Runnable接口也没有start方法,怎么去调用Thread的start方法呢
		//这里用到了代理·模式
		Thread thread=new Thread(dog);
		thread.start();	
		
		//下面是模拟的
//		System.out.println("--------模拟-------");
//		Fish fish=new Fish();
//		ThreadProxy tp=new ThreadProxy(fish);//
//		tp.start();
		
	}
}
//
class Dog implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		int times=0;
		while(true) {
			System.out.println("小狗汪汪"+(++times)+Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(times==10)break;
		}
		
		
	}
	
}


//代理模式初识
class Animal{}
class Fish extends Animal implements Runnable{//无法继承Thread
	public void run() {
		System.out.println("小鱼咕咕咕");
	}
}
//模拟Thread类的机制
class ThreadProxy implements Runnable{

	private Runnable target=null;//是一个属性，类型是   Runnable
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		if(target!=null) {
			target.run();//--------运行的时候去调用你实例化时的对象的run方法
		}	
	}
	public ThreadProxy(Runnable target) {
		this.target=target; //        这里实例化线程代理类时可以传入一个实现了Runnable接口的类，然后把他赋给target
	}
	public void start() {//去调用start0，启动多线程
		start0();
	}
	public void start0() {
		run();//在实际的Thread类中，start0让jvm启动多线程，cpu按调度去调用thread中run方法
	}
	//机理就是：你传入一个实现了Runnable接口的类（向上转型），然后这个对象会被赋给Thread的target，成为Thread中run方法的参数
	  //        你用线程Start方法开始多线程，让cpu去调度他的run方法，由于多态，表面上运行的是Runnable中的run，但实际运行的是Fish类重写的run方法，实现多线程
	//          我的理解是  Runnable接口作为中继代理  实现两个类的连接
}