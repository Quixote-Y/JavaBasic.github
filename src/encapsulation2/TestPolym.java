package encapsulation2;
//���Զ�̬
//��̬���ڵ������Ǽ̳�+������д+����ָ���������
public class TestPolym {

	//
	static void animalShout(Animal a) {
	  
		System.out.println("TestPolym");
		a.shout();
	}
	
	public static void main(String[] args) {
		animalShout(new Dog());//Aniaml a= new Dog����,����ָ���������ִ�������е�shout����
		animalShout(new Cat());
		
		//��������Animal   ����ʱ����Dog
		Animal animal=new Dog();//����ת�ͣ��Զ���
		animal.shout();
		//animal.seeDoor;�޷����ã�����ʱ��dog����ת��Ϊanimal�ͣ�ֻ����д�ĺ����ܱ�����
		
		Dog d=(Dog)animal;//����ת�ͣ�ǿ�ƣ�
		d.seeDoor();//�����Ϳ���ʹ��dog�ķ�����
		
		
		//ǿ������ת������ת��Ϊ�κ����ͣ�����������ڸ���������д���
		//��ʱ�����ʹ��instanceof���жϸ���������һ����
		
		if(animal instanceof Cat) {
			Cat c=(Cat)animal;
			c.shout();
		}
		if(animal instanceof Dog) {
			Dog f=(Dog)animal;
			f.seeDoor();
		}
	}
}
