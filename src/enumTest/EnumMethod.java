package enumTest;
//Enum���÷���
public class EnumMethod {

	public static void main(String[] args) {
		//ʹ��Season2ö����
		Season2 autum=Season2.AUTUM;//ȡ��Autum
		//���ö�ٶ��������
		System.out.println(autum.name());
		//ordinal()������Ǹ�ö�ٶ����ʼ��ʱ�ı�ţ���0��ʼ
		//Autum�ǵ�������ʼ���ģ�������2
		System.out.println(autum.ordinal());
		//�����룺javap����.class�ļ�������Ϊjava�ļ������Կ���һЩ��ϸ��Ϣ
		//values�����Ǳ����صģ������Ҳ���
		//�ӷ�������Կ���values����������Season2[]
		//�����������Ѿ������Season2ö��
		Season2[] values =Season2.values();
		for(Season2 t:values) {
			System.out.println(t.toString());
		}
		//compareTo:�Ƚ�����ö�ٶ��󣬱Ƚϵ��Ǳ��
//		 public final int compareTo(E o) {
//		        Enum<?> other = (Enum<?>)o;
//		        Enum<E> self = this;
//		        if (self.getClass() != other.getClass() && // optimization
//		            self.getDeclaringClass() != other.getDeclaringClass())
//		            throw new ClassCastException();
//		        return self.ordinal - other.ordinal;
//		    }
		 //return self.ordinal - other.ordinal;��һ���ǹؼ�
		//�����Լ��ı��-����ı��
		//WINTER[3]-SPRING[0]=3
		System.out.println(Season2.WINTER.compareTo(Season2.SPRING));
		
	}
}
