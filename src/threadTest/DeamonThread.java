package threadTest;
/**
 * 线程分为：
 *         工作线程：用户线程，当线程任务执行完成或通知方式 结束
 *         守护线程： 为工作线程服务，当所有的工作线程结束时，守护线程自动结束
 *                可以手动设置某线程为守护线程
 * @author 86136
 *
 */
public class DeamonThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new WaiYu());
		//将t1设置为守护线程，让他在程序结束时自动结束
		t1.setDaemon(true);
		//先设置为守护线程在开始
		t1.start();
		
		
		for(int i=0;i<10;i++) {
			System.out.println("老公在工作");
			Thread.sleep(1000);
		}
		System.out.println("老公回家了");
		
	}
}
class WaiYu implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			System.out.println("老婆偷偷和老头聊天");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}//一直循环不会结束
		}
	}
	
}
