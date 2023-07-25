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

//游戏绘图区
public class MyPanel extends JPanel implements KeyListener, Runnable {// 把myPanel 实现Runnable接口，做一个额外的线程，每隔一段时间就重绘

	// 定义自己的坦克
	static MyTank myTank = null;
//	EnemyTank enemyTank=null;
//	EnemyTank enemyTank2=null;
//	EnemyTank enemyTank3=null;
	// 敌人的坦克数量多，涉及到多线程操作，我们可以把他们放到Vector里
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
			// 继续游戏
			File file = new File(Recoder.getPath());
			if (file.exists()) {
				Recoder.loadRecod();
				// 启动所有的坦克线程
				for (int i = 0; i < enemyTank.size(); i++) {
					new Thread(enemyTank.get(i)).start();
					// 启动所有敌人的子弹线程
					for (int j = 0; j < enemyTank.get(i).shots.size(); j++) {
						new Thread(enemyTank.get(i).shots.get(j)).start();
					}
				}
				// 启动自己已激活的子弹线程
				for (int i = 0; i < myTank.myShots.size(); i++) {
					new Thread(myTank.myShots.get(i)).start();
				}
				break;

			} else {
				System.out.println("文件不存在只能重开");
			}

			
		}
		case 0: {
			myTank = new MyTank(500, 500);
//		    enemyTank=new EnemyTank(100,100);
//		    enemyTank2=new EnemyTank(200,100);
//		    enemyTank3=new EnemyTank(300,100);
			// 创建敌人坦克
			for (int i = 0; i < enemyTankSize; i++) {
				EnemyTank enemyTanktmp = new EnemyTank(100 * (i + 1), 100);
				enemyTanktmp.setDirection(1);// 把敌人炮筒朝下

				// 创建敌人坦克的时候初始化一颗子弹
//			Shot shot = new Shot(enemyTanktmp.getX() + 20, enemyTanktmp.getY() + 70, enemyTanktmp.getDirection());
//			enemyTanktmp.shots.add(shot);
//			// 启动Shot对象线程
//			new Thread(shot).start();

				new Thread(enemyTanktmp).start();
				enemyTank.add(enemyTanktmp);
			}
		}

		}
		//播放音乐
		new AePlayWave("src\\111.wav").start();

	}

	@Override // 怎么循环打印子弹呢，需要不停的repaint，把myPanel 实现Runnable接口，做一个额外的线程，每隔一段时间就重绘
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		// 填充矩形
		g.fillRect(0, 0, 1000, 750);
		// 画一个坦克--》》》封装到方法里
		// 调用画坦克方法
//		paintTank(myTank.getX(),myTank.getY(),g,0,0);//上
//		paintTank(myTank.getX()+100,myTank.getY(),g,0,1);//下
//		paintTank(myTank.getX()+200,myTank.getY(),g,0,2);//左
//		paintTank(myTank.getX()+300,myTank.getY(),g,0,3);//左
		if (enemyTank.isEmpty()) {
			g.setColor(Color.red);// 颜色
			g.setFont(new Font("楷体", Font.BOLD, 200));// 字体，new一个Font，用楷书，加粗，大小50
			g.drawString("WINER", 300, 325);// 写字，
		}
		if (myTank.isAlive()) {
			paintTank(myTank.getX(), myTank.getY(), g, 0, myTank.getDirection());
		} else {
			g.setColor(Color.red);// 颜色
			g.setFont(new Font("楷体", Font.BOLD, 200));// 字体，new一个Font，用楷书，加粗，大小50
			g.drawString("LOSER", 300, 325);// 写字，
		}
