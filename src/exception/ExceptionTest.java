package exception;
//异常
/*
 * 正常当程序遇到异常，就会抛出异常，然后终止程序，程序崩溃
 * 当我们的一个小功能出现问题而导致程序终止是不好的
 * java提供了异常处理机制来解决这个问题
 * 在可能出现异常/问题的地方使用try-catch
 * 从而保证程序的健壮性
 * 步骤：将代码块选中，注意必须多行代码，一行没用，按下alt+/，选择try-catch即可
 * 自己写时遇到一个问题，把类名叫Exception，导致冲突，无法正确识别异常，改类名后正确
 */
/*错误：程序无法处理
 * 编译时异常：编译器自己发现异常，不修改无法运行
 * 运行时异常：意味着程序设计或实现时出现问题，数组越界，算数运算异常，空指针，
 */
public class ExceptionTest {

	public static void main(String[] args) {
		//常见的5个运行时异常
		//算术运算异常
		int num1=1,num2=0;
	    try {
		int res=num1/num2;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常的原因是："+ e.getMessage());//算术运算异常
		}
	  //数组越界
	    int[] arr= {1,2,3};
	    try {
			for(int i=0;i<=arr.length;i++) {
	    	System.out.println(arr[i]);
	        }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常的原因是："+ e.getMessage());//数组越界
		}
	  //类转换异常
	    A a=new B();//向下转型
	    B b=(B)a;//向上转型 ，是正确的
	    try {
	        C c=(C)a;//这里就会出现问题，类转换异常ClassCastException,因为B和C没有关系
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常的原因是："+ e.getMessage());//类转换异常
		}
	    
	    //数字格式不正确异常NumberFormatException
	    String str="1234";
	    int num=Integer.parseInt(str);//记好了这个函数，先转换为Integer类型，自动拆箱为int
	    System.out.println(num);
	    
	    try {
			String str2 = "dasdad";
			int num5 = Integer.parseInt(str2);
			System.out.println(num5);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常的原因是："+ e.getMessage());//数字格式异常
		}
	    
	    //空指针异常
	   try {
			 String Null=null;
	    System.out.println(Null.length());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常的原因是："+ e.getMessage());//空指针异常
		}
	}
}
class A{}
class B extends A{}
class C extends A{}