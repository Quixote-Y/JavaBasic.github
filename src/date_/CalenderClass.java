package date_;
//java.util.Calender��ʹ�÷���
import java.util.Calendar;
public class CalenderClass {

	public static void main(String[] args) {
		/*
		 * 1.Calender��һ�������࣬���ҹ�������private��������ʵ����
		 *    Calendar c=new Calendar();//����
		 * 2.����ͨ��getInstance()��������ȡʵ��������ȡCalander���еĳ�Ա��Ϣ
		 * 3.�ṩ�����ķ������ֶ�get������
		 * 4.û�и�ʽ�������������Ա������֯�����ʽ
		 * 5.�����Ҫ��24Сʱ��ʽ��ȡʱ�䣬���ȡCalendar.HOUR_OF_DAY
		 */
		
		Calendar c=Calendar.getInstance();//������������getInstance��һ����̬����
		                                  //ͨ����������
		System.out.println(c);//����c����ʲô
		
		//.��ȡ���������ĳ���ֶ�
		System.out.println("�� ��"+c.get(Calendar.YEAR));//��
		//�����·ݴ�0��ʼ��Ҫ+1
		System.out.println("�� ��"+(c.get(Calendar.MONTH)+1));//
		System.out.println("�� ��"+c.get(Calendar.DAY_OF_MONTH));//
		System.out.println("ʱ ��"+c.get(Calendar.HOUR));//
		System.out.println("�� ��"+c.get(Calendar.MINUTE));
		System.out.println("�� ��"+c.get(Calendar.SECOND));
		//System.out.println("�� ��"+Calendar.SECOND);
		//˵ʵ�����о���ʽ�ù�
		// public static final int DAY_OF_MONTH;����DAY_OFMONTH������
		//����һ����̬����������˵Ӧ��ֱ�ӵ��������Ϳ��Է���
		//�������ֲ�����һ���������������ȥget
		//��Щ�뷨��   �������Ǵ�SECOND���������Կ�����
		//       public static final int SECOND = 13;
		//ֱ�����Calendar.SECOND����13��Ȼ��c.get()ȴ����
		//���������c�Ĵ�����������У���Claendar.getInstance()������ע�ͣ�
		//��ȡʹ��Ĭ��ʱ�����������õ����������ص�ֵ���ڵ�ǰʱ��
		//��ô���ǿ�����Ϊ���ķ���ֵ������һ���µ�SECOND��final����Ҳ�����ܱ���д
		//�ǾͲ���
		//�����һ�ֿ��ܾͳ�����get�����ϣ�����ʱû�������Ʋ�Ӧ���ǻ�ȡ�˵���ʱ�䣬
		//Ȼ��ͨ��c.get�õ���Ӧλ�õ�����
		
		
		//û�и�ʽ������Լ���,���˸�����
		System.out.println(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH));
		
	}
}
