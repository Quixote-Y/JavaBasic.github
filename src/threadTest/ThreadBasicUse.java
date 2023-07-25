package threadTest;
//�̻߳���ʹ�÷���--ʵ��Thread����дrun
public class ThreadBasicUse {

	public static void main(String[] args) {
		//����Cat�࣬����start����--���Զ�����run����
		Cat cat=new Cat();
		//start��������
		/*
		  (1).
		      public synchronized void start() {
		            ��Ҫ������������
		                 start0();
		   (2).
		     start0()��һ�����ط�����ֻ����jvm�����ã��ײ���c/c++ʵ�֣�������ʹrun�������ڿ�����״̬����cpu���Ե�����
		      private native void start0();
		      
		 */
		cat.start();//�����߳�---������ִ��cat��run����
		//�� cat.run()�����������Ļ�run����һ����ͨ������û�����������̣߳�����runִ���꣬main�Ż�����ִ��
		
		//���������ִ�У����ҳ�����������߳̾����������̲���
		//jconsole��ô���ã����Termianl�նˣ��������к��ն�����jconsole����ȥ֮������
		System.out.println("���������ִ��"+Thread.currentThread().getName());//��ȡ��ǰ�߳���
		for(int i=0;i<60;i++) {
			System.out.println(1+"\t"+Thread.currentThread().getName());
			//������������1��
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
//ʹ���߳������ַ������̳�Thread�࣬��дrun������//ʵ��Runnab�ӿڣ���дrun����
//��һ����̳���Thread�࣬����Ϳ��Ե�һ���߳�ʹ��
//��д run�����������������̵߳�ҵ���߼�
//Thread��Runnable��ʵ���࣬run��������Runnable�ӿڵķ���

/*
   ����Thread���  run���� Դ��
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 
 */

class Cat extends Thread{

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		super.run();
		//������������ѭ�����������
		int times=0;
		while(true) {
			System.out.println("Сè����"+(++times)+"\tThread"+Thread.currentThread().getName());
			//�߳�����1��
			//���Զ��׳��쳣�����벶���쳣����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(times==80)break;
		}
		
	}

	
}