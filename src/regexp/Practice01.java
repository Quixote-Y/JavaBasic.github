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
			System.out.println("������");
		} else {
			System.out.println("��������");
		}
	}

	// @Test
	public void testDigit() {

		// ��������С�� ����������
		String digit = "0345";

		String regxp = "^[-|\\d|+]\\d+$";
		if (digit.matches(regxp)) {
			System.out.println("������");
			return;
		}
		String regxp2 = "^[-|\\d|+]\\d*\\.\\d+";
		if (digit.matches(regxp2)) {
			System.out.println("��С��");
			return;
		}
		System.out.println("������������С��");
	}

	@Test
	public void testUrl() {
		// �ֽ�url��ȡ��Ϣ
		// https://www.sohu.com:8080/abc/index.htm
		// https://fanyi.baidu.com/?aldtype=85#zh/en/%E5%9F%9F%E5%90%8D
		// �õ��˿� ���� Э�� �ļ�
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
//		System.out.println("Э�飺" + protocol);
//
//		String regxpDomain = "\\/\\/([\\w-]+\\.)+[\\w-]+";
//		pattern = Pattern.compile(regxpDomain);
//		matcher = pattern.matcher(url);
//		String domain = "";
//		while (matcher.find()) {
//			domain = matcher.group(0);
//		}
//		if ("".equals(domain)) {
//			System.out.println("������Ϣ����û������");
//		} else {
//			domain = domain.substring(2, domain.length() - 1);
//		}
//		System.out.println("������" + domain);
//
//		String regxpPort = ":\\d+\\/";
//		pattern = Pattern.compile(regxpPort);
//		matcher = pattern.matcher(url);
//		String port = "";
//		while (matcher.find()) {
//			port = matcher.group(0);
//		}
//		if ("".equals(port)) {
//			System.out.println("������Ϣ����û�ж˿�");
//		} else {
//			port = port.substring(1, port.length() - 1);
//		}
//		System.out.println("�˿ڣ�" + port);
//
//		String regxpFile = "\\/([\\w]+\\/)?[\\w]+\\.[\\w]+";
//		pattern = Pattern.compile(regxpFile);
//		matcher = pattern.matcher(url);
//		String file = "";
//		while (matcher.find()) {
//			file = matcher.group(0);
//		}
//		if ("".equals(file)) {
//			System.out.println("������Ϣ����û���ļ�");
//		} else {
//			file = file.substring(1, file.length());
//		}
//		System.out.println("�ļ���" + file);
		
		//��һ�Ѵ����Եþͺ�ɵ��
		String regxp = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
		Pattern pattern = Pattern.compile(regxp);
     	Matcher matcher = pattern.matcher(url);
     	//����ƥ�䣬���ƥ��ɹ��������ͨ���������group�õ�ֵ
     	if(matcher.matches()) {
     		System.out.println("����ƥ��="+matcher.group(0));
     		System.out.println("Э�飺"+matcher.group(1));
     		System.out.println("������"+matcher.group(2));
     		System.out.println("�˿ڣ�"+matcher.group(3));
     		System.out.println("�ļ���"+matcher.group(4));
     	}
	}
}
