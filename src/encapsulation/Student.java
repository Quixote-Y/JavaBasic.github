package encapsulation;
/**
 * �������Ա�ʶ���ķ�Χ����ΪPersonͬһ�������
 * @author 86136
 *
 */
public class Student extends Person{

	public void study() {
		//System.out.println(testPrivate);���಻�ܵ��ø����private
		System.out.println(testDefault);
		System.out.println(testProtected);
		System.out.println(testPublic);
	}
}
