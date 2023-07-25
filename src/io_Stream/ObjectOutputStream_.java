package io_Stream;
//序列化：存放数据到文件的时候，不仅存放数据值，还存放数据类型，这样能够后期读入时恢复数据类型
//反序列化：把数据从文件里读出的时候，回复数据类型
//声明：1.实现Serializable接口  //主推：标记接口，没有方法需要实现
       //2.Externalizable接口 

//序列化时：static   transient（不序列化，不保存） 这两个修饰的不被序列化，反序列化后他们的值会被置为默认值
//序列化对象时，该对象所有的属性都要实现Serializable接口，都要可序列化
//序列化具备可继承性，父类序列化，子类也默认可序列化

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.source.doctree.SerialDataTree;

//ObjectOutputStream  ObjectInputStream 也都实现了OutputStream InputStream接口，属于处理流（包装流）
//可以传入节点流为OutputStream InputStream接口的实现类
public class ObjectOutputStream_ {

	public static void main(String[] args) {
		
		//写入文件是什么类型的无所谓，写入不是按文本写入
		String path="E:\\javaTestFile\\ObjectOutput.txt";
		ObjectOutputStream oos=null;
		
		try {
			//内层文件流写的时候有没有true决定的是这次书写的内容是否覆盖文本之前的内容
			oos =new ObjectOutputStream(new FileOutputStream(path));
			//write
			oos.writeInt(100);//int-->Integer
			oos.writeBoolean(true);//boolean-->Boolean
			oos.writeUTF("节点流和处理流");//String用的时WriteUTF
			oos.writeObject(new Dog(10,"小王"));//写一个类对象进去
			System.out.println("数据写入完成");
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	
}
//想要能序列化，必须实现Serializable接口
class Dog implements Serializable{
	private int age;
	private String name;
	//private int wife;//有了序列化UID之后，你改变类的结构，不改变UID，那么编译器就会认为你修改的是不影响的东西，
	//                 进而反序列化就不会失败,
	//        你甚至可以调用你后面田间的方法，应该是向下转型的时候，编译器依照升级后的类结构为里面赋值默认值了
	//serialVersionUID  序列化版本号，可以提高兼容性
	/*
	 * 当执行序列化时，我们写入对象到磁盘中，会根据当前类的结构生成一个版本ID，
	 * 当反序列化的时候，程序会比较磁盘中的序列化版本ID和当前的类结构的版本ID是否一致，
	 *             如果一致，反序列化成功，不一致则失败
	 * 如果我们不显式定义一个serialVersionUID，那么编译器会默认生成一个UID，这个UID对类的结构十分敏感
	 * 反序列化可能会导致InvalidClassExpection异常
	 */
	private static final long serialVersionUID=1L;
	
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public int getWife() {
//		return wife;
//	}
//	public void setWife(int wife) {
//		this.wife = wife;
//	}
	
	
	
}
