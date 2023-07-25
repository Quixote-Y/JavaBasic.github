package testInterface;
/**
 * 接口一些要点：
 * 1.接口中只能有常量，且默认是public static final，接口中的方法只能是public abstract
 * 也可省略
 * 2.接口可以多继承（多实现）
 * 3.子类通过Implements来实现接口规范
 * 4.接口不能创建实例，但可以声明引用变量类型
 * 5.一个类实现了接口，必须实现接口中的所有方法，并且这些方法只能是public的
 * @author 86136
 *
 */
public class TestInterface {

	public static void main(String[] args) { 
		Angel p =new Angel();
		p.fly();
		p.helpOther();
		System.out.println(Volant.Fly_DISTANCE);
		
		//4.接口不能创建实例，但可以声明引用变量类型
		Volant v=new Angel();//相当于父类对象指向子类对象
		v.fly();
		//v.heleOther();//helpOther在接口Voalnt中没有
		Angel a=(Angel)v;//强制类型转换
		a.helpOther();
	}
}
