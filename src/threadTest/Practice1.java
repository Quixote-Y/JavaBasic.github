package threadTest;

//100张票，3个窗口售票
public class Practice1 {

	public static void main(String[] args) {
//		//1.Thread
//		SellTicket sellTicket1=new SellTicket();
//		SellTicket sellTicket2=new SellTicket();
//		SellTicket sellTicket3=new SellTicket();
//		sellTicket1.start();
//		sellTicket2.start();
//		sellTicket3.start();//

		// 2.Runnable
		SellTicket sellTick = new SellTicket();
		new Thread(sellTick).start();
		new Thread(sellTick).start();
		new Thread(sellTick).start();

	}
}

////1.Thread
//class SellTicket extends Thread {
//
//	public static int ticketNum = 100;// static
//
//	@Override
//	public void run() {
//		// TODO 自动生成的方法存根
//		while (true) {
//			if (ticketNum <= 0) {
//				System.out.println("Haven't ticket");
//				break;
//			}
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName()+"sell one ticket, still have tickets:"+(--ticketNum));
//		}
//	}
//
//}

//2.implements Runnable
class SellTicket implements Runnable {

	public int ticketNum = 100;// 所有线程共享一个资源，没必要static
	public boolean loop = true;

	// public synchronized void sell() {}是一个同步方法，这时锁加在当前 this对象
	public /* synchronized */ void sell() {// 同步方法，在同一时刻，只有一个线程来执行sell方法

		//这是在代码块上加锁，互斥锁还是加在this对象上
		synchronized (this) {
			if (ticketNum <= 0) {
				System.out.println("Haven't ticket");
				loop = false;
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + "sell one ticket, still have tickets:" + (--ticketNum));

		}

	}
	
	//静态的同步方法锁加在类本身
	//	public static synchronized void fun() {}这个锁默认加在SellTicket.class上
	// 在静态方法中创立同步代码块，要所在类上SellTicket.class
	public static synchronized void fun() {}

	public static void m() {
		synchronized(SellTicket.class) {//
			System.out.println(" ");
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (loop) {
			sell();
		}
	}

}

//以上这些锁的位置 ，，主要都是为了能够让多个线程的锁锁的是同一个对象，这样才能锁住