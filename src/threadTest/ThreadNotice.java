package threadTest;
//ͨ���ı����������run��������--֪ͨ��ʽ
public class ThreadNotice {

	public static void main(String[] args) throws InterruptedException {
		T t=new T();
		new Thread(t).start();
		
		Thread.sleep(10*1000);
		
		t.setLoop(false);//ֹͣ�߳�t
		System.out.println("main��Ӧ���");
		
	}
}
class T implements Runnable{

	private int count=0;
	private boolean loop=true;
	
	public void setLoop(boolean loop) {
		this.loop = loop;
	}//����setLoop������������ĳ�������޸�������run����

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
	
		while(loop) {
			System.out.println("��� "+(++count)+Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
