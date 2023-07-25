package date_;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//JDK8����ĵ�����data
public class ThridDate {
/*
 * Date��Calendarȡ��
 * Jdk8�Ժ���ΪCalender��Date��ȱ�㣬�������µĵ�����������
 * ��  ȱ�㣺�ɱ��ԣ����ں�ʱ����������Ӧ���ǲ��ɱ��
 *           ƫ���ԣ�Date����ݴ�1900�꿪ʼ�����������·ݶ��Ǵ�0��ʼ��Ҫ+1
 *           ��ʽ����ֻ��Date���ԣ�Calender������
 *           �̲߳���ȫ�����̱߳�̳���
 */
	public static void main(String[] args) {
		//����������
		/*
		 * LocalDateTime����ȡ����+ʱ��  LocalDate����ȡ����  LocalTime����ȡʱ��
		 */
		//ʹ��now�������ر�ʾ����ʱ��� ����
		LocalDateTime ldt=LocalDateTime.now();//
		System.out.println(ldt);
		System.out.println("�꣺ "+ldt.getYear());
		System.out.println("��1�� "+ldt.getMonth());
		System.out.println("��Value�� "+ldt.getMonthValue());
		System.out.println("�գ� "+ldt.getDayOfMonth());
		System.out.println("ʱ�� "+ldt.getHour());
		System.out.println("�֣� "+ldt.getMinute());
		System.out.println("�룺 "+ldt.getSecond());
		
		//ʹ��DateTimeFormatter ��������ʽ�����
		//----------->DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
		//��SimpleDateFormat ��������
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format=dtf.format(ldt);
		System.out.println("��ʽ��������Ϊ�� "+format);
		
		
		//ʱ���Instant
		//1.ͨ��now������ȡ��ʾ��ǰʱ���ʱ�������
		Instant now =Instant.now();
		System.out.println("��ǰ��ʱ���ʱ��"+now);
		//2.ͨ��Date��form�������԰�Instantʱ�������ת��ΪDate
		Date date=Date.from(now);
		System.out.println("ʱ���ת��Ϊʱ���ǣ�"+date);
		//�����̫�ÿ����ٰ�����ʽ���һ��
		
		
		//String InsFormat=dtf.format(Date);
		//System.out.println(InsFormat);
		/*����һ�����⣺ת������Date��Instantʱ�������以ת��Ȼ��д����LocalDateTime
		 * �ĸ�ʽ����������Ե��ò���
		 * ����дһ��
		 */
		//����Date��ĸ�ʽ�����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String insFormat=sdf.format(date);
		System.out.println("ʱ���תDate��ʽ���������ǣ�"+insFormat);//���Ե�
		
		//3.������ͨ��Date�����toInstant�����������԰�Date������ת��ΪInstantʱ�������
		Instant inatant=date.toInstant();
		System.out.println("����Dateת��������ʱ����� "+inatant);
		
	    //�����ܶ࣬plus minus���Ӽ�ʱ�����㣬�����Ƿ������
		//�������ȥ��LocalDateTime�ĳ�Ա����API
		
	}
}
