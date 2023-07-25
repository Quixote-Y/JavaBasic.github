package LearnJava;
//String相关
public class TestString2 {

	String str =new String("ABC");
	final char[] ch= {'V','B','O'};
	
	
	
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

//	public void change(TestString2 test,char ch[]) { 
//		test.setStr("CBA");
//		
//		ch[0]='F';
//	}思路三
	
	public void change(String str,char ch[]) { 
	str="ABC";
	
	ch[0]='F';
}
	public static void main(String[] args) {
		TestString2 test=new TestString2();
		//test.change(test.str, test.ch);

		//test.change(test.str.intern(), test.ch);//尝试思路1，无效
		test.change(test.str, test.ch);
		System.out.print(test.str+" and ");
		System.out.println(test.ch);
	}
	//输出str没发生变化，而ch发生了变化ABC and FBO
	//解析：
	/*
	 * 1.首先需要理解的是程序执行的内存分布方式
	 *  --》在栈中调用主程序，主程序里的new会在堆里创建一个对象，然后test指向堆里的对象
	 *  --》即：堆里创建了一个TestString2对象，里面的String指向堆里的另一个String对象
	 *  --》   String对象数组里的value数组指向了常量池中的ABC，TestString2里的ch
	 *   --》  指向堆中的一个连续区域，里面顺序存放着VBO三个字符
	 * 2.当主程序调用新的方法时，会在栈里开辟一个新的栈帧
	 *  --》当调用change时，产生一个新的栈帧里面有str，ch两个参数
	 *  --》  str指向的是test指向的TestString2对象里的str指向的value
	 *  --》  ch指向的是test指向的TEstString2对象里的ch指向的连续地址空间
	 *  --》  str="CBA"-->意味着str会在常量池开辟一个新的常量CBA，然后让str指向他
	 *  --》    ：：：注意，此时，str传值的时候是指向value，此时传向指向了常量池
	 *  --》                并没有改变TestString2对象里的str指向
	 *  --》  ch[0]=‘F’，改变了该地址里的值，对应的TestString2对象里的ch指向的值也就变化了
	 *  
	 */
	
	//那么怎么能让他改变str的值呢？
	/*
	 *思路1：用.inter直接返回value指向的常量区的值，然后修改他，但仔细以像，不对，常量区
	 *       数据都是final 因该改不了-->其实不然，实践证明，就像上面说的加了inter后只不过是
	 *       传入的值最开始指向的常量池中，他不会去改写也无权改写ABC，只会新建一个CBA然后自己
	 *       指向它，value值还是没变
	 *思路二：能不能像c一样把他的地址传入进去,没有，暂时没有发先java能引用传递
	 *        貌似java中仅有值传递
	 *        网上思路：如果想改变的话,可以使用Holder包装类包装String,
	 *思路三：类中写个set方法，传入参数改为对象，然后去调用set方法---》成功方式
	 */
}
