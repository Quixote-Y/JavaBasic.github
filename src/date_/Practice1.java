package date_;

//字符串反转，指定部分字符串反转，编写方法
public class Practice1 {

	public static void main(String[] args) {
		String str = "abcdef";
		String res = reverse(str, 2, 5);
		System.out.println(res);
		System.out.println("源字符串" + str);
		String res2 = "";
		
		//必须得习惯用异常来处理程序的错误情况
		try {
			res2 = reversrChars(str, 2, 321);
		} catch (Exception e) {
			// TODO: handle exception
			// 捕获到输出的异常输出结束
			System.out.println(e.getClass() + e.getMessage() + "程序结束");
			return;
		}
		System.out.println("交换结果" + res2);
	}

	// 首先啊，看到String做参数，立马就想到了值传递--》有返回值，不用考虑这个
	// char[]的元素是可以交换的
	// 考虑用StringBuilder--》对字符串里的单个字符进行操作，为什么就想不到转数组呢
	public static String reverse(String str, int start, int end) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder tmp = new StringBuilder();
		// 现在要考虑的应该是怎么拿到指定位置的字符和怎么改变他的值
		// 初步想法：反着把字符串取出来然后在替换回去
		String tmpc = "";
		for (int i = end - 1; i >= start - 1; i--) {
			tmpc = sb.substring(i, i + 1);
			tmp.append(tmpc);
		}
		str = tmp.substring(0);
		sb.replace(start - 1, end, str);// replace替换不包括后者，前闭后开
		str = sb.substring(0);
		return str;

	}

	public static String reversrChars(String str, int start, int end) {

		// 异常判断
		
		//正确参数取反，抛出异常
		if (!(str != null && str.length() >end-1 && start-1 >= 0 && end > start)) {
			//！！！
			throw new RuntimeException("输入参数异常");
		}
		char[] chars = str.toCharArray();
		char tmp = ' ';
		for (int i = start - 1, j = end - 1; i < j; i++, j--) {
			tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}

		return new String(chars);// 直接用chars创建一个String（）就好了
	}

}
