package threadTest;
//һЩ�̳߳��÷���
public class ThreadMethod {

	public static void main(String[] args) throws InterruptedException {
		Paper paper =new Paper();
		Thread thread=new Thread(paper);
		thread.setPriority(Thread.MIN_PRIORITY);//��������̵߳����ȼ�Ϊ��С���ȼ�1
		System.out.println("��ǰ�߳����ȼ��ǣ�"+thread.getPriority());//��ȡ�߳����ȼ�
		thread.start();//�����߳�
		
		Thread.sleep(3*1000);
		System.out.println("�ϰ�����");
		thread.interrupt();//�����жϣ������̲߳�������
		
	}
}
//
class Paper implements Runnable{

	private int count=0;
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true) {
			System.out.println("������ "+(++count)+Thread.currentThread().getName());//�����̵߳�����
			
			try {
				Thread.sleep(10 *1000);
			} catch (InterruptedException e) {
				//������쳣���ж��쳣���������������������������ж��쳣��ʱ��ͻ���ֹ���ߣ�Ȼ��ִ��������߼�
				// TODO �Զ����ɵ� catch ��
				System.out.println("���߱���ϣ��㲻����Ϣ��");
			}
			if(count==3)
				{
				System.out.println("������");
				break;
				
				}
		}
	}
	
}
