package testInterface;
/**
 * 接口初体验
 * @author 86136
 *
 */
//飞行接口
public interface Volant {

	public static final int Fly_DISTANCE =100;
	/*public static final */int Fly_HIGHT =100;//接口中的常量默认且只能是
	                                            //public static final格式,写不写都一样
	/*public abstract*/ void fly();//抽象方法
	
}
//善良接口
interface Honest {
	void helpOther();

}

class GoodMan implements Honest{
//可以编译器自动添加，实现接口的类必须实现接口：implements
	@Override
	public void helpOther() {
		// TODO 自动生成的方法存根
		
		System.out.println("好人扶老奶奶过马路");
		
	}
	
}

class BirdMan implements Volant{

	@Override
	public void fly() {
		// TODO 自动生成的方法存根
		System.out.println("BirdFly");
	}
	
}

class Angel implements Volant,Honest{
//实现两个接口
	@Override
	public void helpOther() {
		// TODO 自动生成的方法存根
		System.out.println("angel帮助他人");
		
	}

	@Override
	public void fly() {
		// TODO 自动生成的方法存根
		System.out.println("angel飞");
	}
	
}

class Plane implements Volant{

	@Override
	public void fly() {
		// TODO 自动生成的方法存根
		System.out.println("飞机起飞");
	}
	
}

