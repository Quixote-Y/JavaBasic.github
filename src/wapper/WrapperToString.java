package wapper;


//��װ����ôתString
public class WrapperToString {

	public static void main(String[] args) {
		//��װ�ࣨInteger��--��String
		Integer i=100;//�Զ�װ��
		//��ʽ1
		String str=i+"";
		//ע��ת��֮���iû��Ӱ��
		//��ʽ2
		String str2=i.toString();
		//��ʽ3
		String str3=String.valueOf(i);
		
		//String-->Integer
		String str4="1234";
		Integer i2 =Integer.parseInt(str4);//ʹ�õ��Զ�װ�䣬�Ƚ�strתΪint��
		                                 //�Զ�װ��Ϊinteger��װ��
		//�ù�����
		Integer i3 =new Integer(str4);
		
		//������
		Integer s1=new Integer(1);
		Integer s2=new Integer(1);
		System.out.println(s1==s2);//������ͬ����϶�����
		
		Integer s3=1;
		//�ײ�Integer.valueOf��1��-->��Դ��
		/*
		 *  public static Integer valueOf(int i) {
              if (i >= IntegerCache.low && i <= IntegerCache.high)
                   return IntegerCache.cache[i + (-IntegerCache.low)];
               return new Integer(i);
            }
         //i�ķ�Χ��-128��127�ھ���ֱ�Ӵ�cache���أ������newһ��Integer
		 */
		Integer s4=1;
		System.out.println(s3==s4);//true
		
		Integer s5=128;
		Integer s6=128;
		System.out.println(s5==s6);//false
		
		//ֻҪ�л������������Ǿͱ�Ϊֵ�Ƚ�
		Integer s7=128;
		int s8 =128;
		System.out.println(s7==s8);
	}
}
