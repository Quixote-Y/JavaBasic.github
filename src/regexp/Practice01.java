package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class Practice01 {

	// @Test
	public void testEmail() {
		String email = "huangzhou@qq.suzhou@com";

		String regxp = "^[\\w-]+@(([a-z]|[A-Z])+\\.)+([a-z]|[A-Z])+$";
		boolean good = email.matches(regxp);
		if (good) {
			System.out.println("是邮箱");
		} else {
			System.out.println("不是邮箱");
		}
	}

	// @Test
	public void testDigit() {

		// 区分整数小数 考虑正负数
		String digit = "0345";

		String regxp = "^[-|\\d|+]\\d+$";
		if (digit.matches(regxp)) {
			System.out.println("是整数");
			return;
		}
		String regxp2 = "^[-|\\d|+]\\d*\\.\\d+";
		if (digit.matches(regxp2)) {
			System.out.println("是小数");
			return;
		}
		System.out.println("不是整数或者小数");
	}

	@Test
	public void testUrl() {
		// 分解url提取信息
		// https://www.sohu.com:8080/abc/index.htm
		// https://fanyi.baidu.com/?aldtype=85#zh/en/%E5%9F%9F%E5%90%8D
		// 得到端口 域名 协议 文件
		String url = "https://www.sohu.com:8080/abc/index.htm";
//
//		String regxpProtocol = "^[a-z]+:";
//		Pattern pattern = Pattern.compile(regxpProtocol);
//		Matcher matcher = pattern.matcher(url);
//		String protocol = "";
//		while (matcher.find()) {
//			protocol = matcher.group(0);
//		}
//		protocol = protocol.substring(0, protocol.length() - 1);
//		System.out.println("协议：" + protocol);
//
//		String regxpDomain = "\\/\\/([\\w-]+\\.)+[\\w-]+";
//		pattern = Pattern.compile(regxpDomain);
//		matcher = pattern.matcher(url);
//		String domain = "";
//		while (matcher.find()) {
//			domain = matcher.group(0);
//		}
//		if ("".equals(domain)) {
//			System.out.println("输入信息有误，没有域名");
//		} else {
//			domain = domain.substring(2, domain.length() - 1);
//		}
//		System.out.println("域名：" + domain);
//
//		String regxpPort = ":\\d+\\/";
//		pattern = Pattern.compile(regxpPort);
//		matcher = pattern.matcher(url);
//		String port = "";
//		while (matcher.find()) {
//			port = matcher.group(0);
//		}
//		if ("".equals(port)) {
//			System.out.println("输入信息有误，没有端口");
//		} else {
//			port = port.substring(1, port.length() - 1);
//		}
//		System.out.println("端口：" + port);
//
//		String regxpFile = "\\/([\\w]+\\/)?[\\w]+\\.[\\w]+";
//		pattern = Pattern.compile(regxpFile);
//		matcher = pattern.matcher(url);
//		String file = "";
//		while (matcher.find()) {
//			file = matcher.group(0);
//		}
//		if ("".equals(file)) {
//			System.out.println("输入信息有误，没有文件");
//		} else {
//			file = file.substring(1, file.length());
//		}
//		System.out.println("文件：" + file);
		
		//这一堆代码显得就很傻逼
		String regxp = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
		Pattern pattern = Pattern.compile(regxp);
     	Matcher matcher = pattern.matcher(url);
     	//整体匹配，如果匹配成功，则可以通过分组调用group拿到值
     	if(matcher.matches()) {
     		System.out.println("整体匹配="+matcher.group(0));
     		System.out.println("协议："+matcher.group(1));
     		System.out.println("域名："+matcher.group(2));
     		System.out.println("端口："+matcher.group(3));
     		System.out.println("文件："+matcher.group(4));
     	}
	}
}
