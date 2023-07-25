package date_;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//JDK8提出的第三代data
public class ThridDate {
/*
 * Date被Calendar取代
 * Jdk8以后，因为Calender和Date的缺点，更新了新的第三代日期类
 * ：  缺点：可变性，日期和时间这样的类应该是不可变的
 *           偏移性：Date的年份从1900年开始，两个方法月份都是从0开始需要+1
 *           格式化：只有Date可以，Calender不可以
 *           线程不安全，多线程编程出错
 */
	public static void main(String[] args) {
		//第三代日期
		/*
		 * LocalDateTime：获取日期+时间  LocalDate：获取日期  LocalTime：获取时间
		 */
		//使用now（）返回表示日期时间的 对象
		LocalDateTime ldt=LocalDateTime.now();//
		System.out.println(ldt);
		System.out.println("年： "+ldt.getYear());
		System.out.println("月1： "+ldt.getMonth());
		System.out.println("月Value： "+ldt.getMonthValue());
		System.out.println("日： "+ldt.getDayOfMonth());
		System.out.println("时： "+ldt.getHour());
		System.out.println("分： "+ldt.getMinute());
		System.out.println("秒： "+ldt.getSecond());
		
		//使用DateTimeFormatter 对象来格式化输出
		//----------->DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
		//和SimpleDateFormat 对象类似
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format=dtf.format(ldt);
		System.out.println("格式化的日期为： "+format);
		
		
		//时间戳Instant
		//1.通过now（）获取表示当前时间的时间戳对象
		Instant now =Instant.now();
		System.out.println("当前的时间戳时："+now);
		//2.通过Date的form方法可以把Instant时间戳对象转换为Date
		Date date=Date.from(now);
		System.out.println("时间戳转换为时间是："+date);
		//输出不太好看，再把它格式输出一下
		
		
		//String InsFormat=dtf.format(Date);
		//System.out.println(InsFormat);
		/*发现一个问题：转化是在Date和Instant时间戳对象间互转，然后写的是LocalDateTime
		 * 的格式化输出，所以调用不动
		 * 重新写一个
		 */
		//这是Date类的格式化输出
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String insFormat=sdf.format(date);
		System.out.println("时间戳转Date格式化输出结果是："+insFormat);//可以的
		
		//3.继续，通过Date对象的toInstant（）方法可以把Date对象又转换为Instant时间戳对象
		Instant inatant=date.toInstant();
		System.out.println("这是Date转换过来的时间戳： "+inatant);
		
	    //方法很多，plus minus：加减时间运算，计算是否闰年等
		//有需求就去翻LocalDateTime的成员函数API
		
	}
}
