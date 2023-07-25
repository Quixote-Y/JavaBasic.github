package stringBufferAndBuilderClass;

public class StringBuilderTest {

	//解析以下StringBUilder
	/*
	 * 1.StringBuilder继承AbstractStringBuilder类
	 * 2.实现了Serializable，StringBuilder对象可以串行化（对象可以网络传输，可以存到文件）
	 * 3.StringBuiler是final类，不可以被继承
	 * 4.StringBuilder对象字符序列仍然是存放在其父类的AbstractStringBuilder的value中
	 *    因此，字符序列在堆中
	 * 5.StringBuilder的方法都没有做互斥处理，没有synchronized关键字，
	 *    因此我们一般在单线程的情况下使用StringBuilder，他比StringBuffer更快速
	 *    
	 */
	
	//String StringBuffer StringBuilder对比
	/*
	 * String：{
	 *          不可变字符序列，效率低，复用率高；
	 *          每次进行增删操作都会产生大量的副本字符串对象留在内存中，影响性能
	 *          如果需要我们对String做大量的修改，那就不要用String}
	 * StringBuffer：{
	 *          可变字符序列，效率较高，线程安全；}
	 * StringBuilder：{
	 *          可变字符序列，效率最高，单线程使用；}
	 */
	
	//StringBuilder方法和StringBuffer一致
	public static void main(String[] args) {
		StringBuilder stringBuilder=new StringBuilder();
	}
}
