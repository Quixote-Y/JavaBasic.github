package stringBufferAndBuilderClass;
//StringBuffer���÷���
public class StringBufferMethod {

	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Hello");
		//�� append
		s.append(',');
		s.append("It's me");
		s.append("����").append("����").append(100).append(10.2);//Hello,It's me���ġ�����
		System.out.println(s);
		
		//ɾ delete����
		//ɾ��������������ַ���ǰ�պ�
		s.delete(13, 15);//ɾ������
		System.out.println(s);
		
		//�� replace
		//�滻������������ַ���ΪĿ���ַ���
		s.replace(1,5 , "Go to hill");
		System.out.println(s);//HGo to hill,It's me����10010.2������0��ʼ
		
		//�� indexof 
		int indexOf=s.indexOf("����");
		System.out.println(indexOf);//19
		indexOf=s.indexOf("299");
		System.out.println(indexOf);//-1û�ҵ�
		
		//����
		System.out.println(s.length());
		//����insert
		
		s.insert(9, "����");//������9��λ�ò��롰���롱�ַ�����ԭ��9�����ݺ���
		System.out.println(s);
		
	}
}
