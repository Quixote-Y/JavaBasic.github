package stringBufferAndBuilderClass;
//
public class StringBufferTest {

	/*StringBuffer������
	 * 
	 * 1.StringBUffer��ֱ�Ӹ�����AbstractStringBuilder
	 * 2.StringBufferʵ����Serializable�����Դ��л�
	 * 3.�ڸ����У�AbstractStringBuilder�и����� char[] value ������final����
	 *   ����String�����һ��������ŵ����ַ��������ݣ�����ͬ�����ڣ������ڶ��� 
	 * 4.Stringbuffer�Ǹ�final�࣬�����Ա��̳�
	 * 5.StringBuffer�ַ����ݴ���char[] value�У����б仯����ɾ������ÿ�α仯
	 *    �����ĵ�ַ�������¶��󣩣���������Ч�ʸ���String
	 */
	
	
	public static void main(String[] args) {
		//������ʹ��
		//1.�޲ι��캯�������Զϵ��ȥ����Ĭ��char[] ��С��16
 		StringBuffer stringbuffer1=new StringBuffer();
 		//2.һ��������������char[] ��СΪ�������ֵ
 		StringBuffer stringbuffer2=new StringBuffer(100);
 		//3.�����ַ�����������char[] ��СΪ�ַ���length+16
 		StringBuffer stringbuffer3=new StringBuffer("stri ng");
 		
 		
 		//String<--->StringBuffer
 		//1.������
 		String str1="ABC";
 		StringBuffer stringBuffer1=new StringBuffer(str1);
 		
 		String str2=new String(stringBuffer1);
 		
 		//2.ʹ��append������StringתΪStringBuffer
 		StringBuffer stringBuffer2=new StringBuffer();
 		stringBuffer2=stringBuffer2.append(str1);//�Ͱ�����ӽ�ȥ
 		
 		//3.ʹ��StringBuffer�ṩ��toStringתΪString
 		StringBuffer stringBuffer3=new StringBuffer("CBD");
 		String str3=stringBuffer3.toString();
	}
}
