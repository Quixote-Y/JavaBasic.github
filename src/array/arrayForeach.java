package array;
/*
 * �����������
 */
public class arrayForeach {

	public static void main(String[] args) {
		String[] a= {"����","�Ϻ�","�㶫","����"};
		
		//һ�����
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//for-each����
		//ֻ�����ڼ򵥵���������������ݶ�ȡ�������޸���������
		for(String t:a) {
			System.out.println(t);
		}
		
		//for-each�е�һ������String t�Ǳ���Ԫ�أ���a�Ǳ�������
		//��ͷ��ʼȡa�е�Ԫ�طŵ�String t�У�ÿ�ζ�ִ��ѭ�����е��㷨
	}
}
