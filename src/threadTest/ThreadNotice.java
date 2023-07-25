package threadTest;
//通过改变变量来控制run方法运行--通知方式
public class ThreadNotice {

	public static void main(String[] args) throws InterruptedException {
		T t=new T();
		new Thread(t).start();
		
		Thread.sleep(10*1000);
		
		t.setLoop(false);//停止线程t
		System.out.println("main回应你好");
		
	}
}
class T implements Runnable{

	private int count=0;
	private boolean loop=true;
	
	public void setLoop(boolean loop) {
		this.loop = loop;
	}//生成setLoop方法，让外面的程序可以修改来控制run方法

	@Override
	public void run() {
		// TODO 自动生成的方法存根
	
		while(loop) {
			System.out.println("你好 "+(++count)+Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
