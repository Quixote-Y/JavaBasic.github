package encapsulation2;
/**
 * ��Ϊ�������Ա�ʶ����Ч��Χ����Ϊ��ͬ��������
 * @author 86136
 *
 */
import encapsulation.Person;

public class Boy extends Person{

	public void play() {
		//System.out.println(testPrivate);
		//System.out.println(testDefault);//�޷�����private��default��
		System.out.println(testProtected);
		System.out.println(testPublic);
		
		Person a1=new Person();
		//System.out.println(a1.testPrivate);
		//System.out.println(a1.testDefault);
		//System.out.println(a1.testProtected);
		System.out.println(a1.testPublic);
	}
	
	//����protected��һЩϸ�ڣ�
	//1.��������������ͬһ�������������Է��ʸ����protected��Ա��
	//Ҳ���Է��ʸ�������protected��Ա
	//2.�����������಻��ͬһ�������������Է��ʸ����protected��Ա����
	//���ܷ��ʸ�������protected��Ա��
	
	

}
