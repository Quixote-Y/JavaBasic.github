package threadTest;
/*
 * 线程生命周期：定义6个状态，细分7个
 *              线程刚创建  new      是          NEW 状态
 *              线程执行start（）后 是           Runable状态-
 *                    Runnable状态又可细分为 Ready 和 Running两个状态，取决于线程是否被线程调度器调度，
 *                      yeild方法就是时线程从Running状态转换为ready态
 *              线程在Runnable状态被上锁是 Blocked状态，获得锁后转换为Runnable状态
 *              线程在Runnable状态使用wait（），join等方法，便会进入Waiting状态
 *              线程休眠 会进入 TimedWaiting 状态
 *              线程执行结束会进入 Teminated 结束状态
 */
public class ThreadState {

	public static void main(String[] args) throws InterruptedException {
		T3 t3=new T3();
		System.out.println("子线程的状态是："+t3.getState());
		t3.start();
		for(int i=0;i<30;i++) {
			System.out.println("子线程的状态是："+t3.getState());
			Thread.sleep(500);
		}
	}
}  
class T3 extends Thread{

	int i=0;
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			System.out.println("Hi"+(++i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(i==10)break;
		}
	}
	
}