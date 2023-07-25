package exception;
/**
 * a)编写应用程序EcmDef.java,接收命令行的两个参数(整数)，计算两数相除。
 * b)计算两个数相除,要求使用方法cal(int n1, int n2)
   (C)对数据格式不正确、缺少命令行参数、除0进行异常处理.
 * @author 86136
 *
 */
public class Practice2 {
	
	public static void main(String[] args) {
		int num1 ;
		int num2 ;
		int res =0;
		try {
			if(args.length!=2) {
				throw new ArrayIndexOutOfBoundsException();
			}
			 num1 = Integer.parseInt(args[0]);
			 num2 = Integer.parseInt(args[1]);
			 res=cal(num1,num2);
		} catch (NumberFormatException e) {//数据格式不正常
			// TODO: handle exception
			System.out.println("数据格式不正确");
		}catch ( ArrayIndexOutOfBoundsException  e) {
			System.out.println("缺少或多输命令行参数");
		}catch(ArithmeticException e) {
			System.out.println("除0");
		}
		System.out.println(res);
	}
	public static int cal(int num1,int num2) {
		return num1/num2;
	}
}
//在dos上成功运行，下面记录一些细节：
/*
 * 首先，必须在java程序对应的文件夹下执行javac
 * 执行完javac之后，必须要退回到你这个java程序对应包的位置，
 * java exception.Practice2 23 1
 * 退回到src文件夹执行，不然会出现---》错误: 找不到或无法加载主类 Practice2
 * 然后就是输入参数--》紧跟在后面就好了
 * CLASSPATH配置了但好像没用
 */
