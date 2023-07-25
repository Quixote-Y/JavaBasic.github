package event;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//java�¼��������--���������¼������¼�Դ������---ί���¼�ģ��
//����С���ƶ�
public class Event extends JFrame {
	MyPanel mp=null;
	public static void main(String[] args) {
		Event en=new Event();
	}
	public Event() {
		mp=new MyPanel();
		this.add(mp);
		//���������������ŵ������
		this.addKeyListener(mp);
		this.setSize(1000,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
}
//��������һ��ԭ���������ƶ�����ô�ƶ���
//1.�¼���������Panelʵ��һ�������ӿ�KeyListener��KeyListener��һ�������������Լ��������¼�
//���ƾ��ǣ����¼�Դ����һ���¼�������һ���¼���������̾���KeyEvent���󣬼�������������ͨ���ӿ������ķ�������ʵ�ּ������ӿڵ����������¼�

class MyPanel extends JPanel implements KeyListener{

	int x=10;
	int y=10;//ͨ������������������Բ���ɵ�λ��
	@Override
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);
		//draw circle
		g.fillOval(x, y, 100, 100);//default black
	}

	//һ����KeyListener�ӿڵķ���
	//���ַ����ʱ�������������
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
//�а���������ʱ������
//��Ҫ����С���ƶ�������͹���
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		//���ݰ��������������ı�xy��ֵ��Ȼ���ػ�ͼ��
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {//���¼�ͷ
			y+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			y-=10;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			x+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			x-=10;
		}
		
		//�ػ�
		this.repaint();
		
	}
//�������ͷ�ʱ����
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
	
}
