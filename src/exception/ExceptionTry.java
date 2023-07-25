package exception;
//异常处理机制
/*
 * try-catch-finally
 * throws
 */

/*try-catch-finally机制：
 *  try{
 *     可能有异常的代码
 *  }catch(Exception e){  
 *   //1.当异常发生时
 *   //2.系统将异常封装成对象e传递给catch
 *   //3.得到异常对象后，程序员在catch块中自行处理
 *   //4.未发生异常不执行catch
 *   
 *   }finally{
 *    //1.不管是否发生异常，始终要执行finally块
 *    //2.通常将资源释放代码放到finally中
 */


/*throws处理机制
 * 运行一个程序时JVM运行mian函数，main调用其他函数，形成嵌套，函数可以自己try-catch，
 * 也可以声明throws/throw Exception 向上层抛出异常，自己不进行处理，每个函数均是如此
 * 当main函数也不进行处理时，会抛给最高层的异常处理JVM，JVM采取的举措是：
 * 输出异常信息，终止程序------》也就是我们什么都没加然后出现异常系统会输出出来信息然后停止
 * 当没有声明任何异常处理机制时，系统默认采用Throws方式处理
 * 
 */


public class ExceptionTry {
//面试题，输出什么？
	public static void main(String[] args) {
		//String a=null;
		//if(a.equals("good")) {
			//a="GooD";
		//}----------------------->这样会抛出空指针异常
//		String[] a=new String[3];
//		if(a[1].equals("good")) {
//			a[1]="String";
//		}--->空指针异常
		
		
		System.out.println(method());
		System.out.println("==================");
		System.out.println(method2());
	}
	
	public static int method() {
		try {
			String[] names = new String[3];
			if (names[1].equals("tom")) {//new String初始化为null，null.equals，出现空指针异常
				System.out.println(names[1]);
			} else {
				names[3] = "jack";
			}
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return 2;
		}catch(NullPointerException e) {//捕获空指针异常
			return 3;
		}finally {//但无论如何均会执行finally，所以最后return 4
			return 4;
		}
	}
	
	public static int method2() {
		int i=1;//i=1
		try {
			i++;//i=2
			String[] names = new String[3];
			if (names[1].equals("tom")) { //new String初始化为null，null.equals，出现空指针异常
				System.out.println(names[1]);
			} else {
				names[3] = "jack";
			}
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return 2;
		}catch(NullPointerException e) {//捕获空指针异常
			return ++i;//捕获了指针异常后，会先执行++i，此时i=3，但后面还有finally块，不会先执行return
			           //而是生成一个零时变量tmp=3，等于要返回的值，然后转到finally中，如果finally中
			           //有return则直接结束，否则执行完fnally后又回来执行return
			
		}finally {//执行输出信息没有return退回到上面catch中
			++i;//i=4
			System.out.println("i="+i);
		}
	}
}
