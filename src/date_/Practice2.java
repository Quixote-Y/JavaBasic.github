package date_;

//�����û��������룬���䣬������ȷע��ɹ���������󷵻��쳣
//�û�������2--4
//���볤��Ϊ6��ȫ������
//�����а���@��.��@��.ǰ�� 
public class Practice2 {

	public static void main(String[] args) {

		String name="yan";
		String sec="212321";
		String email="12@qq.com";
		try {
			
		register(name,sec,email);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	// ע����Ϊһ���������ж�3�������ϸ���������Ӧ�쳣
	//����Ϊnull����
	public static void register(String name,String sec,String email) {
		if(name==null||sec==null||email==null) {
			throw new RuntimeException("��������Ϊ��");
		}
		if(!(name.length()>=2&&name.length()<=6)) {
			throw new RuntimeException("�����������Ȳ��ԣ�");
		}
		
		
		if(!(isDigital(sec)&&sec.length()==6)) {
			throw new RuntimeException("���������ʽ����ȷ��");
		}
		
		if(!(isEmial(email))) {
			throw new  RuntimeException("���������ʽ�쳣");
		}
		
		System.out.println("ע��ɹ���");
	}
	
	
	
	
	//д������������ַ����ǲ�������
	public static boolean isDigital(String sec) {
		//�������Լ���ķ���
//		try {
//			Integer.parseInt(sec);
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//		return true;
		
		//���ǽ���
		char[] chars=sec.toCharArray();
		for(int i=0;i<sec.length();i++) {
			if(chars[i]<'0'||chars[i]>'9') {
				return false;
			}
		}
		return true;
	}
	//д����������������ʽ
	public static boolean isEmial(String email) {
		int indexof1=email.indexOf('@');
		int indexof2=email.indexOf('.');
		if(!(indexof1<indexof2 && indexof1>=0 && indexof2>=0)) {
			return false;
		}
		return true;
	}
}
