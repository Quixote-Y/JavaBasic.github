package threadTest;
//����Լ�д�ģ���װ�Ը���
//�´����þ�̬����֮ǰӦ���ȿ���һ���ܲ����ò������ݵķ������滻��
import java.util.Scanner;

public class Practice2Teacher {

	public static void main(String[] args) {
		Task3 tmp=new Task3();
		new Thread(tmp).start();
		new Thread(new Task4(tmp)).start();
	}
}

class Task3 implements Runnable {
	private boolean loop = true;

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (loop) {
			System.out.print("�߳�1�������  ");
			System.out.println((int) (Math.random() * 100 + 1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		System.out.println("Task1�˳�");
	}
	//

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
}

class Task4 implements Runnable{
    //��ҪTask4�߳���֪ͨtask3�̣߳�Ҫ���װ�Ըߣ�����Ӿ�̬��������õİ취������Task4ӵ��һ��
	 //Task3����
	private Task3 task3=null;
	Scanner scanner=new Scanner(System.in);
	public Task4(Task3 task3) {
		super();
		this.task3 = task3;//����Task4ʱ����һ��Task3�������Ϳ��԰�Task3��Task4��ͨ����
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true) {
			System.out.println("������ָ�");
			char input=scanner.next().toUpperCase().charAt(0);
			if(input=='Q') {
				task3.setLoop(false);
				System.out.println("Task2�˳�");
				break;
			}
		}
	}
	
}