package enumTest;

public class Test {

	public static void main(String[] args) {
		Week[] week=Week.values();
		System.out.println("==�������ڵ���Ϣ����==");
		for(Week t:week) {
			System.out.println(t.getName());
			System.out.println(t.toString());
		}
	}
}
enum Week{
	MONDAY("����һ"),TUESDAY("���ڶ�"),WEDNESDAY("������"),THURSDAY("������"),FRIDAY("������"),SATURDAY("������"),SUNDAY("������");
	
	private Week(String string) {
		// TODO �Զ����ɵĹ��캯�����
		this.name=string;
	}

	private String name;

	public String getName() {
		return name;
	}
}