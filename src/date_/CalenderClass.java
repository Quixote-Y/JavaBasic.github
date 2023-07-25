package date_;
//java.util.Calender类使用方法
import java.util.Calendar;
public class CalenderClass {

	public static void main(String[] args) {
		/*
		 * 1.Calender是一个抽象类，并且构造器是private，不可以实例化
		 *    Calendar c=new Calendar();//错误
		 * 2.可以通过getInstance()方法来获取实例，，获取Calander所有的成员信息
		 * 3.提供大量的方法和字段get。。。
		 * 4.没有格式输出，依靠程序员自行组织输出格式
		 * 5.如果需要按24小时格式获取时间，则获取Calendar.HOUR_OF_DAY
		 */
		
		Calendar c=Calendar.getInstance();//创建日历对象，getInstance是一个静态方法
		                                  //通过类名调用
		System.out.println(c);//看看c里有什么
		
		//.获取日历对象的某个字段
		System.out.println("年 ："+c.get(Calendar.YEAR));//年
		//返回月份从0开始，要+1
		System.out.println("月 ："+(c.get(Calendar.MONTH)+1));//
		System.out.println("日 ："+c.get(Calendar.DAY_OF_MONTH));//
		System.out.println("时 ："+c.get(Calendar.HOUR));//
		System.out.println("分 ："+c.get(Calendar.MINUTE));
		System.out.println("秒 ："+c.get(Calendar.SECOND));
		//System.out.println("秒 ："+Calendar.SECOND);
		//说实话，感觉格式好怪
		// public static final int DAY_OF_MONTH;这是DAY_OFMONTH的声明
		//这是一个静态变量，按理说应该直接调用类名就可以访问
		//但这里又采用了一个日历对象在外层去get
		//有些想法：   首先我们打开SECOND的声明可以看到：
		//       public static final int SECOND = 13;
		//直接输出Calendar.SECOND就是13，然而c.get()却不是
		//那问题就在c的创建这个过程中，打开Claendar.getInstance()：看到注释：
		//获取使用默认时区和区域设置的日历。返回的值基于当前时间
		//那么我们可以认为他的返回值会生成一个新的SECOND，final属性也不可能被重写
		//那就不对
		//那最后一种可能就出现在get方法上：但暂时没看懂，推测应该是获取了电脑时间，
		//然后通过c.get拿到对应位置的数据
		
		
		//没有格式输出，自己敲,妈了个巴子
		System.out.println(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH));
		
	}
}
