package threadTest;
//ͨ��ʵ��Runnable�ӿڣ���дrun������ʵ�ֶ��߳�
//��һ�����Ѿ��̳�����һ���࣬����java�ǵ��̳���ô��ͨ���̳�Thread��ʵ�ֶ��߳̾Ͳ������ˣ���������һ��ʵ�ֽӿڵķ�ʽ
//ʵ��runnable�ӿڸ��ʺ϶���̹߳���һ����Դ������Դ�������̣߳�Ȼ����Ĳ�������ͬһ���������ǹ���һ����Դ
//һ�㳣��ʵ��Runnable�ӿڵķ�ʽ��ʵ�ֶ��߳�
public class ThreadBasicUse2 {

	public static void main(String[] args) {
		Dog dog=new Dog();
		//�϶��ǲ���ֱ�ӵ���dog.run,����ֻ����һ��main�߳�
		//Runnable�ӿ�Ҳû��start����,��ôȥ����Thread��start������
		//�����õ��˴���ģʽ
		Thread thread=new Thread(dog);
		thread.start();	
		
		//������ģ���
//		System.out.println("--------ģ��-------");
//		Fish fish=new Fish();
//		ThreadProxy tp=new ThreadProxy(fish);//
//		tp.start();
		
	}
}
//
class Dog implements Runnable{

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		int times=0;
		while(true) {
			System.out.println("С������"+(++times)+Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(times==10)break;
		}
		
		
	}
	
}


//����ģʽ��ʶ
class Animal{}
class Fish extends Animal implements Runnable{//�޷��̳�Thread
	public void run() {
		System.out.println("С�㹾����");
	}
}
//ģ��Thread��Ļ���
class ThreadProxy implements Runnable{

	private Runnable target=null;//��һ�����ԣ�������   Runnable
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		if(target!=null) {
			target.run();//--------���е�ʱ��ȥ������ʵ����ʱ�Ķ����run����
		}	
	}
	public ThreadProxy(Runnable target) {
		this.target=target; //        ����ʵ�����̴߳�����ʱ���Դ���һ��ʵ����Runnable�ӿڵ��࣬Ȼ���������target
	}
	public void start() {//ȥ����start0���������߳�
		start0();
	}
	public void start0() {
		run();//��ʵ�ʵ�Thread���У�start0��jvm�������̣߳�cpu������ȥ����thread��run����
	}
	//������ǣ��㴫��һ��ʵ����Runnable�ӿڵ��ࣨ����ת�ͣ���Ȼ���������ᱻ����Thread��target����ΪThread��run�����Ĳ���
	  //        �����߳�Start������ʼ���̣߳���cpuȥ��������run���������ڶ�̬�����������е���Runnable�е�run����ʵ�����е���Fish����д��run������ʵ�ֶ��߳�
	//          �ҵ������  Runnable�ӿ���Ϊ�м̴���  ʵ�������������
}