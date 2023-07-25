package threadTest;
//卡里10000，两个人分别取，每次取1000
public class Practice3 {

	public static void main(String[] args) {
		User user=new User();
		Thread a=new Thread(user);
		Thread b=new Thread(user);
		a.setName("用户1");
		b.setName("用户2");
		a.start();
		b.start();
	}
}
class User implements Runnable{

	private int sumMoney=10000;
	private boolean loop =true;
	
	public void takeMoney() {
		//synchronized锁是非公平锁，谁抢到就是谁的
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+"取走了1000，剩下"+sumMoney);
			sumMoney-=1000;
			if(sumMoney==0) {
				loop=false;
			}
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(loop) {
			takeMoney();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
		}
	}
	public int getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}
	
}
