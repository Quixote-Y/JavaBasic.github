package exception;
/**
 * a)��дӦ�ó���EcmDef.java,���������е���������(����)���������������
 * b)�������������,Ҫ��ʹ�÷���cal(int n1, int n2)
   (C)�����ݸ�ʽ����ȷ��ȱ�������в�������0�����쳣����.
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
		} catch (NumberFormatException e) {//���ݸ�ʽ������
			// TODO: handle exception
			System.out.println("���ݸ�ʽ����ȷ");
		}catch ( ArrayIndexOutOfBoundsException  e) {
			System.out.println("ȱ�ٻ���������в���");
		}catch(ArithmeticException e) {
			System.out.println("��0");
		}
		System.out.println(res);
	}
	public static int cal(int num1,int num2) {
		return num1/num2;
	}
}
//��dos�ϳɹ����У������¼һЩϸ�ڣ�
/*
 * ���ȣ�������java�����Ӧ���ļ�����ִ��javac
 * ִ����javac֮�󣬱���Ҫ�˻ص������java�����Ӧ����λ�ã�
 * java exception.Practice2 23 1
 * �˻ص�src�ļ���ִ�У���Ȼ�����---������: �Ҳ������޷��������� Practice2
 * Ȼ������������--�������ں���ͺ���
 * CLASSPATH�����˵�����û��
 */
