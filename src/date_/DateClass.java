package date_;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.util.data�÷�����
public class DateClass {

	public static void main(String[] args) throws ParseException {
		/*1.��ȡ��ǰϵͳʱ��
		 *2.Ĭ�������ʱ���ǹ�������ڸ�ʽ�������Ҫ�Ը�ʽ����ת��
		 *3.����java.util.Date��
		 */
		Date d1 =new Date();//��ȡ��ǰʱ��
		System.out.println("��ǰʱ��= "+d1);
		
		//ͨ��ָ�����������ʱ��
		Date d2=new Date(23132132131L);
		System.out.println("d2ʱ��="+d2);
		
		//ָ�����ڸ�ʽ
		/*1.����SimpledataFormat���󣬿���ָ����Ӧ�ĸ�ʽ
		 *2.��ʽ�е���ĸ���й涨�ģ����Բ�api
		 * 
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss E");
		String formatdata=sdf.format(d1);//format(),������ת��Ϊ��Ӧsdf��ʽ
		System.out.println(formatdata);
		
		//��ָ����ʽ���ַ���תString��Ϊdata
		String s="1222��22��32�� 04:22:21 ���ڶ�";
		Date parse=sdf.parse(s);//ע������ط������һ���쳣
		                       //ParseException��ת���쳣���Ǹ������쳣�����봦��
		                       //���ǿ��԰����׳�
		//System.out.println(parse);���ԣ������Ļ�������������������ʽ��Ӧ�ü���ת��
		System.out.println(sdf.format(parse));//���ڳ����Ļ���ѭ��������
		
	}
}
