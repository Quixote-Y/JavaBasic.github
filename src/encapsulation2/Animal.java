package encapsulation2;
/*测试多态，执行程序为TestPolym
 * 
 */
public class Animal {

	public void shout() {
		System.out.println("动物");
	}
}

class Dog extends Animal{
	//重写shout函数
	public void shout() {
		System.out.println("汪汪汪");
		
	}
	public void seeDoor() {
		System.out.println("狗正在看门");
	}
}
class Cat extends Animal{
	
	//重写shout函数
	public void shout() {
		System.out.println("喵喵喵");
	}
}
