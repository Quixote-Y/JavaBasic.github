package encapsulation2;
/*���Զ�̬��ִ�г���ΪTestPolym
 * 
 */
public class Animal {

	public void shout() {
		System.out.println("����");
	}
}

class Dog extends Animal{
	//��дshout����
	public void shout() {
		System.out.println("������");
		
	}
	public void seeDoor() {
		System.out.println("�����ڿ���");
	}
}
class Cat extends Animal{
	
	//��дshout����
	public void shout() {
		System.out.println("������");
	}
}
