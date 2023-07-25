package tankGame;

public class Boom implements Runnable{

	private int x,y;
	private int life=9;
	private boolean alive=true;
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
	    while(alive){
	    	lifeDown();
	    	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	    	
	    }
		
	}
	
	public void lifeDown() {
		if(life>0) {
			life--;
		}else {
			alive=false;
		}
		
	}

	public Boom(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
