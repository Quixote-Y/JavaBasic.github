package exception;
//�쳣�������
/*
 * try-catch-finally
 * throws
 */

/*try-catch-finally���ƣ�
 *  try{
 *     �������쳣�Ĵ���
 *  }catch(Exception e){  
 *   //1.���쳣����ʱ
 *   //2.ϵͳ���쳣��װ�ɶ���e���ݸ�catch
 *   //3.�õ��쳣����󣬳���Ա��catch�������д���
 *   //4.δ�����쳣��ִ��catch
 *   
 *   }finally{
 *    //1.�����Ƿ����쳣��ʼ��Ҫִ��finally��
 *    //2.ͨ������Դ�ͷŴ���ŵ�finally��
 */


/*throws�������
 * ����һ������ʱJVM����mian������main���������������γ�Ƕ�ף����������Լ�try-catch��
 * Ҳ��������throws/throw Exception ���ϲ��׳��쳣���Լ������д���ÿ�������������
 * ��main����Ҳ�����д���ʱ�����׸���߲���쳣����JVM��JVM��ȡ�ľٴ��ǣ�
 * ����쳣��Ϣ����ֹ����------��Ҳ��������ʲô��û��Ȼ������쳣ϵͳ�����������ϢȻ��ֹͣ
 * ��û�������κ��쳣�������ʱ��ϵͳĬ�ϲ���Throws��ʽ����
 * 
 */


public class ExceptionTry {
//�����⣬���ʲô��
	public static void main(String[] args) {
		//String a=null;
		//if(a.equals("good")) {
			//a="GooD";
		//}----------------------->�������׳���ָ���쳣
//		String[] a=new String[3];
//		if(a[1].equals("good")) {
//			a[1]="String";
//		}--->��ָ���쳣
		
		
		System.out.println(method());
		System.out.println("==================");
		System.out.println(method2());
	}
	
	public static int method() {
		try {
			String[] names = new String[3];
			if (names[1].equals("tom")) {//new String��ʼ��Ϊnull��null.equals�����ֿ�ָ���쳣
				System.out.println(names[1]);
			} else {
				names[3] = "jack";
			}
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return 2;
		}catch(NullPointerException e) {//�����ָ���쳣
			return 3;
		}finally {//��������ξ���ִ��finally���������return 4
			return 4;
		}
	}
	
	public static int method2() {
		int i=1;//i=1
		try {
			i++;//i=2
			String[] names = new String[3];
			if (names[1].equals("tom")) { //new String��ʼ��Ϊnull��null.equals�����ֿ�ָ���쳣
				System.out.println(names[1]);
			} else {
				names[3] = "jack";
			}
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return 2;
		}catch(NullPointerException e) {//�����ָ���쳣
			return ++i;//������ָ���쳣�󣬻���ִ��++i����ʱi=3�������滹��finally�飬������ִ��return
			           //��������һ����ʱ����tmp=3������Ҫ���ص�ֵ��Ȼ��ת��finally�У����finally��
			           //��return��ֱ�ӽ���������ִ����fnally���ֻ���ִ��return
			
		}finally {//ִ�������Ϣû��return�˻ص�����catch��
			++i;//i=4
			System.out.println("i="+i);
		}
	}
}
