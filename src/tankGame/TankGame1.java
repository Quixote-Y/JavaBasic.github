package tankGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class TankGame1 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		TankGame1 tankgame=new TankGame1();
	}
	public TankGame1(){
		System.out.println("��ѡ��1.��ʼ����Ϸ  2.�����ϴ���Ϸ");
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		mp=new MyPanel(input-1);//newһ��MyPanel
		this.add(mp);//��panel�ӵ�Frame��
		
		//�����ػ��̣߳���mp�ӵ�Thread��
		new Thread(mp).start();
		//�Ѽ������ӵ������
		this.addKeyListener(mp);
		this.setSize(1150,750);//����Frame���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����˳�
		this.setVisible(true);//�ɼ�
		//��JFrame���һ���������������Ƿ����X
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO �Զ����ɵķ������
				Recoder.storeRecode();
			}
			
		
		});
	}
}