//		paintTank(enemyTank.getX(),enemyTank.getY(),g,1,enemyTank.getDirection());
//		paintTank(enemyTank2.getX(),enemyTank2.getY(),g,1,enemyTank2.getDirection());
//		paintTank(enemyTank3.getX(),enemyTank3.getY(),g,1,enemyTank3.getDirection());

		for (int i = 0; i < enemyTank.size(); i++) {
			// 循环画图
			EnemyTank enemy = enemyTank.get(i);
			if (!enemy.isAlive()) {
				enemyTank.remove(i);
				break;
			}
			paintTank(enemy.getX(), enemy.getY(), g, 1, enemy.getDirection());
			// 绘制该坦克的所有子弹
			for (int j = 0; j < enemy.shots.size(); j++) {
				// 判断子弹状态
				if (enemy.shots.get(j).isAlive()) {
					g.setColor(Color.yellow);
					g.fillOval(enemy.shots.get(j).getX(), enemy.shots.get(j).getY(), 5, 5);
				} else {
					// 从Vector移除
					enemy.shots.remove(j);
				}
			}
		}
		// 绘制己方坦克子弹,要把所有的子弹都打印出来，而不是只打印一颗子弹
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
		// 画积分板
		g.setColor(Color.black);// 颜色
		g.setFont(new Font("楷体", Font.PLAIN, 30));// 字体，new一个Font，用楷书，大小10
		g.drawString("计分板：", 1000, 30);// 写字，
		paintTank(1030, 60, g, 2, 4);
		g.drawString(":X", 1050, 85);
		g.drawString((enemyTank.size()) + "", 1100, 85);

	}

	/**
	 * 
	 * @param x         坦克x坐标
	 * @param y         坦克y坐标左上角
	 * @param g         画笔
	 * @param type      分辨不同类型坦克
	 * @param direction 四个方向的坦克什么摸样
	 */
	public void paintTank(int x, int y, Graphics g, int type, int direction) {
		switch (type) {
		case 0:// 自己的坦克
			g.setColor(Color.cyan);
			break;
		case 1:// 对面的坦克
			g.setColor(Color.yellow);
			break;
		case 2:// 展示用
			g.setColor(Color.black);
			g.fill3DRect(x, y, 5, 30, false);// 左轮
			g.fill3DRect(x + 15, y, 5, 30, false);// 右轮
			g.fill3DRect(x + 5, y + 5, 10, 20, false);// 中间
			g.fillOval(x + 5, y + 10, 10, 10);// 圆形
			g.fill3DRect(x + 9, y - 5, 3, 20, false);
			break;
		}
		switch (direction) {
		case 0:// 朝上
			g.fill3DRect(x, y, 10, 60, false);// 左轮
			g.fill3DRect(x + 30, y, 10, 60, false);// 右轮
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// 中间
			g.fillOval(x + 10, y + 20, 20, 20);// 圆形
			g.fill3DRect(x + 18, y - 10, 5, 40, false);
			break;
		case 1:// 朝下
			g.fill3DRect(x, y, 10, 60, false);// 左轮
			g.fill3DRect(x + 30, y, 10, 60, false);// 右轮
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// 中间
			g.fillOval(x + 10, y + 20, 20, 20);// 圆形
			g.fill3DRect(x + 18, y + 30, 5, 40, false);
			break;
		case 2:// 朝左
			g.fill3DRect(x, y, 60, 10, false);// 左轮
			g.fill3DRect(x, y + 30, 60, 10, false);// 右轮
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// 中间
			g.fillOval(x + 20, y + 10, 20, 20);// 圆形
			g.fill3DRect(x - 10, y + 18, 40, 5, false);
			break;
		case 3:// 朝右
			g.fill3DRect(x, y, 60, 10, false);// 左轮
			g.fill3DRect(x, y + 30, 60, 10, false);// 右轮
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// 中间
			g.fillOval(x + 20, y + 10, 20, 20);// 圆形
			g.fill3DRect(x + 30, y + 18, 40, 5, false);
			break;
		case 4:// null
			break;
		}
	}

	// KeyListener方法
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
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
			// myTank.setX(myTank.getX()+5);-->这个地方封装不好，一般我们选择封装到类里面去
			myTank.setDirection(3);
			myTank.moveRight();// 面向对象！！！
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			// 当按下J，我们自己的坦克射击
			myTank.shotEnemy();
		}
		// 重绘
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	// 判断子弹是否鸡中敌方坦克
	public void hitEnemy(Shot shot, Tank enemyTank) {
		if (!shot.isAlive())
			return;// 子弹已经出界了
		// 根据敌方坦克的方向，判断子弹坐标是否和坦克重合
		switch (enemyTank.getDirection()) {
		case 0:
		case 1:
			if (shot.getX() > enemyTank.getX() && shot.getX() < (enemyTank.getX() + 40)
					&& shot.getY() > enemyTank.getY() && shot.getY() < (enemyTank.getY() + 60)) {

				enemyTank.setAlive(false);// 设置敌方坦克死亡，去重绘内让他不刷新
				// 子弹也失效
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

				enemyTank.setAlive(false);// 设置敌方坦克死亡，去重绘内让他不刷新
				// 子弹也失效
				shot.setAlive(false);
				Boom a = new Boom(enemyTank.getX(), enemyTank.getY());
				new Thread(a).start();
				booms.add(a);
				break;
			}
		}
	}

	// 检测两辆坦克是否相遇
	// 矩形碰撞问题 1.考虑什么时候相撞
	// 2.考虑什么时候不相撞

	public void isMeet(Tank a, Tank b) {
		// one 和two两个数组分别存储两个矩形的左上角坐标和右下角坐标
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

	// 一个绝妙的矩形碰撞检测方法：
	// 传入两个矩形的左上角和右下角坐标
	// 假设两个矩形，一个是我们的矩形，另一个是对面的矩形，我们是one，对面是two
	public boolean notMeet(int[] one, int[] two) {
		if (one[0] > two[2])
			return false;// 对面的矩形右边的边的x坐标小于我们的左边的边的x坐标，在我们左边
		if (one[1] > two[3])
			return false;// 对面矩形下面的边的y坐标小于我们上面的边的y坐标，他在我们上面
		if (one[2] < two[0])
			return false;// 对面矩形左边的边的x坐标大于我们右边的表的x坐标，他在我们右边
		if (one[3] < two[1])
			return false;// 对面矩形最上面的边的y坐标大于我们最下面的边的y坐标，他在我们下面
		return true;// 没有完全在上下左右，那就是相交了
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			// 检查坦克是否被击中，重绘run方法一直执行，且v不会中断，很好
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
			// 记录敌方坦克数量到Recoder
			Recoder.setEnemyTankNumber(enemyTank.size());

			// 检测两辆坦克是否相遇
			for (int i = 0; i < enemyTank.size(); i++) {
				for (int j = i + 1; j < enemyTank.size(); j++) {
					isMeet(enemyTank.get(i), enemyTank.get(j));
				}
			}

			this.repaint();// 每隔40毫秒就重绘一次
		}
	}
}
