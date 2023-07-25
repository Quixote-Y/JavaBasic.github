package stringBufferAndBuilderClass;
//StringBuffer常用方法
public class StringBufferMethod {

	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Hello");
		//增 append
		s.append(',');
		s.append("It's me");
		s.append("李四").append("王五").append(100).append(10.2);//Hello,It's me李四。。。
		System.out.println(s);
		
		//删 delete（）
		//删除两个索引间的字符，前闭后开
		s.delete(13, 15);//删除李四
		System.out.println(s);
		
		//改 replace
		//替换两个索引间的字符串为目标字符串
		s.replace(1,5 , "Go to hill");
		System.out.println(s);//HGo to hill,It's me李五10010.2索引从0开始
		
		//查 indexof 
		int indexOf=s.indexOf("王五");
		System.out.println(indexOf);//19
		indexOf=s.indexOf("299");
		System.out.println(indexOf);//-1没找到
		
		//长度
		System.out.println(s.length());
		//插入insert
		
		s.insert(9, "插入");//在索引9的位置插入“插入”字符串，原来9的内容后移
		System.out.println(s);
		
	}
}
