package date_;
//����Han shun Ping���� ���Ping,Han.S
public class Practice3 {
	//�����ҵ�˼·��
//	public static void main(String[] args) {
//		
//		String input="Han Shun Ping";
//		String res="";
//		try {
//			
//		    res=nameDeal(input);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
//	}
//	
//	//�ַ���������
//	//��Ȼ��Ҫ���ַ������в�����ѡ��StringBUilder
//	//������û��Ҫ��stringҲ�з����ִ�������������String�Ļ�������ִ������������ܱȽ��鷳
//	//�ж��ַ���Ϊ��Ϊ��
//
//	public static String nameDeal(String name) {
//		if(name==null) {
//			throw new RuntimeException("��������Ϊ��");
//		}
//		int index1=name.indexOf(' ');
//		int index2=name.lastIndexOf(' ');//һ������String��indexof���Զ��ַ�char������
//		                   //StringBUilder��indexofֻ�ܶ��ַ����� ��������
//		String str1=name.substring(0, index1);//ȡ�ִ�������ǰ�պ󿪣�����Ҫ+1
//		String str2=name.substring(index2+1, name.length());
//		char str3=name.charAt(index1+1);
//		StringBuilder sbName=new StringBuilder();
//		sbName.append(str2).append(',').append(str1).append('.').append(str3);
//		return sbName.toString();
//	}
	//�̵ķ���
	public static void main(String[] args) {
		String name="Han shun Ping";
		namePrint(name);
	}
	
	public static void namePrint(String name) {
		if(name==null) {
			System.out.println("��������Ϊ��");
			return;
		}
		//��spilt�������ָ��ַ���
		//����ط�Ū���һ�Σ�spilt����ѡ�����
		String[] str=name.split(" ");//��name�ָ�������ո�ʱ�жϣ��浽str�ַ���������
		if(str.length!=3) {
			System.out.println("������ʽ����ȷ");
			return ;
		}//û���з�Ϊ3��
		//��String.format����ʽ�����
		String format=String.format("%s,%s.%c",str[2],str[0],str[1].toUpperCase().charAt(0));
		System.out.println(format);
	}

}
