package date_;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.util.data用法解析
public class DateClass {

	public static void main(String[] args) throws ParseException {
		/*1.获取当前系统时间
		 *2.默认输出的时间是国外的日期格式，因此需要对格式进行转换
		 *3.这是java.util.Date包
		 */
		Date d1 =new Date();//获取当前时间
		System.out.println("当前时间= "+d1);
		
		//通过指定毫秒数获得时间
		Date d2=new Date(23132132131L);
		System.out.println("d2时间="+d2);
		
		//指定日期格式
		/*1.创建SimpledataFormat对象，可以指定相应的格式
		 *2.格式中的字母是有规定的，可以查api
		 * 
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
		String formatdata=sdf.format(d1);//format(),将日期转换为对应sdf格式
		System.out.println(formatdata);
		
		//把指定格式的字符串转String换为data
		String s="1222年22月32日 04:22:21 星期二";
		Date parse=sdf.parse(s);//注意这个地方会出现一个异常
		                       //ParseException，转换异常，是个编译异常，必须处理
		                       //我们可以把他抛出
		//System.out.println(parse);不对，这样的话输出的日期又是外国格式，应该加上转换
		System.out.println(sdf.format(parse));//日期超出的话会循环补回来
		
	}
}
