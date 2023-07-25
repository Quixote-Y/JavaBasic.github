package stringBufferAndBuilderClass;
//StringBUffer应用
import java.util.Scanner;

/*
 * 输入商品名称和价格，要求打印效果试列：
 * 商品名 商品价格
 * 手机 123，564.59
 * 要求：价格的小数点前面每三位用小数点隔开
 */
public class Practice1 {

	public static void main(String[] args) {
		System.out.println("请输入商品名和商品价格：");
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("商品名\t商品价格\n");
	
		Scanner scanner=new Scanner(System.in);
		String name=scanner.nextLine();
		String price=scanner.next();
		//把商品名加到buffer里
		stringBuffer.append(name+"\t");
		
		//处理价格的格式
		StringBuffer priceBuffer=new StringBuffer(price);
		int index=priceBuffer.lastIndexOf(".");
		for(;;) {
			if(index-3<=0)break;
			priceBuffer.insert(index-3, ",");//插入，
			index-=3;
		}
		stringBuffer.append(priceBuffer+"\n");
		System.out.println(stringBuffer);
	}
}
//增加一个for循环便可以实现重复输入