package exception;
//�쳣
/*
 * ���������������쳣���ͻ��׳��쳣��Ȼ����ֹ���򣬳������
 * �����ǵ�һ��С���ܳ�����������³�����ֹ�ǲ��õ�
 * java�ṩ���쳣�������������������
 * �ڿ��ܳ����쳣/����ĵط�ʹ��try-catch
 * �Ӷ���֤����Ľ�׳��
 * ���裺�������ѡ�У�ע�������д��룬һ��û�ã�����alt+/��ѡ��try-catch����
 * �Լ�дʱ����һ�����⣬��������Exception�����³�ͻ���޷���ȷʶ���쳣������������ȷ
 */
/*���󣺳����޷�����
 * ����ʱ�쳣���������Լ������쳣�����޸��޷�����
 * ����ʱ�쳣����ζ�ų�����ƻ�ʵ��ʱ�������⣬����Խ�磬���������쳣����ָ�룬
 */
public class ExceptionTest {

	public static void main(String[] args) {
		//������5������ʱ�쳣
		//���������쳣
		int num1=1,num2=0;
	    try {
		int res=num1/num2;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣��ԭ���ǣ�"+ e.getMessage());//���������쳣
		}
	  //����Խ��
	    int[] arr= {1,2,3};
	    try {
			for(int i=0;i<=arr.length;i++) {
	    	System.out.println(arr[i]);
	        }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣��ԭ���ǣ�"+ e.getMessage());//����Խ��
		}
	  //��ת���쳣
	    A a=new B();//����ת��
	    B b=(B)a;//����ת�� ������ȷ��
	    try {
	        C c=(C)a;//����ͻ�������⣬��ת���쳣ClassCastException,��ΪB��Cû�й�ϵ
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣��ԭ���ǣ�"+ e.getMessage());//��ת���쳣
		}
	    
	    //���ָ�ʽ����ȷ�쳣NumberFormatException
	    String str="1234";
	    int num=Integer.parseInt(str);//�Ǻ��������������ת��ΪInteger���ͣ��Զ�����Ϊint
	    System.out.println(num);
	    
	    try {
			String str2 = "dasdad";
			int num5 = Integer.parseInt(str2);
			System.out.println(num5);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣��ԭ���ǣ�"+ e.getMessage());//���ָ�ʽ�쳣
		}
	    
	    //��ָ���쳣
	   try {
			 String Null=null;
	    System.out.println(Null.length());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣��ԭ���ǣ�"+ e.getMessage());//��ָ���쳣
		}
	}
}
class A{}
class B extends A{}
class C extends A{}