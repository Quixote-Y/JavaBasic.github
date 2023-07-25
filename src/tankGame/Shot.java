package tankGame;

import java.io.Serializable;

public class Shot implements Runnable ,Serializable{

	private int x;
	private int y;
	private int direction;
	private int speed = 18;
	private boolean alive = true;
	private static final long serialVersionUID = 1L;

	public Shot(int x, int y, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (true) {
			switch (direction) {
			case 0:// ��
				y -= speed;break;

			case 1:// ��
				y += speed;break;

			case 2:// zuo
				x -= speed;break;

			case 3:// you
				x += speed;break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			if(!((0<=x&&x<=1000)&&(0<=y&&y<=750)&&alive)) {
				alive=false;
				break;//�ӵ�����߽�
			}

		}
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	

}
