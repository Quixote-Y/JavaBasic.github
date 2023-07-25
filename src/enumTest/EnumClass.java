package enumTest;
/*
 * ö���ೣ���ڣ������̶������Ա���Թ̶���
 * ��Ӧ�ñ����������޸ĵĵط�
 * �˴���������Զ���ö�ٺ�enum�ؼ���ö��
 */
public class EnumClass {
	
	public static void main(String[] args) {
		System.out.println(Season.AUTUM.toString());
		System.out.println(Season.WINTER.toString());
		System.out.println(Season2.AUTUM.toString());
		System.out.println(Season2.WINTER.toString());
		
		//������
		Gender boy=Gender.BOY;
		Gender boy2=Gender.BOY;
		System.out.println(boy);//���boy�������ǵ���Gender��toString��������Genderû����д
		                  //�����������������׷�ݣ��ҵ�����Enum��toString��ִ��
		
		System.out.println(boy2==boy);//true,������ֵ
		Music.CLASSICMUSIC.play();//�����Ϳ��Ե���ʵ�ֽӿ���ķ���
	}

}
enum Gender{
	BOY,GIRL;
}
//�Զ���ö����
class Season{//��
	
	private String name;
	private String desc;//����
	//3.�Զ����ĸ�ö���࣬�̶�
	public static final Season SPRING =new Season("����","��ů��");
	public static final Season SUMMER =new Season("����","���ȵ�");
	public static final Season AUTUM  =new Season("����","��ɪ��");
	public static final Season WINTER =new Season("����","�����");
	
	//���裺
	/*1. ������˽�л������ⲿ�޷�����new��ʵ���������
	 *2. ȥ��set������ֻ����get�����������ⲿ�ı�ֵ
	 *3. �����ﴴ��һ����󣬼�ö�ٳ�����
	 *   ���pubic fianl static���η���
	 *   ö������Ϊ�ǳ���һ��ȫ����д
	 */
	/*1*/
	private  Season(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	/*2*/
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getDesc() {
		return desc;
	}
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
	@Override
	public String toString() {
		return "Season [name=" + name + ", desc=" + desc + "]";
	}
}

//ʹ��enum�ؼ�����ʵ��ö��
enum Season2{//��
	
//	�Զ�������ö����
//	public static final Season SPRING =new Season("����","��ů��");
//	public static final Season SUMMER =new Season("����","���ȵ�");
//	public static final Season AUTUM  =new Season("����","��ɪ��");
//	public static final Season WINTER =new Season("����","�����");
//	

	//���ʹ��enum��ʵ��ö��
	//1.ʹ�ùؼ���enum�����class
	//2.�Զ���ö��ʱ��public static final Season SPRING =new Season("����","��ů��");
	//  ʹ�ã� SPRING("����","��ů��")������ͺ���
	//3.���ж����������ʱʹ�ã����������ǣ���
	//4.���ʹ��enum�ؼ�����ʵ��ö�٣����뽫���峣��������ǰ��
	//5.���ʹ�õ����޲ι��캯��������ֱ��SPRING��ʲô������
	//6.enum����ʽ�̳���Enum��
	SPRING("����","��ů��"),SUMMER("����","���ȵ�"),AUTUM("����","��ɪ��"),WINTER("����","�����");
	private String name;
	private String desc;//����
	private  Season2(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Season [name=" + name + ", desc=" + desc + "]";
	}
}


//enum��Ϊ��ʽ�̳���Enum�࣬���Բ����ڼ̳�������
//��enum��Ҳ��һ���࣬����ʵ�ֽӿ�

interface Play{
	/*public abstract*/void play();
}
enum Music implements Play{
	CLASSICMUSIC;

	@Override
	public void play() {
		// TODO �Զ����ɵķ������
		System.out.println("��������");
	}
	
}
