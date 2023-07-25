package threadTest;
//����10000�������˷ֱ�ȡ��ÿ��ȡ1000
public class Practice3 {

	public static void main(String[] args) {
		User user=new User();
		Thread a=new Thread(user);
		Thread b=new Thread(user);
		a.setName("�û�1");
		b.setName("�û�2");
		a.start();
		b.start();
	}
}
class User implements Runnable{

	private int sumMoney=10000;
	private boolean loop =true;
	
	public void takeMoney() {
		//synchronized���Ƿǹ�ƽ����˭��������˭��
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+"ȡ����1000��ʣ��"+sumMoney);
			sumMoney-=1000;
			if(sumMoney==0) {
				loop=false;
			}
		}
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(loop) {
			takeMoney();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
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
