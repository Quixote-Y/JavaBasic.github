package testInterface;
/**
 * �ӿ�Ĭ�Ϸ���
 * @author 86136
 *
 */
public interface TestInterfaceDefault {

	/*public abstract*/void printf();
	
	
	//Ĭ�Ϸ���
	default void moren() {
		System.out.println("����Ĭ�Ϸ���");
		//���þ�̬����
		testStatic();
	}
	
	//��̬����
	//��̬����ֻ��ͨ���ӿ���ȥ���ã�������ͨ��ʵ�ֽӿڵĶ���ȥ����
	//��̬�����в��ܵ���Ĭ�Ϸ�������Ĭ�Ϸ�������Ե��þ�̬����
	public static void testStatic() {
		System.out.println("���뾲̬����");
	}
	
}
