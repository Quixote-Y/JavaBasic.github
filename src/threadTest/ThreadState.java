package threadTest;
/*
 * �߳��������ڣ�����6��״̬��ϸ��7��
 *              �̸߳մ���  new      ��          NEW ״̬
 *              �߳�ִ��start������ ��           Runable״̬-
 *                    Runnable״̬�ֿ�ϸ��Ϊ Ready �� Running����״̬��ȡ�����߳��Ƿ��̵߳��������ȣ�
 *                      yeild��������ʱ�̴߳�Running״̬ת��Ϊready̬
 *              �߳���Runnable״̬�������� Blocked״̬���������ת��ΪRunnable״̬
 *              �߳���Runnable״̬ʹ��wait������join�ȷ�����������Waiting״̬
 *              �߳����� ����� TimedWaiting ״̬
 *              �߳�ִ�н�������� Teminated ����״̬
 */
public class ThreadState {

	public static void main(String[] args) throws InterruptedException {
		T3 t3=new T3();
		System.out.println("���̵߳�״̬�ǣ�"+t3.getState());
		t3.start();
		for(int i=0;i<30;i++) {
			System.out.println("���̵߳�״̬�ǣ�"+t3.getState());
			Thread.sleep(500);
		}
	}
}  
class T3 extends Thread{

	int i=0;
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true) {
			System.out.println("Hi"+(++i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(i==10)break;
		}
	}
	
}