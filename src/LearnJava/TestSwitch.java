package LearnJava;
/**
 * ����switch
 * @author 86136
 *
 */
public class TestSwitch {

	public static void main(String[] args) {
		int grade =(int)((Math.random())*6+1);
		//switch������break֮ǰ����ͣ,
		System.out.println(grade);
		switch(grade) {
		case 1 :
		case 2:
		case 3:
		case 4:System.out.println("����С��");break;
		case 5:
		case 6:System.out.println("Сƨ����");break;
		}
		//��grade==2��������2��ʼ����2û��break����ô���ͻ����ִ�У�ֱ������break�������2��3��4
		switch(grade) {
		case 1 :System.out.println("1��");
		case 2:System.out.println("2��");
		case 3:System.out.println("3��");
		case 4:System.out.println("4��");break;
		case 5:System.out.println("5��");
		case 6:System.out.println("6��");break;
		} 
		//defautĬ�����
	}
}
