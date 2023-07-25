package LearnJava;
/**
 * 一个简单骰子游戏
 * @author 86136
 *
 */
import java.math.*;//导入math包.random（）生成随机数
public class TestIf01 {

	public static void main(String[] args) {
		
		//生成三个随机数
		int i = (int)(Math.random()*6)+1;//random随机生成一个double类型的小数介于0-1，不到1，转换为int向下取整
		int j = (int)(Math.random()*6)+1;
		int k = (int)(Math.random()*6)+1;
		
		int count = i+j+k;
//      switch(count) {
//		case 1 : System.out.println();
//		case 2 :
//		default :
//	    }switch适用于定值
		
		System.out.println(count);
		if(count>15) {
			System.out.println("good");
		}
		else if(count>=10) {
			System.out.println("simple");
		}
		else {
			System.out.println("bad");
		}
	}
}
