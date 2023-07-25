package LearnJava;
/**
 * 测试String
 * @author 86136
 *
 */
public class TestString {
	/*
	 * 1. String类实现了Serializable, Comparable两个接口
	 *     Serializable：可串行化，可以在网络上传输
	 *     Comparable：String对象可以比较大小
	 * 2. String是final类，不能被其他类继承
	 * 3. String有属性private final char value[];用于存放字符串内容
	 * 4. 一定注意value是final类型，不可以修改-->value所指向的地址不可修改，，value的地址不能变
	 * ——》数组是在堆中开辟新的地址空间，用于存放指向常量区的字符串的地址
	 *    并不是字符不可修改，，value不可以指向新的数据空间，但数组指向的地址可变
	 */

	public static void main(String[] args) {
		
		//创建String
		String s1=null;
		String s2 ="";
		String s3="java";
		String s4=new String("java");
		String s5=new String();
		/*
		 *            String s ="hsp"
		 *  他会先检查常量池有没有"hsp",有就直接指向该常量池里的数据
		 *  没有就创建然后指向，这里  s指向的是常量池的地址
		 *            String s =new String("hsp");
		 *   会先在堆中建立一个地址，里面就有String里的value数组，然后value
		 *   会去常量池里找“hsp”，没有就创建该字符串，拿到地址，然后
		 *   关键来了：  value指向了常量池的地址  ，然后返回了以一个堆中该
		 *              value所在的地址给String s
		 */
		
		
		
		//System.out.println(s1.length()); //此处会报错，空指针异常
		System.out.println(s2.length());
		System.out.println(s3.length());
		System.out.println(s4.length());
		System.out.println(s5.length());//new一个空字符串，可以Ctrl查看一下String原文档的构造函数，类型很多
	
	
		
		System.out.println("---------------------------");
		String g1="GOOD";
		String g2="GOOD";
		String g3=new String("GOOD");
		System.out.println(g1==g2);//true
		System.out.println(g1==g3);//false
		System.out.println(g1.equals(g3));//true
		
		//为什么会出现这样的状况呢
		/*
		 * java内存中栈，堆，方法区三部分，
		 * 方法区存有类的信息，方法，还有个静态区，常量池
		 * 常量池里存有数据
		 * g1和g2直接等于GOOD，像当于把两个指针直接指向常量区中的GOOD，
		 * 所以二者连地址都相等
		 * 而new String（"GOOD")，在new时会在堆中新建一个指针指向字符常量池
		 * 而返回来的是指向堆中的指针，所以二者当然就不同了
		 */
		
		//面试题
		Person p1 =new Person();
		p1.name="hspde";
		Person p2= new Person();
		p2.name="hspde";
		
		System.out.println(p1.name.equals(p2.name));//true
		System.out.println(p1.name==p2.name);//true
		System.out.println(p1.name=="hspde");//true
		
		//解析一下：首先p1和p2会在堆里建两个区，里面存放着自己的成员信息String
		//          因为p1.name="hspde",所以直接指向了常量池中的地址
		//          而p2.name也是如此，所以二者所存储的内容都为同一个地址
		//           因此相等
		//    至于第三个："hspde"本身代表的就是他在常量池中的地址
		
		
		//字符串特性：
		/*
		 * 以下语句创建了几个对象，内存分布图
		 * String s1="hello";
		 * s1="haha";
		 * 
		 * 解析：没有new直接赋的字符串，所以会直接指向常量区，常量区没有hello和haha，
		 *      便会创建新的字符串对象，两个
		 *      
		 *  面试题：
		 *  
		 *  String a ="hello"+"abc";创建了几个对象？
		 *  
		 *  解析：编译器不是傻子，他会自动优化为：
		 *  String a="helloabc";
		 *  如果常量区没有先前创建的helloabc，那就创建了一个对象
		 *  
		 *  String a="hello";
		 *  String b="abc";
		 *  String c=a+b;   创建了几个对象
		 *  
		 *  解析：String a和b两个，然后主要是c，可以在String c处打一个断点，
		 *       看程序运行方式
		 *  根据断点顺序：
		 *      1.先判断a是否为空，toString
		 *      2.回来，在进去创建一个StringBuilder sb =StringBuilder（）
		 *      3.执行sb.append("hello")
		 *      4.执行sb.append("abc")
		 *      5.String c =sb.toString
		 *      可以看看toString源码：
		 *      public String toString() {
                   // Create a copy, don't share the array
                   return isLatin1() ? StringLatin1.newString(value, 0, count)
                   : StringUTF16.newString(value, 0, count);
                     }
		 *在最后new了一个String对象指向常量池中的结果，
		 *所以c指向的是堆中的（String）    value[]-->池中的"helloabc"
		 */
		//下面可以试一下
		String a ="hello";//创建a
		String b="abc";//创建b
		String c=a+b;
		
			
		
		System.out.println("----------------------");
		//字符串常用操作
		String m1 = "core Java";
		String m2 = "Core Java";
		System.out.println(m1.charAt(3));//.charAt(num)提取第num位的字符
		System.out.println(m1.length());//.length()返回字符串的长度
		System.out.println(m1.equals(m2));//比较两个字符串是否相等
		System.out.println(m1.equalsIgnoreCase(m2));//比较两个字符串内容是否相同，忽略大小写
		System.out.println(m1.indexOf("Java"));//返回字符串中Java串所出现的第一个位置
		System.out.println(m1.indexOf("apple"));//若字符串未出现过则返回-1
		
		String s =m1.replace(' ', '&');//将m1中的空格替换为&
		/*
		 * 1.注意看replace里的参数是两个char类型，如果使用" ",则表示的是字符串，
		 * 这样会报错
		 * 2.注意 ' '中间得敲一个空格，不然也会报错
		 * 3.打开replace源码，可以看到实现原理并不是简单的替换，而是直接生成了一个新的字符串
		 */
		System.out.println("替换结果位："+s);
		
		
		System.out.println("\n-------------");
		String f ="";
		String f1="How old are you?";
		
		System.out.println(f1.startsWith("How"));//检查字符串f1是否以how开头
		System.out.println(f1.endsWith("you"));//检查字符串f1是否以有结尾
		f=f1.substring(4);//提取子字符串，从f1下标4位置开始
		System.out.println(f);
		f=f1.substring(4, 7);//提取子字符串，从f1下标4到下标7,不包括7
		System.out.println(f);
		f=f1.toUpperCase();//f1串转大写
		System.out.println(f);
		f=f1.toLowerCase();//f1串转小写
		System.out.println(f);
		String f2="  How old are you ? ";
		f=f2.trim();//去除字符串首尾的空格，不去除空间的空格
		System.out.println(f);
		System.out.println(f2);//注意是生成新的字符串，源字符串没有改变
		
		String f3="I ove Java,Java is best,Good Java!";
		String f4="JAVA";
		System.out.println(f3.lastIndexOf("Java"));//倒着找第一个出现Java字符串的位置，位置是正常的索引
		System.out.println(f3.toLowerCase().indexOf(f4.toLowerCase()));//先将字符串都变为小写，是字符串一致，不管大小写
		                                                               //然后找到f3串中第一次出现f4的位置
		//concat:字符串连接，replace：字符串替换，
		//split("参数")：依据参数对字符串进行分割，返回一个数组，如果有特殊字符，需要加
		//如转义字符\
		//toCharArray:转为字符数组
		//a.compareTo(b):返回2个字符串第一个不相等的第i位相减的结果，
		           //若两个字符串长度不同，然后内容都一样，就返回len（a）-len（b）
	    //.format(),可以像c一样用占位符来替代变量
		String name="yyf";
		int age=21;
		double score=90.2130;
		char gender='M';
		String formatStr="我的名字%s,年龄%d，成绩%.2f,性别是%c";
		String info=String.format(formatStr, name,age,score,gender);
		System.out.println(info);
		//这个用法很好---》占位符格式输出
	}
}
class Person{
	String name;
}
