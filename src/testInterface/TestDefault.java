package testInterface;
/**
 * ����jdk8�Ժ�ӿ��е������ԣ� Ĭ�Ϸ���ʹ�ã���̬������ʹ��
 * @author 86136
 *
 */
public class TestDefault implements TestInterfaceDefault {

	//��д����ӿ�
	@Override
	public void printf() {
		// TODO �Զ����ɵķ������
		System.out.println("����printf����");
	}

	public static void testStatic() {
		System.out.println("����ʵ������ľ�̬����");
	}
	
	//�ӿ��е�Ĭ�Ϻ���������дҲ���Բ���д
	public static void main(String[] args) {
		TestInterfaceDefault t =new TestDefault();
		t.moren();
		t.printf();
		
		//���Ծ�̬����
		//t.testStatic();����ģ��������еľ�̬��������������
		TestDefault.testStatic();
		//���ʽӿ��е�testStatic
		TestInterfaceDefault.testStatic();
		
		//ע�⣺
		//ʵ�������testStatci�����ǽӿ���ľ�̬��������д������û�й�ϵ��
		//ͨ���ӿڵ�ʵ�����޷����ʽӿڵľ�̬�ŷ���ֻ��ͨ���ӿ���
	}
	
	
	
	
}
