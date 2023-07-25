package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

//反向引用
public class BackReference {

	// 反向引用：当正则表达式中存在分组时，前面的分组完成时就会被捕获到group里，这样的话后面的分组可以引用前面已经捕获了的分组结果
	public static void main(String[] args) {

	}

	public void testBackReference() {
		// 检索商品编号，前五个是数字，然后一个-号，然后一个九位数字，每连续3个数字相同
		String content = "21322-111222333";
		String regxp = "^\\d{5}\\-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
		// (\\d)\\3{2} 匹配 一个数字+两个和第三个分组内容一致 的字符串
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		Boolean tmp = matcher.matches();
		if (tmp) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}
	}
	
	@Test
	public void stutterer() {
		//去除结巴
		String content = "我....我要....学学学学.......编程java!";
		
		//先去掉所有的.
		Pattern pattern = Pattern.compile("\\.");
		Matcher matcher = pattern.matcher(content);
		content = matcher.replaceAll("");
		System.out.println(content);
		
//		
//		//去掉重复的字
//		//1.(.)\\1+  先捕获到有相同的字  ，因为+是至少一个和捕获到的第一个元素相同的
//		//2.使用反向引用 $1 来替换匹配到的内容  ，正则表达式外围引用
//		pattern = Pattern.compile("(.)\\1+");
//		matcher = pattern.matcher(content);
//		while(matcher.find()) {
//			System.out.println("找到："+matcher.group(0));
//		}
//		//这里是去匹配看有没有重复的出现，把重复的单独做一个子串拿出来，所以下面的1是每个子串的第一个分组
//		
//		//使用反引号$1 来替换 匹配到的 有重复的子串
//		content = matcher.replaceAll("$1");       //$1代表的是前面你捕获到的第一个分组（）
//		System.out.println("content:"+content);
		
		
		//上面的过程简写
		//按照(.)\\1+ 去找content中有重复字符的子串，取出来 ，然后用前面的（.）这个分组取出来的值去替换他
		content = pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
		System.out.println("content:"+content);
	}
}
