package threadTest;
/**
 * �̷߳�Ϊ��
 *         �����̣߳��û��̣߳����߳�����ִ����ɻ�֪ͨ��ʽ ����
 *         �ػ��̣߳� Ϊ�����̷߳��񣬵����еĹ����߳̽���ʱ���ػ��߳��Զ�����
 *                �����ֶ�����ĳ�߳�Ϊ�ػ��߳�
 * @author 86136
 *
 */
public class DeamonThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new WaiYu());
		//��t1����Ϊ�ػ��̣߳������ڳ������ʱ�Զ�����
		t1.setDaemon(true);
		//������Ϊ�ػ��߳��ڿ�ʼ
		t1.start();
		
		
		for(int i=0;i<10;i++) {
			System.out.println("�Ϲ��ڹ���");
			Thread.sleep(1000);
		}
		System.out.println("�Ϲ��ؼ���");
		
	}
}
class WaiYu implements Runnable{

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true) {
			System.out.println("����͵͵����ͷ����");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}//һֱѭ���������
		}
	}
	
}
