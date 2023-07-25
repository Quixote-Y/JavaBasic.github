package LearnJava;
/**
 * 测试switch
 * @author 86136
 *
 */
public class TestSwitch {

	public static void main(String[] args) {
		int grade =(int)((Math.random())*6+1);
		//switch在遇到break之前不会停,
		System.out.println(grade);
		switch(grade) {
		case 1 :
		case 2:
		case 3:
		case 4:System.out.println("他还小！");break;
		case 5:
		case 6:System.out.println("小屁孩！");break;
		}
		//像grade==2，程序会从2开始，但2没有break，那么他就会接着执行，直到遇到break；输出：2，3，4
		switch(grade) {
		case 1 :System.out.println("1！");
		case 2:System.out.println("2！");
		case 3:System.out.println("3！");
		case 4:System.out.println("4！");break;
		case 5:System.out.println("5！");
		case 6:System.out.println("6！");break;
		} 
		//defaut默认情况
	}
}
