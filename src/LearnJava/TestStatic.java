package LearnJava;
/**
 * ����static
 * @author 86136
 *
 */
public class TestStatic {

	int id;
	String name;
	int pwd;
	
	static String school;//��̬��Ա����
	
	
	//��̬��Ա��ʼ����
	static {
		System.out.println("������̬��ʼ����");
		school="XD";
		printSchool();
	}
	//������main������û���κ��ἰҲ�ᴥ���������ʱ�ͻ�ִ�У�
	//�̳й��캯����ʹ��˳��;�̬��ʼ����ִ��˳����һ���ġ�
	//������ļ��ض�ִ�У�����ֻ��ִ��һ��
	
	
	//��ͨ�����
	{
		System.out.println("������ͨ�����");
	}
	//ÿ����һ������ͻ�ִ��һ��
	
	
	TestStatic(int id,String name,int pwd){
		this.id=id;
		this.name=name;
		this.pwd=pwd;
	}
	
	public void login(){
		System.out.println(name);
		System.out.println(school);//���þ�̬��Ա����
	}
	
	public static void printSchool() {
		//login();//���÷Ǿ�̬��Ա��������i
		//System.out.println(name);���÷Ǿ�̬��Ա��������
		System.out.println(school);//���þ�̬��Ա����
	}
	
	public static void main(String[] args) {
		TestStatic.printSchool();//ͨ������ֱ�ӵ��þ�̬��Ա����
		TestStatic a=new TestStatic(1,"yang",123);
		a.login();
		school="xidian";//ֱ���޸ľ�̬��Ա������
		TestStatic.printSchool();//ͨ������ֱ�ӵ��þ�̬��Ա����
		
		TestStatic b =new TestStatic(2,"li",231);
		//ÿ����һ�ζ��󶼻�ִ��һ����ͨ�����
	}
 }
