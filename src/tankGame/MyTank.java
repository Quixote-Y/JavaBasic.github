package tankGame;

import java.io.Serializable;
import java.util.Vector;

public class MyTank extends Tank implements Serializable {

	private static final long serialVersionUID = 1L;
	Vector<Shot> myShots = new Vector<>();//子弹是多颗，创建一个Vector，存储子弹线程
	private boolean alive=true;
	// 定义一个Shot类
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
		// 根据当前坦克的方向来创建Shot对象，然后开始这个线程
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