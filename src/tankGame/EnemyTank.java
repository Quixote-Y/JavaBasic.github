package tankGame;

import java.io.Serializable;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable ,Serializable{

	private boolean alive=true;
    private static final long serialVersionUID = 1L;
	Vector<Shot> shots=new Vector<>();//子弹是多颗，创建一个Vector，存储子弹线程
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO 自动生成的构造函数存根
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public EnemyTank() {
		super();
	}
	public EnemyTank(boolean alive, Vector<Shot> shots) {
		super();
		this.alive = alive;
		this.shots = shots;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		int count=0;
		int shoter=0;
		setDirection((int)(Math.random()*4));
		while(alive) {
			count= count==10?0:++count;
			if(count==10) {
				setDirection((int)(Math.random()*4));				
			}
			shoter=(int)(Math.random()*10);
			switch(getDirection()) {
			case 0:
				if(isMeet()) {
					setMeet(false);
					setDirection(1);//干涉方向选择，直接转头
					moveDown();
					break;
				}
				moveUp();
				if(shots.isEmpty()||shoter==4) {
					Shot shotTmp=new Shot(getX()+18,getY()-10,getDirection());
					shots.add(shotTmp);
					new Thread(shotTmp).start();
				}
				break;
			case 1:
				if(isMeet()) {
					setDirection(0);//干涉方向选择，直接转头
					moveUp();
					setMeet(false);
					break;
				}
				moveDown();
				if(shots.isEmpty()||shoter==4) {
					Shot shotTmp=new Shot(getX()+18,getY()+70,getDirection());
					shots.add(shotTmp);
					new Thread(shotTmp).start();
				}
				break;
			case 2:
				if(isMeet()) {
					setDirection(3);//干涉方向选择，直接转头
					moveRight();
					setMeet(false);
					break;
				}
				moveLeft();
				if(shots.isEmpty()||shoter==4) {
					Shot shotTmp=new Shot(getX()-10,getY()+18,getDirection());
					shots.add(shotTmp);
					new Thread(shotTmp).start();
				}
				break;
			case 3:
				if(isMeet()) {
					setDirection(2);//干涉方向选择，直接转头
					moveLeft();
					setMeet(false);
					break;
				}
				moveRight();
				
				if(shots.isEmpty()||shoter==4) {
					Shot shotTmp=new Shot(getX()+70,getY()+18,getDirection());
					shots.add(shotTmp);
					new Thread(shotTmp).start();
				}
				break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	

}
