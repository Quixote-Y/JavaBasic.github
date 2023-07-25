package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//Collections������
public class CollectionsTools {

	
	//COllections,,,,ssssss,s������
	@SuppressWarnings("all")
	public static void main(String[] args) {
	//����һЩCollection�ĳ��ú���
	//��ArrayList��ʵ��
	ArrayList list=new ArrayList();
	list.add("Simth");
	list.add("bob");
	list.add("breath");
	list.add("adcbe");
	list.add("a");
	//ע����Щ���Ǿ�̬������ͨ��Collections�ӿ�������
	
	//reverse(List):��תlist�е�˳��
	System.out.println(list);
	Collections.reverse(list);
	System.out.println("--------��ת��-------");
	System.out.println(list);
	
	//shuffle(List) ��List����Ԫ�ؽ����������
	Collections.shuffle(list);
	System.out.println("--------���Һ�-------");
	System.out.println(list);
	
	//sort(List) :����Ԫ�ص���Ȼ˳���ָ��List���ϰ������������ַ������־��ǰ���С
	Collections.sort(list);
	System.out.println("--------��Ȼ�����-------");
	System.out.println(list);
	//���ԣ����ԣ����ԣ�Ӧ�úͲ��õ��ַ������ʽ�йأ���д��ĸ��Сд��ĸС
	
	//sort(List ,Comparator):����ָ����Compatator������˳���list���д���
	//���ַ�����������
	Collections.sort(list, new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO �Զ����ɵķ������
			//�����жϷ�ֹ����
			if(!((o1 instanceof String)&&(o2 instanceof String)))
				return 0;
			return ((String)o1).length()-((String)o2).length();
		}
	});
	System.out.println("--------����Ƚ��������-------");
	System.out.println(list);
	
	//swap��List��int ��int������������Ԫ�ص�λ�ã�ע���Խ����
	Collections.swap(list, 0, 4);//��β����
	System.out.println("--------��λ������-------");
	System.out.println(list);
	
	//max��lsit�� ������Ȼ˳���µ����ֵ
	Object maxReturn=Collections.max(list);
	System.out.println("--------������Ȼ˳���µ����ֵ-------");
	System.out.println(maxReturn);
	
	//max(list ,Comparator):����Comparatorָ����˳�򷵻ظ�������������Ԫ��
	Object maxReturn2=Collections.max(list, new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO �Զ����ɵķ������
			if(!((o1 instanceof String)&&(o2 instanceof String)))
				return 0;
			return ((String)o1).length()-((String)o2).length();//���س�����ģ�����λ�ÿ��Է�����̵�
		}
	});
	System.out.println("--------����Ƚ����󷵻����Ԫ��-------");
	System.out.println(maxReturn2);
	
	//min���Ƚ����Ͳ����Ƚ�����maxһ��
	//frequency(list,object);����ָ��������ָ��Ԫ�س��ֵĴ���
	int num=Collections.frequency(list, "bob");
	System.out.println("--------bob���ֵĴ���-------");
	System.out.println(num);
	//copy(list dest,list src);��src�е�����ȫ���Ƶ�dest��
	//ע�⣺���Կ�copy��Դ�룬dest����Ҫ�ߴ��srcһ������ڣ���Ȼ��������Խ���쳣��������Ǳ����ȸ�dest��ֵ��ʼ���ߴ磬Ĭ���ǿ�
	ArrayList dest=new ArrayList();
	for(int i=0;i<list.size();i++) {
		dest.add("");
	}
	Collections.copy(dest, list);
	System.out.println("-------���Ƶ�dest--------");
	System.out.println(dest);
	
	//replaceAll��list , Object oldValue��Object newValue������list�����оɵ�ֵ��Ϊ�µ�ֵ
	
	Collections.replaceAll(dest, "bob", "����");
	System.out.println("-------bob���������dest--------");
	System.out.println(dest);
	
	
	
	
	}
	
	
}
