package exception;
//�Զ����쳣
//throws�ڷ������������������쳣����
//throw�ڷ����У�����������쳣����
public class CustomExpection {

	public static void main(String[] args) {
		int age =231;
		//Ҫ��Χ��10---120�������׳�һ���쳣
		if(!(age>=10&&age<=120)) {
			throw new AgeException("������䲻�ԣ���Ҫ��10--120֮��");
		}
		System.out.println("������ȷ");
	}
	//���н����
	/*
	 * Exception in thread "main" exception.AgeException: ������䲻�ԣ���Ҫ��10--120֮��
	  at exception.CustomExpection.main(CustomExpection.java:9)

	 */
}
//�Զ���һ���쳣��AgeException
//�̳�RuntimeExceptionΪ����ʱ�쳣���̳�ExceptionΪ�����쳣
//һ��ʹ��RuntimeException,��Ϊ����ʹ��Ĭ�ϵ��쳣�׳����ƣ����Ӽ�
class AgeException extends RuntimeException{
	public AgeException(String message) {//����һ���������Ϳ�����
		super(message);//�ؼ�����
	}
}
