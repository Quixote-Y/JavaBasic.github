package LearnJava;

public class TestChar {
	public static void main(String[] args) {
		char c1='a';
		char c2 ='��';
		char c3 = '\u0061';// u��ʾuncoide����
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//java���ַ������ǻ����������ͣ�����һ����
		String str = "�Ұ��й�";
		System.out.println(str);
		
		//ת���ַ�
		char c5 = '\n';//ת���ַ�\n��ʾ���У�\"��������˫����\'��ӵ�����
		System.out.println("a\n\"b\"\nc\nd");//�����
		System.out.println("a\tb\tc\td\t");//��������Ʊ��
		}

}
