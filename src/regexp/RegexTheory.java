package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//������ʽ Դ�����
public class RegexTheory {

	//������ʽ��Ҫ��������  �ַ� �ı� ����ȡ�������Ч��Ϣ
	public static void main(String[] args) {
		
		String content = "2021��˽��Ҫѧϰ���ϣ���ѧϰ������ְҵ�滮�ģ����Ϻ�΢�� hspcat   ��������Ϣ Bվ\r\n"
				+ "\r\n"
				+ "����Java�γ�Ϊ�����׶Σ�������Java�����ķ������档\r\n"
				+ "��һ�׶�:�������˼��(����:�����﷨�����顢����Ͳ��ҡ���������̡���Ǯͨ�����ݳ���ϵͳ���Թ����˻ʺ󡢺�ŵ�� )\r\n"
				+ "�ڶ��׶�:�����������(����: ö�ٺ�ע�⡢Exception�������ࡢ���ϡ����͡��̡߳�IO����̹�˴�ս) \r\n"
				+ "�����׶�: ��ǿ�������󣬴���ʵ������(����: �����̡����䡢Mysql��JDBC�����ӳء�������ʽ��Java8 Java11 �����ԡ���̤���̡�����¥�����û�ͨ��ϵͳ)\r\n"
				+ "\r\n"
				+ "�����⽲�⣺������Ѷ�����ţ��εΣ��ٶȣ�ͷ���ȹ�˾�������⡣\r\n"
				+ "\r\n"
				+ "������Ʒ�γ̷ǳ����࣬1212��лС���ĵ���ת�������֧���Ǻ���ʦ���Ķ�������л\r\n"
				+ "\r\n"
				+ "����˳ƽ�Ҹ桿19�������˾���Ҹ� 13����ѧ��̵Ŀ� ����˼���\r\n"
				+ "\r\n"
				+ "��2021��˳ƽ һ��ѧ��Linux����С������ ͨ���׶���2021��˳ƽ һ��ѧ��Linux\r\n"
				+ "\r\n"
				+ "����˳ƽJava����ר�� ������˳ƽ��Java��Java����ר�� -ArrayList HashMap HashSet List Map TreeMap TreeSet��\r\n"
				+ "\r\n"
				+ "����ȫ����ϸ��Java��ҵ��ѧϰ·�ߡ��Ҳ���java��˿�������? �����ѧ,�ҹ���û����  (��ȫ����ϸ��Java��ҵ��ѧϰ·��)\r\n"
				+ "\r\n"
				+ "����н60k��Java����Ա����н6032k��Java����Ա �������Թ�Ҫ����Щ����\r\n"
				+ "\r\n"
				+ "�������һ��ѧ��MySQL������˳ƽ��MySQL�������һ��ѧ��MySQL   -sql mysql�̳� mysql��Ƶ mysql����\r\n"
				+ "\r\n"
				+ "��Java����ר�⡿����˳ƽ��Java��Java����ר�� -���� ������� ����� reflection Class ��ṹ  ��\r\n"
				+ "\r\n"
				+ "��һ��ѧ���߳� Thread������˳ƽ��Java��һ��ѧ���߳� Thread Synchronized ������ ���� ���� ���� ������\r\n"
				+ "\r\n"
				+ "��Java������߳�ר�⡿����˳ƽ��Java��Java������߳�ר�� - TCP UDP Socket��� ���߳� �������� �ļ����� �������� Java\r\n"
				+ "\r\n"
				+ "��Java̹����Ŀ������˳ƽ��Java��Java̹����Ŀ ������� ���߳� ���� IO�� �㷨\r\n"
				+ "\r\n"
				+ "��Java IO��ר�⡿ ����˳ƽ��Java��Java IO��ר�� -io�� io���� �ַ��� �ֽ��� �ڵ��� ������ ��";
		
		//Ŀ�꣺ƥ�����е��ĸ�����
		//regex��������ʽ
		//ת���ַ����ĸ�����
		String regStr = "(\\d\\d)(\\d\\d)" ;
		//2.����ģʽ���󣬼�������ʽ����
		Pattern pattern = Pattern.compile(regStr);
		//3.����ƥ����
		//����ƥ����matcher ������ ������ʽ regStr �Ĺ���ȥ ƥ��content�ַ���������
		Matcher matcher = pattern.matcher(content);
		
		//4.��ʼƥ��
		/*
		 *  matcher.find() ��ɵ����񣨿��Ƿ��飩
		 *  ���飺 ������ָ������ʱ�ӣ�������һ��С������һ�飬(\\d\\d)(\\d\\d)
		 *  1.����ָ���Ĺ��򣬶�λ����涨���ַ����Ӵ��������һ��2021��
		 *  2.�ҵ��� �����ַ����Ŀ�ʼ������¼��matcher�ĳ�Ա���� int[] groups;��
		 *    2.1��group[0]=0,�Ѹ��ַ����Ľ�������+1��ֵ��¼��group[1]=4��ΪʲôҪ+1����Ϊ����groupȡ���ַ�����ʱ���õķ�����getSequence��ǰ�����
		 *    2.2���������˷��飬��ô group[0]��[1]�Ĵ�Ļ���һ�������ͻ����µ�group[2]��[3]����ŵ�һ������Ŀ�ʼ�ͽ���+1��������ķ���Ҳ������
		 *  3.֮����¼һ��matcher����olderLast������ֵΪ���ַ�����������+1���´���ִ��find����ʱ���ʹ�olderLast��ʼ
		 */
		/* 
		 *  matcher.group() 
		 *  Դ�룺
		 *   public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
    }
    
    
             ��Ҫ��    return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
		 *    ��˼��ȥ��groups[]���飬���������ֵ��ȥȡcontent�ַ������ִ���ÿ������һ��
		 *   group(?)���洫�Ĳ�������ȥ�ҵڼ��飬��0������������
		 */
		while(matcher.find()) {
			System.out.println("�ҵ�: "+matcher.group(0));
			System.out.println("�ҵ���һ��: "+matcher.group(1));
			System.out.println("�ҵ��ڶ���: "+matcher.group(2));
		}
	}
}
