package date_;
//输入Han shun Ping人名 输出Ping,Han.S
public class Practice3 {
	//这是我的思路：
//	public static void main(String[] args) {
//		
//		String input="Han Shun Ping";
//		String res="";
//		try {
//			
//		    res=nameDeal(input);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
//	}
//	
//	//字符串处理方法
//	//既然需要对字符串进行操作我选择StringBUilder
//	//但好像没必要，string也有返回字串的能力，但用String的话后面把字串连接起来可能比较麻烦
//	//判断字符串为不为空
//
//	public static String nameDeal(String name) {
//		if(name==null) {
//			throw new RuntimeException("输入人名为空");
//		}
//		int index1=name.indexOf(' ');
//		int index2=name.lastIndexOf(' ');//一个区别，String的indexof可以对字符char起作用
//		                   //StringBUilder的indexof只能对字符串“ ”起作用
//		String str1=name.substring(0, index1);//取字串操作是前闭后开，后面要+1
//		String str2=name.substring(index2+1, name.length());
//		char str3=name.charAt(index1+1);
//		StringBuilder sbName=new StringBuilder();
//		sbName.append(str2).append(',').append(str1).append('.').append(str3);
//		return sbName.toString();
//	}
	//教的方法
	public static void main(String[] args) {
		String name="Han shun Ping";
		namePrint(name);
	}
	
	public static void namePrint(String name) {
		if(name==null) {
			System.out.println("输入姓名为空");
			return;
		}
		//用spilt方法来分割字符串
		//这个地方弄错过一次，spilt参数选择错误
		String[] str=name.split(" ");//把name分割，当遇到空格时切断，存到str字符串数组里
		if(str.length!=3) {
			System.out.println("姓名格式不正确");
			return ;
		}//没有切分为3份
		//用String.format来格式化输出
		String format=String.format("%s,%s.%c",str[2],str[0],str[1].toUpperCase().charAt(0));
		System.out.println(format);
	}

}
