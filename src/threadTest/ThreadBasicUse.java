package threadTest;
//线程基本使用方法--实现Thread，重写run
public class ThreadBasicUse {

	public static void main(String[] args) {
		//创建Cat类，调用start方法--》自动运行run方法
		Cat cat=new Cat();
		//start（）解析
		/*
		  (1).
		      public synchronized void start() {
		            主要是里面的这个：
		                 start0();
		   (2).
		     start0()是一个本地方法，只能由jvm机调用，底层由c/c++实现，作用是使run方法处于可运行状态，让cpu可以调动他
		      private native void start0();
		      
		 */
		cat.start();//启动线程---》最终执行cat的run方法
		//和 cat.run()的区别：这样的画run就是一个普通方法，没有启动额外线程，必须run执行完，main才会向下执行
		
		//主程序继续执行，并且程序必须所有线程均结束，进程才灭
		//jconsole怎么调用：添加Termianl终端，程序运行后终端输入jconsole，进去之后连接
		System.out.println("主程序继续执行"+Thread.currentThread().getName());//获取当前线程名
		for(int i=0;i<60;i++) {
			System.out.println(1+"\t"+Thread.currentThread().getName());
			//让主程序休眠1秒
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
//使用线程有两种方法，继承Thread类，重写run方法，//实现Runnab接口，重写run方法
//当一个类继承了Thread类，该类就可以当一个线程使用
//重写 run方法，里面就是这个线程的业务逻辑
//Thread是Runnable的实现类，run方法就是Runnable接口的方法

/*
   这是Thread里的  run（） 源码
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 
 */

class Cat extends Thread{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		super.run();
		//我们在这让他循环输出喵喵叫
		int times=0;
		while(true) {
			System.out.println("小猫喵喵"+(++times)+"\tThread"+Thread.currentThread().getName());
			//线程休眠1秒
			//会自动抛出异常，必须捕获异常处理
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(times==80)break;
		}
		
	}

	
}