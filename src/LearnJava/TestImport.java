package LearnJava;
/**
 * ����import�������
 * @author 86136
 *
 */
//import LearnJava.TestThis; ���Ƕ��һ�٣�TestThisΪpublic�࣬
//ͬһ�����п��Ի������
//import java.lang.*;//������а�����java�������﷨����System.out֮��ģ�
//javaĬ�ϵ��벻����ʾ����

//��̬����
import static java.lang.Math.*;//����Math���е����о�̬����
import static java.lang.Math.PI;//����Math���е�PI����

//�������̬����
//����Math.random����������Math.random������
//����PI��Math.PI��ͨ������ȥ����

public class TestImport {

	int a;
	 

	public static void main(String[] args) {
		new TestThis(1,2,3);
		System.out.println("This is import");
		
		//��̬�����
		System.out.println(PI);
		System.out.println(random());
		//������ͨ����������
		
	}
	
}
