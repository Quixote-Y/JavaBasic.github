package tankGame;

import java.io.Serializable;
import java.util.Vector;

public class MyTank extends Tank implements Serializable {

	private static final long serialVersionUID = 1L;
	Vector<Shot> myShots = new Vector<>();//�ӵ��Ƕ�ţ�����һ��Vector���洢�ӵ��߳�
	private boolean alive=true;
	// ����һ��Shot��
	Shot shot = null;

	
	public MyTank(int x, int y, Vector<Shot> myShots, boolean alive, Shot shot) {
		super(x, y);
		this.myShots = myShots;
		this.alive = alive;
		this.shot = shot;
	}

	
	public MyTank(int x, int y) {
		super(x, y);
	}


	public MyTank() {
		super();
	}


	public void shotEnemy() {
		// ���ݵ�ǰ̹�˵ķ���������Shot����Ȼ��ʼ����߳�
		switch (getDirection()) {
		case 0:
			shot = new Shot(getX() + 18, getY() - 10, 0);
			myShots.add(shot);
			break;
		case 1:
			shot = new Shot(getX() + 18, getY() + 70, 1);
			myShots.add(shot);
			break;
		case 2:
			shot = new Shot(getX() - 10, getY() + 18, 2);
			myShots.add(shot);
			break;
		case 3:
			shot = new Shot(getX() + 70, getY() + 18, 3);
			myShots.add(shot);
			break;
		}
		new Thread(shot).start();
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	

}