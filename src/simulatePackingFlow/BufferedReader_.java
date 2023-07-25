package simulatePackingFlow;

//包装流
public class BufferedReader_ extends Reader_{

	private Reader_ in;//其中一个参数是：Reader_父类，这样就可以传入任何一个Reader的实现类，对其提供更强大的操作
	
	//构造器
	public BufferedReader_(Reader_ in) {
		super();
		this.in = in;
	}
	
	//文件读升级
	public void fileReaders() {
		for(int i=0;i<10;i++) {
			in.fileRead();
		}
	}
	

	//字符串读升级
	public void stringReader() {
		for(int i=0;i<5;i++) {
			in.stringRead();
		}
	}
}
