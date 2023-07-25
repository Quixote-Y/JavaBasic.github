package wapper;


//包装类怎么转String
public class WrapperToString {

	public static void main(String[] args) {
		//包装类（Integer）--》String
		Integer i=100;//自动装箱
		//方式1
		String str=i+"";
		//注意转完之后对i没有影响
		//方式2
		String str2=i.toString();
		//方式3
		String str3=String.valueOf(i);
		
		//String-->Integer
		String str4="1234";
		Integer i2 =Integer.parseInt(str4);//使用到自动装箱，先将str转为int，
		                                 //自动装箱为integer包装类
		//用构造器
		Integer i3 =new Integer(str4);
		
		//面试题
		Integer s1=new Integer(1);
		Integer s2=new Integer(1);
		System.out.println(s1==s2);//两个不同对象肯定不等
		
		Integer s3=1;
		//底层Integer.valueOf（1）-->看源码
		/*
		 *  public static Integer valueOf(int i) {
              if (i >= IntegerCache.low && i <= IntegerCache.high)
                   return IntegerCache.cache[i + (-IntegerCache.low)];
               return new Integer(i);
            }
         //i的范围在-128到127内就是直接从cache返回，否则就new一个Integer
		 */
		Integer s4=1;
		System.out.println(s3==s4);//true
		
		Integer s5=128;
		Integer s6=128;
		System.out.println(s5==s6);//false
		
		//只要有基本数据类型那就变为值比较
		Integer s7=128;
		int s8 =128;
		System.out.println(s7==s8);
	}
}
