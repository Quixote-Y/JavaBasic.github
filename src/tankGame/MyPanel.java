package tankGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JPanel;

//��Ϸ��ͼ��
public class MyPanel extends JPanel implements KeyListener, Runnable {// ��myPanel ʵ��Runnable�ӿڣ���һ��������̣߳�ÿ��һ��ʱ����ػ�

	// �����Լ���̹��
	static MyTank myTank = null;
//	EnemyTank enemyTank=null;
//	EnemyTank enemyTank2=null;
//	EnemyTank enemyTank3=null;
	// ���˵�̹�������࣬�漰�����̲߳��������ǿ��԰����Ƿŵ�Vector��
	static Vector<EnemyTank> enemyTank = new Vector();

	int enemyTankSize = 3;
	//
	Vector<Boom> booms = new Vector<>();
	Image image1 = Toolkit.getDefaultToolkit().getImage("E:\\javacode\\LearnJava\\src\\image\\1.png");
	Image image2 = Toolkit.getDefaultToolkit().getImage("E:\\javacode\\LearnJava\\src\\image\\2.png");
	Image image3 = Toolkit.getDefaultToolkit().getImage("E:\\javacode\\LearnJava\\src\\image\\3.png");
    
	
	public MyPanel(int input) {
		switch (input) {
		case 1: {
			// ������Ϸ
			File file = new File(Recoder.getPath());
			if (file.exists()) {
				Recoder.loadRecod();
				// �������е�̹���߳�
				for (int i = 0; i < enemyTank.size(); i++) {
					new Thread(enemyTank.get(i)).start();
					// �������е��˵��ӵ��߳�
					for (int j = 0; j < enemyTank.get(i).shots.size(); j++) {
						new Thread(enemyTank.get(i).shots.get(j)).start();
					}
				}
				// �����Լ��Ѽ�����ӵ��߳�
				for (int i = 0; i < myTank.myShots.size(); i++) {
					new Thread(myTank.myShots.get(i)).start();
				}
				break;

			} else {
				System.out.println("�ļ�������ֻ���ؿ�");
			}

			
		}
		case 0: {
			myTank = new MyTank(500, 500);
//		    enemyTank=new EnemyTank(100,100);
//		    enemyTank2=new EnemyTank(200,100);
//		    enemyTank3=new EnemyTank(300,100);
			// ��������̹��
			for (int i = 0; i < enemyTankSize; i++) {
				EnemyTank enemyTanktmp = new EnemyTank(100 * (i + 1), 100);
				enemyTanktmp.setDirection(1);// �ѵ�����Ͳ����

				// ��������̹�˵�ʱ���ʼ��һ���ӵ�
//			Shot shot = new Shot(enemyTanktmp.getX() + 20, enemyTanktmp.getY() + 70, enemyTanktmp.getDirection());
//			enemyTanktmp.shots.add(shot);
//			// ����Shot�����߳�
//			new Thread(shot).start();

				new Thread(enemyTanktmp).start();
				enemyTank.add(enemyTanktmp);
			}
		}

		}
		//��������
		new AePlayWave("src\\111.wav").start();

	}

	@Override // ��ôѭ����ӡ�ӵ��أ���Ҫ��ͣ��repaint����myPanel ʵ��Runnable�ӿڣ���һ��������̣߳�ÿ��һ��ʱ����ػ�
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);
		// ������
		g.fillRect(0, 0, 1000, 750);
		// ��һ��̹��--��������װ��������
		// ���û�̹�˷���
//		paintTank(myTank.getX(),myTank.getY(),g,0,0);//��
//		paintTank(myTank.getX()+100,myTank.getY(),g,0,1);//��
//		paintTank(myTank.getX()+200,myTank.getY(),g,0,2);//��
//		paintTank(myTank.getX()+300,myTank.getY(),g,0,3);//��
		if (enemyTank.isEmpty()) {
			g.setColor(Color.red);// ��ɫ
			g.setFont(new Font("����", Font.BOLD, 200));// ���壬newһ��Font���ÿ��飬�Ӵ֣���С50
			g.drawString("WINER", 300, 325);// д�֣�
		}
		if (myTank.isAlive()) {
			paintTank(myTank.getX(), myTank.getY(), g, 0, myTank.getDirection());
		} else {
			g.setColor(Color.red);// ��ɫ
			g.setFont(new Font("����", Font.BOLD, 200));// ���壬newһ��Font���ÿ��飬�Ӵ֣���С50
			g.drawString("LOSER", 300, 325);// д�֣�
		}
