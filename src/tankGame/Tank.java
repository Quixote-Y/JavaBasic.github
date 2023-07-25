package tankGame;

import java.io.Serializable;

public class Tank implements Serializable{

	private int x;// 坦克x坐标
	private int y;// 坦克y坐标
	private int direction;// 坦克方向
	private boolean alive =true;
	private int speed =10;
	private boolean meet=false;

	public int getDirection() {
		return direction;
	}
	

	public Tank() {
		super();
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Tank(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Tank(int x, int y, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveUp() {
		if(y-10<=0)return;
		y -= speed;
	}

	public void moveDown() {
		if(y+70>=750)return;
		y += speed;
	}

	public void moveLeft() {
		if(x-10<=0)return;
		x -= speed;
	}

	public void moveRight() {
		if(x+70>=1000)return;
		x += speed;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isMeet() {
		return meet;
	}

	public void setMeet(boolean meet) {
		this.meet = meet;
	}
	
	

}
