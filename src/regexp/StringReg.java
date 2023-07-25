package regexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

//正则表达式搭配一些String的方法以更高效
public class StringReg {

	public static void main(String[] args ) {
		//1.替换
		//   将jdk1.5 和 jdk5.0 替换为jdk
		String str = "是整个Java的核心，包括了Java运行环境（Java Runtime Envirnment），"
				+ "一堆Java工具和Java基础的类库(rt.jar), SUN公司不断对它进行升级"
				+ "，发布了不同的版本，jdk1.5 是Sun公司后来发行的版本也就是j"
				+ "dk5.0(JDK1.5 更名后)";
		//常规String的replace方法需要至少两条替换语句,使用正则表达式搭配，更简洁
		str = str.replaceAll("jdk1.5|jdk5.0", "jdk");
		System.out.println(str);
		
		//2.匹配
		String str2 = "13858802041";
		//去检验是否是以132或138开头的电话号码
		//直接用String的metches方法
		boolean tmp =str2.matches("^1(32|38)\\d{8}$");
		if(tmp) {
			System.out.println("匹配成功");
		}else {
			System.out.println("匹配失败");
		}
		
		//3.分割
		//按照 *或-或数字或#去分割字符
		String str3 = "hello*adb21smith#的撒大-北京";
		String[] strList = str3.split("-|\\*|#|\\d+");//里面是分割条件,这里*要转义，不然报异常
		//Dangling meta character '*' near index 2
		System.out.println(Arrays.toString(strList));
	}
}