//		paintTank(enemyTank.getX(),enemyTank.getY(),g,1,enemyTank.getDirection());
//		paintTank(enemyTank2.getX(),enemyTank2.getY(),g,1,enemyTank2.getDirection());
//		paintTank(enemyTank3.getX(),enemyTank3.getY(),g,1,enemyTank3.getDirection());

		for (int i = 0; i < enemyTank.size(); i++) {
			// ѭ����ͼ
			EnemyTank enemy = enemyTank.get(i);
			if (!enemy.isAlive()) {
				enemyTank.remove(i);
				break;
			}
			paintTank(enemy.getX(), enemy.getY(), g, 1, enemy.getDirection());
			// ���Ƹ�̹�˵������ӵ�
			for (int j = 0; j < enemy.shots.size(); j++) {
				// �ж��ӵ�״̬
				if (enemy.shots.get(j).isAlive()) {
					g.setColor(Color.yellow);
					g.fillOval(enemy.shots.get(j).getX(), enemy.shots.get(j).getY(), 5, 5);
				} else {
					// ��Vector�Ƴ�
					enemy.shots.remove(j);
				}
			}
		}
		// ���Ƽ���̹���ӵ�,Ҫ�����е��ӵ�����ӡ������������ֻ��ӡһ���ӵ�
		for (int i = 0; i < myTank.myShots.size(); i++) {
			Shot shot = myTank.myShots.get(i);
			if (shot.isAlive()) {
				g.setColor(Color.cyan);
				g.fillOval(shot.getX(), shot.getY(), 5, 5);
			} else {
				myTank.myShots.remove(i);
			}
		}
		for (int i = 0; i < booms.size(); i++) {
			Boom boomTmp = booms.get(i);
			if (boomTmp.isAlive()) {
				int life = boomTmp.getLife();
				if (life > 6) {
					g.drawImage(image1, boomTmp.getX(), boomTmp.getY(), 100, 100, this);
				} else if (life > 3) {
					g.drawImage(image2, boomTmp.getX(), boomTmp.getY(), 100, 100, this);
				} else if (life > 0) {
					g.drawImage(image3, boomTmp.getX(), boomTmp.getY(), 100, 100, this);
				} else if (life == 0) {
					booms.remove(i);
				}
			}
		}
		// �����ְ�
		g.setColor(Color.black);// ��ɫ
		g.setFont(new Font("����", Font.PLAIN, 30));// ���壬newһ��Font���ÿ��飬��С10
		g.drawString("�Ʒְ壺", 1000, 30);// д�֣�
		paintTank(1030, 60, g, 2, 4);
		g.drawString(":X", 1050, 85);
		g.drawString((enemyTank.size()) + "", 1100, 85);

	}

	/**
	 * 
	 * @param x         ̹��x����
	 * @param y         ̹��y�������Ͻ�
	 * @param g         ����
	 * @param type      �ֱ治ͬ����̹��
	 * @param direction �ĸ������̹��ʲô����
	 */
	public void paintTank(int x, int y, Graphics g, int type, int direction) {
		switch (type) {
		case 0:// �Լ���̹��
			g.setColor(Color.cyan);
			break;
		case 1:// �����̹��
			g.setColor(Color.yellow);
			break;
		case 2:// չʾ��
			g.setColor(Color.black);
			g.fill3DRect(x, y, 5, 30, false);// ����
			g.fill3DRect(x + 15, y, 5, 30, false);// ����
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// �м�
			g.fillOval(x + 5, y + 10, 10, 10);// Բ��
			g.fill3DRect(x + 9, y - 5, 3, 20, false);
			break;
		}
		switch (direction) {
		case 0:// ����
			g.fill3DRect(x, y, 10, 60, false);// ����
			g.fill3DRect(x + 30, y, 10, 60, false);// ����
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// �м�
			g.fillOval(x + 10, y + 20, 20, 20);// Բ��
			g.fill3DRect(x + 18, y - 10, 5, 40, false);
			break;
		case 1:// ����
			g.fill3DRect(x, y, 10, 60, false);// ����
			g.fill3DRect(x + 30, y, 10, 60, false);// ����
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// �м�
			g.fillOval(x + 10, y + 20, 20, 20);// Բ��
			g.fill3DRect(x + 18, y + 30, 5, 40, false);
			break;
		case 2:// ����
			g.fill3DRect(x, y, 60, 10, false);// ����
			g.fill3DRect(x, y + 30, 60, 10, false);// ����
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// �м�
			g.fillOval(x + 20, y + 10, 20, 20);// Բ��
			g.fill3DRect(x - 10, y + 18, 40, 5, false);
			break;
		case 3:// ����
			g.fill3DRect(x, y, 60, 10, false);// ����
			g.fill3DRect(x, y + 30, 60, 10, false);// ����
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// �м�
			g.fillOval(x + 20, y + 10, 20, 20);// Բ��
			g.fill3DRect(x + 30, y + 18, 40, 5, false);
			break;
		case 4:// null
			break;
		}
	}

	// KeyListener����
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getKeyCode() == KeyEvent.VK_A) {
			// myTank.setX(myTank.getX()-5);
			myTank.setDirection(2);
			myTank.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			// myTank.setY(myTank.getY()-5);
			myTank.setDirection(0);
			myTank.moveUp();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			// myTank.setY(myTank.getY()+5);
			myTank.setDirection(1);
			myTank.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			// myTank.setX(myTank.getX()+5);-->����ط���װ���ã�һ������ѡ���װ��������ȥ
			myTank.setDirection(3);
			myTank.moveRight();// ������󣡣���
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			// ������J�������Լ���̹�����
			myTank.shotEnemy();
		}
		// �ػ�
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������

	}

	// �ж��ӵ��Ƿ��ез�̹��
	public void hitEnemy(Shot shot, Tank enemyTank) {
		if (!shot.isAlive())
			return;// �ӵ��Ѿ�������
		// ���ݵз�̹�˵ķ����ж��ӵ������Ƿ��̹���غ�
		switch (enemyTank.getDirection()) {
		case 0:
		case 1:
			if (shot.getX() > enemyTank.getX() && shot.getX() < (enemyTank.getX() + 40)
					&& shot.getY() > enemyTank.getY() && shot.getY() < (enemyTank.getY() + 60)) {

				enemyTank.setAlive(false);// ���õз�̹��������ȥ�ػ���������ˢ��
				// �ӵ�ҲʧЧ
				shot.setAlive(false);

				Boom a = new Boom(enemyTank.getX(), enemyTank.getY());
				new Thread(a).start();
				booms.add(a);

				break;
			}
		case 2:
		case 3:
			if (shot.getX() > enemyTank.getX() && shot.getX() < (enemyTank.getX() + 60)
					&& shot.getY() > enemyTank.getY() && shot.getY() < (enemyTank.getY() + 40)) {

				enemyTank.setAlive(false);// ���õз�̹��������ȥ�ػ���������ˢ��
				// �ӵ�ҲʧЧ
				shot.setAlive(false);
				Boom a = new Boom(enemyTank.getX(), enemyTank.getY());
				new Thread(a).start();
				booms.add(a);
				break;
			}
		}
	}

	// �������̹���Ƿ�����
	// ������ײ���� 1.����ʲôʱ����ײ
	// 2.����ʲôʱ����ײ

	public void isMeet(Tank a, Tank b) {
		// one ��two��������ֱ�洢�������ε����Ͻ���������½�����
		int[] one = new int[4];
		int[] two = new int[4];
		one[0] = a.getX();
		one[1] = a.getY();
		one[2] = one[0] + 60;
		one[3] = one[1] + 60;

		two[0] = b.getX();
		two[1] = b.getY();
		two[2] = two[0] + 60;
		two[3] = two[1] + 60;

		boolean meet = notMeet(one, two);
		if (meet == true) {
			a.setMeet(true);
			b.setMeet(true);
		}

	}

	// һ������ľ�����ײ��ⷽ����
	// �����������ε����ϽǺ����½�����
	// �����������Σ�һ�������ǵľ��Σ���һ���Ƕ���ľ��Σ�������one��������two
	public boolean notMeet(int[] one, int[] two) {
		if (one[0] > two[2])
			return false;// ����ľ����ұߵıߵ�x����С�����ǵ���ߵıߵ�x���꣬���������
		if (one[1] > two[3])
			return false;// �����������ıߵ�y����С����������ıߵ�y���꣬������������
		if (one[2] < two[0])
			return false;// ���������ߵıߵ�x������������ұߵı��x���꣬���������ұ�
		if (one[3] < two[1])
			return false;// �������������ıߵ�y�����������������ıߵ�y���꣬������������
		return true;// û����ȫ���������ң��Ǿ����ཻ��
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (true) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			// ���̹���Ƿ񱻻��У��ػ�run����һֱִ�У���v�����жϣ��ܺ�
			for (int i = 0; i < myTank.myShots.size(); i++) {
				Shot shot = myTank.myShots.get(i);
				for (int j = 0; j < enemyTank.size(); j++) {
					hitEnemy(shot, enemyTank.get(j));
				}
			}
			for (int i = 0; i < enemyTank.size(); i++) {
				for (int j = 0; j < enemyTank.get(i).shots.size(); j++) {
					Shot shot = enemyTank.get(i).shots.get(j);
					hitEnemy(shot, myTank);
				}
			}
			// ��¼�з�̹��������Recoder
			Recoder.setEnemyTankNumber(enemyTank.size());

			// �������̹���Ƿ�����
			for (int i = 0; i < enemyTank.size(); i++) {
				for (int j = i + 1; j < enemyTank.size(); j++) {
					isMeet(enemyTank.get(i), enemyTank.get(j));
				}
			}

			this.repaint();// ÿ��40������ػ�һ��
		}
	}
}
