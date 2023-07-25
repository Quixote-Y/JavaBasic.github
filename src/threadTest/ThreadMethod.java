package threadTest;
//一些线程常用方法
public class ThreadMethod {

	public static void main(String[] args) throws InterruptedException {
		Paper paper =new Paper();
		Thread thread=new Thread(paper);
		thread.setPriority(Thread.MIN_PRIORITY);//设置这个线程的优先级为最小优先级1
		System.out.println("当前线程优先级是："+thread.getPriority());//获取线程优先级
		thread.start();//启动线程
		
		Thread.sleep(3*1000);
		System.out.println("老板来了");
		thread.interrupt();//发出中断，告诉线程不能休眠
		
	}
}
//
class Paper implements Runnable{

	private int count=0;
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			System.out.println("擦桌子 "+(++count)+Thread.currentThread().getName());//返回线程的名称
			
			try {
				Thread.sleep(10 *1000);
			} catch (InterruptedException e) {
				//这里的异常是中断异常，可以主动发出，当主动发出中断异常的时候就会终止休眠，然后执行下面的逻辑
				// TODO 自动生成的 catch 块
				System.out.println("休眠被打断，你不能休息！");
			}
			if(count==3)
				{
				System.out.println("结束了");
				break;
				
				}
		}
	}
	
}
