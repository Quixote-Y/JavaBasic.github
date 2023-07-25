package threadTest;

//yield   join 方法
public class ThreadMethod2 {

	// Thread.yield 调用线程让出资源让其他线程先运行，但运不运行取决与cpu资源分配，若资源充足，可能无效
	// 在t1中调用t2.join() ，t1让出资源让t2运行，直到t2结束，t1才接着运行

	public static void main(String[] args) throws InterruptedException {
		T2 t = new T2();
		Thread thread = new Thread(t);

		thread.start();// 老大开始吃包子

		for (int i = 0; i < 20; i++) {

			Thread.sleep(1000);
			System.out.println("主线程（小弟）吃了" + (i+1)
					+ " 个包子");
			if (i+1 == 3) {
				thread.join();// 让老大先吃,这样线程就把资源让出去了
			}
		}
	}
}

class T2 implements Runnable {

	int count = 0;

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			System.out.println("子线程（老大）吃了" + (++count) + " 个包子");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (count == 20) {
				System.out.println("老大吃完了20个包子");
				break;
			}
		}
	}

}