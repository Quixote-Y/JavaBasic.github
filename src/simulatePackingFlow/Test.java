package simulatePackingFlow;

public class Test {

	
	public static void main(String[] args) {
	
		FileReader_ fileReader_=new FileReader_();
		BufferedReader_ bufferedReader_=new BufferedReader_(fileReader_);//把上一个文件流作为参数传给包装流
		                                         //这样通过多态，能调用他的方法,
		//是这样的：你传给BufferedReader的是一个Reader，然后BufferedReader里面的方法写的时候都是用的Reader
		//里面提供的方法，但创建BufferedReader，传入的参数是一个Reader的实现类，他里面也有一个和Reader相同名称的
		//方法，这样的话，多态的条件：继承，方法重写，父类引用指向子类对象，这样当父类使用子类重写过的方法时就会多态调用子类的方法
		//因此在BufferedReader中调用子类FileReader的fileRead（），因此才会出现输出
		
		bufferedReader_.fileReaders();
	}
}
