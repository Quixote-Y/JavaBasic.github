package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
//Pattern Matcher 这两个类都没有构造器

public class Method {

	public static void main(String[] args) {

	}

	public static void testChar() {
		// 验证输入的是不是汉字
		String content = "你好空间大打赏";

		// 汉字的匹配规则
		String regxp = "^[\u0391-\uffe5]+$";// 表示字符串以这个范围开始，以多个这个结束
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			System.out.println("满足格式要求");
		} else {
			System.out.println("不满足格式要求");
		}
	}

	// @Test
	public void testPost() {
		// 验证邮政编码：1-9开头的一个6位数
		String content = "123145";
		// 匹配规则
		String regxp = "^[1-9]\\d{5}$";// 以1-9数字开始，接5个数字，是结尾
		// 创建正则表达式对象
		Pattern pattern = Pattern.compile(regxp);
		// 获得匹配器
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}
	}

	// @Test
	public void testQQ() {
		// 验证qq号码
		String content = "213131213";
		String regxp = "^[1-9]\\d+{4,9}$";
		// 匹配一个以[1-9]开头的，后面跟{4，9}四到九位数字做结尾的字符串
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}

	}

	// @Test
	public void testTelphone() {
		// 验证手机号，以13，14，15，18开头
		String content = "12658802041";
		String regxp = "^1(?:3|4|5|8)\\d{9}$";// 匹配13，14，15，18开头的9个数字结尾的字符串
		// (?:pattern)匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。这对于用"or"字符 (|)
		// 组合模式部件的情况很有用
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}
	}

	//@Test
	public void testUrl() {
		// 验证网站url是否正确
		// https://www.bilibili.com/video/BV1fh411y7R8/?p=894&spm_id_from=pageDriver&vd_source=997090f8ba6f60d62fccca5b08a10cb8
		String content = "https://neiyi.tmall.com/?spm=875.7931836.0.0.66144265yiYTEc";
        
		/**
		 * 思路：
		 * 1.先确定 url的开始部分 https:// | http:// 可以有也可以没有 ，所以加？
		 * 2.然后通过 ： ([\\w-]+\\.)+[\\w]+  : 表示一个字符串，包含有\\w：任意数字，大小写字母 ;中括号里的[-]：表示字符串可能还有-
		 *            语义：1个或以上的 由任意数字大小写字母和- 然后后面跟的是.的字符串任意多个 ， 然后后面跟一个 由任意数字大小写字母和-组成的字符串
		 *            www.bilibili.com
		 * 3.确定后面的一大段，这段可能有可能没有，所以()?$ 表示以 0个或1个这一堆东西结尾
		 *           ((\\/[\\w-.?/&]+)*)?$  
		 *           \\/以 / 开始 ，[\\w-.?&] ： 可以是这一堆中的元素 ，+ 1---任意多个 ，* 0---任意多个
		 */
		String regxp = "^http(?:://|s://)?([\\w-]+\\.)+[\\w-]+((\\/[\\w-.?/&#%=]+)*)?$";//[]中括号里面写字符，表示的就是她本身，不需要转义字符
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}
	}
	@Test
	public void testMatches() {
		//使用Pattern类的方法Matches来匹配完整的字符串
		//当我们仅仅向上面的操作一样去验证整个字符串符不符合某种规则时，用Matches跟方便简洁
		String content = "https://neiyi.tmall.com/?spm=875.7931836.0.0.66144265yiYTEc";
		String regxp = "http(?:://|s://)?([\\w-]+\\.)+[\\w-]+((\\/[\\w-.?/&#%=]+)*)?";//因为是完整字符匹配，所以都可以不用限定符限定字符开头结尾
		Boolean tmp = Pattern.matches(regxp, content);
		if (tmp) {
			System.out.println("匹配成功");
		} else {
			System.out.println("匹配失败");
		}
		//这样就不用创建比较器了，也不需要比较器捕获值
	}
	@Test
	public void testReplace() {
		//替换
		String content = "你好打2打的大苏打撒热唧唧复唧唧";
		String regxp = "唧唧复唧唧";
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		//替换匹配后捕获到的字符串，生成新的字符串
		String newContent = matcher.replaceAll("木兰当户织");
		System.out.println(content);
		System.out.println(newContent);
	}

}
