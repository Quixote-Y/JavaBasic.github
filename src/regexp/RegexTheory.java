package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式 源码相关
public class RegexTheory {

	//正则表达式主要用来处理  字符 文本 ，提取里面的有效信息
	public static void main(String[] args) {
		
		String content = "2021想私信要学习资料，聊学习方法、职业规划的，加老韩微信 hspcat   ，附加消息 B站\r\n"
				+ "\r\n"
				+ "本套Java课程为三个阶段，涵盖了Java基础的方方面面。\r\n"
				+ "第一阶段:建立编程思想(包括:基本语法、数组、排序和查找、面向对象编程、零钱通、房屋出租系统、迷宫、八皇后、汉诺塔 )\r\n"
				+ "第二阶段:提升编程能力(包括: 枚举和注解、Exception、常用类、集合、泛型、线程、IO流、坦克大战) \r\n"
				+ "第三阶段: 增强分析需求，代码实现能力(包括: 网络编程、反射、Mysql、JDBC和连接池、正则表达式、Java8 Java11 新特性、马踏棋盘、满汉楼、多用户通信系统)\r\n"
				+ "\r\n"
				+ "面试题讲解：包括腾讯，美团，滴滴，百度，头条等公司的面试题。\r\n"
				+ "\r\n"
				+ "制作精品课程非常辛苦，1212感谢小伙伴的点赞转发，你的支持是韩老师最大的动力，感谢\r\n"
				+ "\r\n"
				+ "【韩顺平忠告】19年程序老司机忠告 13个自学编程的坑 你踩了几个\r\n"
				+ "\r\n"
				+ "【2021韩顺平 一周学会Linux】【小白入门 通俗易懂】2021韩顺平 一周学会Linux\r\n"
				+ "\r\n"
				+ "【韩顺平Java集合专题 】【韩顺平讲Java】Java集合专题 -ArrayList HashMap HashSet List Map TreeMap TreeSet等\r\n"
				+ "\r\n"
				+ "【超全超详细的Java企业级学习路线】找不到java后端开发工作? 按这个学,找工作没问题  (超全超详细的Java企业级学习路线)\r\n"
				+ "\r\n"
				+ "【月薪60k的Java程序员】月薪6032k的Java程序员 看看面试官要问哪些问题\r\n"
				+ "\r\n"
				+ "【零基础一周学会MySQL】【韩顺平讲MySQL】零基础一周学会MySQL   -sql mysql教程 mysql视频 mysql入门\r\n"
				+ "\r\n"
				+ "【Java反射专题】【韩顺平讲Java】Java反射专题 -反射 反射机制 类加载 reflection Class 类结构  等\r\n"
				+ "\r\n"
				+ "【一天学会线程 Thread】【韩顺平讲Java】一天学会线程 Thread Synchronized 互斥锁 进程 并行 并发 死锁等\r\n"
				+ "\r\n"
				+ "【Java网络多线程专题】【韩顺平讲Java】Java网络多线程专题 - TCP UDP Socket编程 多线程 并发处理 文件传输 新闻推送 Java\r\n"
				+ "\r\n"
				+ "【Java坦克项目】【韩顺平讲Java】Java坦克项目 面向对象 多线程 集合 IO流 算法\r\n"
				+ "\r\n"
				+ "【Java IO流专题】 【韩顺平讲Java】Java IO流专题 -io流 io机制 字符流 字节流 节点流 处理流 等";
		
		//目标：匹配所有的四个数字
		//regex：正则表达式
		//转义字符，四个数字
		String regStr = "(\\d\\d)(\\d\\d)" ;
		//2.创建模式对象，即正则表达式对象
		Pattern pattern = Pattern.compile(regStr);
		//3.创建匹配器
		//创建匹配器matcher ，按照 正则表达式 regStr 的规则去 匹配content字符串的内容
		Matcher matcher = pattern.matcher(content);
		
		//4.开始匹配
		/*
		 *  matcher.find() 完成的任务（考虑分组）
		 *  分组： 就是在指定规则时加（）（）一个小括号是一组，(\\d\\d)(\\d\\d)
		 *  1.根据指定的规则，定位满足规定的字符串子串（假设第一个2021）
		 *  2.找到后， 将子字符串的开始索引记录到matcher的成员属性 int[] groups;中
		 *    2.1，group[0]=0,把该字符串的结束索引+1的值记录到group[1]=4，为什么要+1，因为后期group取子字符串的时候用的方法是getSequence，前开后闭
		 *    2.2，如果添加了分组，那么 group[0]和[1]的存的还是一样，但就会有新的group[2]和[3]来存放第一个分组的开始和结束+1索引，多的分组也是这样
		 *  3.之后会记录一个matcher属性olderLast，他的值为子字符串结束索引+1，下次在执行find方法时，就从olderLast开始
		 */
		/* 
		 *  matcher.group() 
		 *  源码：
		 *   public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
    }
    
    
             主要是    return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
		 *    意思是去找groups[]数组，按照里面的值，去取content字符串的字串，每两个是一组
		 *   group(?)里面传的参数就是去找第几组，第0组是完整数据
		 */
		while(matcher.find()) {
			System.out.println("找到: "+matcher.group(0));
			System.out.println("找到第一组: "+matcher.group(1));
			System.out.println("找到第二组: "+matcher.group(2));
		}
	}
}
