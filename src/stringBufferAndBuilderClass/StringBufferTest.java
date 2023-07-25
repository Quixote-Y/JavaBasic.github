package stringBufferAndBuilderClass;
//
public class StringBufferTest {

	/*StringBuffer解析：
	 * 
	 * 1.StringBUffer的直接父类是AbstractStringBuilder
	 * 2.StringBuffer实现了Serializable，可以串行化
	 * 3.在父类中，AbstractStringBuilder有个属性 char[] value ，不是final类型
	 *   就像String类里的一样，他存放的是字符串的内容，但不同点在于，它存在堆里 
	 * 4.Stringbuffer是个final类，不可以被继承
	 * 5.StringBuffer字符类容存在char[] value中，所有变化（增删）不用每次变化
	 *    都更改地址（创建新对象），所以他的效率高于String
	 */
	
	
	public static void main(String[] args) {
		//构造器使用
		//1.无参构造函数，可以断点进去看，默认char[] 大小是16
 		StringBuffer stringbuffer1=new StringBuffer();
 		//2.一个整数做参数，char[] 大小为传入参数值
 		StringBuffer stringbuffer2=new StringBuffer(100);
 		//3.传入字符串做参数，char[] 大小为字符串length+16
 		StringBuffer stringbuffer3=new StringBuffer("stri ng");
 		
 		
 		//String<--->StringBuffer
 		//1.构造器
 		String str1="ABC";
 		StringBuffer stringBuffer1=new StringBuffer(str1);
 		
 		String str2=new String(stringBuffer1);
 		
 		//2.使用append方法把String转为StringBuffer
 		StringBuffer stringBuffer2=new StringBuffer();
 		stringBuffer2=stringBuffer2.append(str1);//就把这个加进去
 		
 		//3.使用StringBuffer提供的toString转为String
 		StringBuffer stringBuffer3=new StringBuffer("CBD");
 		String str3=stringBuffer3.toString();
	}
}
