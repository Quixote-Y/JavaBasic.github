package encapsulation;
/**
 * �������Ա�ʶ���ķ�Χ��Ϊ1
 * @author 86136
 *
 */

public class Person {

	private    int testPrivate;
	           int testDefault;//��ʲô�����Ӿ���defaul��
	protected  int testProtected;
	public     int testPublic;
	
	public void study() {
		System.out.println(testPrivate);
		System.out.println(testDefault);
		System.out.println(testProtected);
		System.out.println(testPublic);//ͬһ������������Ϥ����ֱ�ӵ���
	}
}
