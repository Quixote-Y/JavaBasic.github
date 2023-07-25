package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//Collections工具类
public class CollectionsTools {

	
	//COllections,,,,ssssss,s别忘了
	@SuppressWarnings("all")
	public static void main(String[] args) {
	//包含一些Collection的常用函数
	//用ArrayList来实验
	ArrayList list=new ArrayList();
	list.add("Simth");
	list.add("bob");
	list.add("breath");
	list.add("adcbe");
	list.add("a");
	//注意这些都是静态方法，通过Collections接口名调用
	
	//reverse(List):反转list中的顺序
	System.out.println(list);
	Collections.reverse(list);
	System.out.println("--------反转后-------");
	System.out.println(list);
	
	//shuffle(List) 对List集合元素进行随机排序
	Collections.shuffle(list);
	System.out.println("--------打乱后-------");
	System.out.println(list);
	
	//sort(List) :根据元素的自然顺序对指定List集合按升序排序，像字符串数字就是按大小
	Collections.sort(list);
	System.out.println("--------自然排序后-------");
	System.out.println(list);
	//不对，不对，啊对，应该和采用的字符编码格式有关，大写字母比小写字母小
	
	//sort(List ,Comparator):根据指定的Compatator产生的顺序对list进行处理
	//按字符串长度排序
	Collections.sort(list, new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO 自动生成的方法存根
			//类型判断防止报错，
			if(!((o1 instanceof String)&&(o2 instanceof String)))
				return 0;
			return ((String)o1).length()-((String)o2).length();
		}
	});
	System.out.println("--------加入比较器排序后-------");
	System.out.println(list);
	
	//swap（List，int ，int），交换两个元素的位置，注意别越界了
	Collections.swap(list, 0, 4);//首尾互换
	System.out.println("--------首位互换后-------");
	System.out.println(list);
	
	//max（lsit） 返回自然顺序下的最大值
	Object maxReturn=Collections.max(list);
	System.out.println("--------返回自然顺序下的最大值-------");
	System.out.println(maxReturn);
	
	//max(list ,Comparator):根据Comparator指定的顺序返回给定集合中最大的元素
	Object maxReturn2=Collections.max(list, new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO 自动生成的方法存根
			if(!((o1 instanceof String)&&(o2 instanceof String)))
				return 0;
			return ((String)o1).length()-((String)o2).length();//返回长度最长的，调换位置可以返回最短的
		}
	});
	System.out.println("--------加入比较器后返回最长的元素-------");
	System.out.println(maxReturn2);
	
	//min带比较器和不带比较器和max一样
	//frequency(list,object);返回指定集合中指定元素出现的次数
	int num=Collections.frequency(list, "bob");
	System.out.println("--------bob出现的次数-------");
	System.out.println(num);
	//copy(list dest,list src);将src中的内容全复制到dest中
	//注意：可以看copy的源码，dest必须要尺寸和src一样或大于，不然返回数组越界异常，因此我们必须先给dest赋值初始化尺寸，默认是空
	ArrayList dest=new ArrayList();
	for(int i=0;i<list.size();i++) {
		dest.add("");
	}
	Collections.copy(dest, list);
	System.out.println("-------复制的dest--------");
	System.out.println(dest);
	
	//replaceAll（list , Object oldValue，Object newValue）；将list中所有旧的值换为新的值
	
	Collections.replaceAll(dest, "bob", "鲍勃");
	System.out.println("-------bob换鲍勃后的dest--------");
	System.out.println(dest);
	
	
	
	
	}
	
	
}
