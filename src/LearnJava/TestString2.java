package LearnJava;
//String���
public class TestString2 {

	String str =new String("ABC");
	final char[] ch= {'V','B','O'};
	
	
	
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

//	public void change(TestString2 test,char ch[]) { 
//		test.setStr("CBA");
//		
//		ch[0]='F';
//	}˼·��
	
	public void change(String str,char ch[]) { 
	str="ABC";
	
	ch[0]='F';
}
	public static void main(String[] args) {
		TestString2 test=new TestString2();
		//test.change(test.str, test.ch);

		//test.change(test.str.intern(), test.ch);//����˼·1����Ч
		test.change(test.str, test.ch);
		System.out.print(test.str+" and ");
		System.out.println(test.ch);
	}
	//���strû�����仯����ch�����˱仯ABC and FBO
	//������
	/*
	 * 1.������Ҫ�����ǳ���ִ�е��ڴ�ֲ���ʽ
	 *  --����ջ�е������������������new���ڶ��ﴴ��һ������Ȼ��testָ�����Ķ���
	 *  --���������ﴴ����һ��TestString2���������Stringָ��������һ��String����
	 *  --��   String�����������value����ָ���˳������е�ABC��TestString2���ch
	 *   --��  ָ����е�һ��������������˳������VBO�����ַ�
	 * 2.������������µķ���ʱ������ջ�￪��һ���µ�ջ֡
	 *  --��������changeʱ������һ���µ�ջ֡������str��ch��������
	 *  --��  strָ�����testָ���TestString2�������strָ���value
	 *  --��  chָ�����testָ���TEstString2�������chָ���������ַ�ռ�
	 *  --��  str="CBA"-->��ζ��str���ڳ����ؿ���һ���µĳ���CBA��Ȼ����strָ����
	 *  --��    ������ע�⣬��ʱ��str��ֵ��ʱ����ָ��value����ʱ����ָ���˳�����
	 *  --��                ��û�иı�TestString2�������strָ��
	 *  --��  ch[0]=��F�����ı��˸õ�ַ���ֵ����Ӧ��TestString2�������chָ���ֵҲ�ͱ仯��
	 *  
	 */
	
	//��ô��ô�������ı�str��ֵ�أ�
	/*
	 *˼·1����.interֱ�ӷ���valueָ��ĳ�������ֵ��Ȼ���޸���������ϸ���񣬲��ԣ�������
	 *       ���ݶ���final ��øĲ���-->��ʵ��Ȼ��ʵ��֤������������˵�ļ���inter��ֻ������
	 *       �����ֵ�ʼָ��ĳ������У�������ȥ��дҲ��Ȩ��дABC��ֻ���½�һ��CBAȻ���Լ�
	 *       ָ������valueֵ����û��
	 *˼·�����ܲ�����cһ�������ĵ�ַ�����ȥ,û�У���ʱû�з���java�����ô���
	 *        ò��java�н���ֵ����
	 *        ����˼·�������ı�Ļ�,����ʹ��Holder��װ���װString,
	 *˼·��������д��set���������������Ϊ����Ȼ��ȥ����set����---���ɹ���ʽ
	 */
}
