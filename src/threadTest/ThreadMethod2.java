package threadTest;

//yield   join ����
public class ThreadMethod2 {

	// Thread.yield �����߳��ó���Դ�������߳������У����˲�����ȡ����cpu��Դ���䣬����Դ���㣬������Ч
	// ��t1�е���t2.join() ��t1�ó���Դ��t2���У�ֱ��t2������t1�Ž�������

	public static void main(String[] args) throws InterruptedException {
		T2 t = new T2();
		Thread thread = new Thread(t);

		thread.start();// �ϴ�ʼ�԰���

		for (int i = 0; i < 20; i++) {

			Thread.sleep(1000);
			System.out.println("���̣߳�С�ܣ�����" + (i+1)
					+ " ������");
			if (i+1 == 3) {
				thread.join();// ���ϴ��ȳ�,�����߳̾Ͱ���Դ�ó�ȥ��
			}
		}
	}
}

class T2 implements Runnable {

	int count = 0;

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (true) {
			System.out.println("���̣߳��ϴ󣩳���" + (++count) + " ������");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if (count == 20) {
				System.out.println("�ϴ������20������");
				break;
			}
		}
	}

}