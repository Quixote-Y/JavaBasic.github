package encapsulation2;
//测试多态
//多态存在的条件是继承+方法重写+父类指向子类对象
public class TestPolym {

	//
	static void animalShout(Animal a) {
	  
		System.out.println("TestPolym");
		a.shout();
	}
	
	public static void main(String[] args) {
		animalShout(new Dog());//Aniaml a= new Dog（）,父类指向子类对象，执行子类中的shout方法
		animalShout(new Cat());
		
		//编译类型Animal   运行时类型Dog
		Animal animal=new Dog();//向下转型（自动）
		animal.shout();
		//animal.seeDoor;无法调用，编译时把dog类型转换为animal型，只有重写的函数能被调用
		
		Dog d=(Dog)animal;//向上转型（强制）
		d.seeDoor();//这样就可以使用dog的方法了
		
		
		//强制类型转换可以转换为任何类型，但如果不属于该类则会运行错误
		//这时候可以使用instanceof来判断该类属于哪一个类
		
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
