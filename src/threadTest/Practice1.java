package threadTest;

//100��Ʊ��3��������Ʊ
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
//		// TODO �Զ����ɵķ������
//		while (true) {
//			if (ticketNum <= 0) {
//				System.out.println("Haven't ticket");
//				break;
//			}
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName()+"sell one ticket, still have tickets:"+(--ticketNum));
//		}
//	}
//
//}

//2.implements Runnable
class SellTicket implements Runnable {

	public int ticketNum = 100;// �����̹߳���һ����Դ��û��Ҫstatic
	public boolean loop = true;

	// public synchronized void sell() {}��һ��ͬ����������ʱ�����ڵ�ǰ this����
	public /* synchronized */ void sell() {// ͬ����������ͬһʱ�̣�ֻ��һ���߳���ִ��sell����

		//�����ڴ�����ϼ��������������Ǽ���this������
		synchronized (this) {
			if (ticketNum <= 0) {
				System.out.println("Haven't ticket");
				loop = false;
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + "sell one ticket, still have tickets:" + (--ticketNum));

		}

	}
	
	//��̬��ͬ�������������౾��
	//	public static synchronized void fun() {}�����Ĭ�ϼ���SellTicket.class��
	// �ھ�̬�����д���ͬ������飬Ҫ��������SellTicket.class
	public static synchronized void fun() {}

	public static void m() {
		synchronized(SellTicket.class) {//
			System.out.println(" ");
		}
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (loop) {
			sell();
		}
	}

}

//������Щ����λ�� ������Ҫ����Ϊ���ܹ��ö���̵߳���������ͬһ����������������ס