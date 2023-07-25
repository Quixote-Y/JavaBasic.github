package enumTest;
/*
 * 枚举类常用于：类对象固定，类成员属性固定，
 * 不应该被他人随意修改的地方
 * 此代码包含：自定义枚举和enum关键字枚举
 */
public class EnumClass {
	
	public static void main(String[] args) {
		System.out.println(Season.AUTUM.toString());
		System.out.println(Season.WINTER.toString());
		System.out.println(Season2.AUTUM.toString());
		System.out.println(Season2.WINTER.toString());
		
		//面试题
		Gender boy=Gender.BOY;
		Gender boy2=Gender.BOY;
		System.out.println(boy);//输出boy，本质是调用Gender的toString方法，但Gender没有重写
		                  //这个方法，所以像父类追溯，找到父类Enum的toString并执行
		
		System.out.println(boy2==boy);//true,常量赋值
		Music.CLASSICMUSIC.play();//这样就可以调用实现接口里的方法
	}

}
enum Gender{
	BOY,GIRL;
}
//自定义枚举类
class Season{//类
	
	private String name;
	private String desc;//描述
	//3.自定义四个枚举类，固定
	public static final Season SPRING =new Season("春天","温暖的");
	public static final Season SUMMER =new Season("夏天","炎热的");
	public static final Season AUTUM  =new Season("秋天","萧瑟的");
	public static final Season WINTER =new Season("冬天","寒冷的");
	
	//步骤：
	/*1. 构造器私有化，让外部无法调用new来实例化这个类
	 *2. 去除set方法，只保留get方法，不让外部改变值
	 *3. 在类里创建一组对象，即枚举出对象，
	 *   添加pubic fianl static修饰符，
	 *   枚举类因为是常量一般全都大写
	 */
	/*1*/
	private  Season(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	/*2*/
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getDesc() {
		return desc;
	}
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
	@Override
	public String toString() {
		return "Season [name=" + name + ", desc=" + desc + "]";
	}
}

//使用enum关键字来实现枚举
enum Season2{//类
	
//	自定义三个枚举类
//	public static final Season SPRING =new Season("春天","温暖的");
//	public static final Season SUMMER =new Season("夏天","炎热的");
//	public static final Season AUTUM  =new Season("秋天","萧瑟的");
//	public static final Season WINTER =new Season("冬天","寒冷的");
//	

	//如果使用enum来实现枚举
	//1.使用关键字enum来替代class
	//2.自定义枚举时：public static final Season SPRING =new Season("春天","温暖的");
	//  使用： SPRING("春天","温暖的")来替代就好了
	//3.当有多个常量对象时使用，隔开，不是；号
	//4.如果使用enum关键字来实现枚举，必须将定义常量放在最前面
	//5.如果使用的是无参构造函数，可以直接SPRING，什么都不带
	//6.enum类隐式继承自Enum类
	SPRING("春天","温暖的"),SUMMER("夏天","炎热的"),AUTUM("秋天","萧瑟的"),WINTER("冬天","寒冷的");
	private String name;
	private String desc;//描述
	private  Season2(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Season [name=" + name + ", desc=" + desc + "]";
	}
}


//enum因为隐式继承了Enum类，所以不能在继承其他类
//但enum类也是一个类，可以实现接口

interface Play{
	/*public abstract*/void play();
}
enum Music implements Play{
	CLASSICMUSIC;

	@Override
	public void play() {
		// TODO 自动生成的方法存根
		System.out.println("播放音乐");
	}
	
}
