package date_;

//�ַ�����ת��ָ�������ַ�����ת����д����
public class Practice1 {

	public static void main(String[] args) {
		String str = "abcdef";
		String res = reverse(str, 2, 5);
		System.out.println(res);
		System.out.println("Դ�ַ���" + str);
		String res2 = "";
		
		//�����ϰ�����쳣���������Ĵ������
		try {
			res2 = reversrChars(str, 2, 321);
		} catch (Exception e) {
			// TODO: handle exception
			// ����������쳣�������
			System.out.println(e.getClass() + e.getMessage() + "�������");
			return;
		}
		System.out.println("�������" + res2);
	}

	// ���Ȱ�������String��������������뵽��ֵ����--���з���ֵ�����ÿ������
	// char[]��Ԫ���ǿ��Խ�����
	// ������StringBuilder--�����ַ�����ĵ����ַ����в�����Ϊʲô���벻��ת������
	public static String reverse(String str, int start, int end) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder tmp = new StringBuilder();
		// ����Ҫ���ǵ�Ӧ������ô�õ�ָ��λ�õ��ַ�����ô�ı�����ֵ
		// �����뷨�����Ű��ַ���ȡ����Ȼ�����滻��ȥ
		String tmpc = "";
		for (int i = end - 1; i >= start - 1; i--) {
			tmpc = sb.substring(i, i + 1);
			tmp.append(tmpc);
		}
		str = tmp.substring(0);
		sb.replace(start - 1, end, str);// replace�滻���������ߣ�ǰ�պ�
		str = sb.substring(0);
		return str;

	}

	public static String reversrChars(String str, int start, int end) {

		// �쳣�ж�
		
		//��ȷ����ȡ�����׳��쳣
		if (!(str != null && str.length() >end-1 && start-1 >= 0 && end > start)) {
			//������
			throw new RuntimeException("��������쳣");
		}
		char[] chars = str.toCharArray();
		char tmp = ' ';
		for (int i = start - 1, j = end - 1; i < j; i++, j--) {
			tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}

		return new String(chars);// ֱ����chars����һ��String�����ͺ���
	}

}
