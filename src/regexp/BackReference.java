package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

//��������
public class BackReference {

	// �������ã���������ʽ�д��ڷ���ʱ��ǰ��ķ������ʱ�ͻᱻ����group������Ļ�����ķ����������ǰ���Ѿ������˵ķ�����
	public static void main(String[] args) {

	}

	public void testBackReference() {
		// ������Ʒ��ţ�ǰ��������֣�Ȼ��һ��-�ţ�Ȼ��һ����λ���֣�ÿ����3��������ͬ
		String content = "21322-111222333";
		String regxp = "^\\d{5}\\-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
		// (\\d)\\3{2} ƥ�� һ������+�����͵�������������һ�� ���ַ���
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(content);
		Boolean tmp = matcher.matches();
		if (tmp) {
			System.out.println("ƥ��ɹ�");
		} else {
			System.out.println("ƥ��ʧ��");
		}
	}
	
	@Test
	public void stutterer() {
		//ȥ�����
		String content = "��....��Ҫ....ѧѧѧѧ.......���java!";
		
		//��ȥ�����е�.
		Pattern pattern = Pattern.compile("\\.");
		Matcher matcher = pattern.matcher(content);
		content = matcher.replaceAll("");
		System.out.println(content);
		
//		
//		//ȥ���ظ�����
//		//1.(.)\\1+  �Ȳ�������ͬ����  ����Ϊ+������һ���Ͳ��񵽵ĵ�һ��Ԫ����ͬ��
//		//2.ʹ�÷������� $1 ���滻ƥ�䵽������  ��������ʽ��Χ����
//		pattern = Pattern.compile("(.)\\1+");
//		matcher = pattern.matcher(content);
//		while(matcher.find()) {
//			System.out.println("�ҵ���"+matcher.group(0));
//		}
//		//������ȥƥ�俴��û���ظ��ĳ��֣����ظ��ĵ�����һ���Ӵ��ó��������������1��ÿ���Ӵ��ĵ�һ������
//		
//		//ʹ�÷�����$1 ���滻 ƥ�䵽�� ���ظ����Ӵ�
//		content = matcher.replaceAll("$1");       //$1�������ǰ���㲶�񵽵ĵ�һ�����飨��
//		System.out.println("content:"+content);
		
		
		//����Ĺ��̼�д
		//����(.)\\1+ ȥ��content�����ظ��ַ����Ӵ���ȡ���� ��Ȼ����ǰ��ģ�.���������ȡ������ֵȥ�滻��
		content = pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
		System.out.println("content:"+content);
	}
}
