package regexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

//������ʽ����һЩString�ķ����Ը���Ч
public class StringReg {

	public static void main(String[] args ) {
		//1.�滻
		//   ��jdk1.5 �� jdk5.0 �滻Ϊjdk
		String str = "������Java�ĺ��ģ�������Java���л�����Java Runtime Envirnment����"
				+ "һ��Java���ߺ�Java���������(rt.jar), SUN��˾���϶�����������"
				+ "�������˲�ͬ�İ汾��jdk1.5 ��Sun��˾�������еİ汾Ҳ����j"
				+ "dk5.0(JDK1.5 ������)";
		//����String��replace������Ҫ���������滻���,ʹ��������ʽ���䣬�����
		str = str.replaceAll("jdk1.5|jdk5.0", "jdk");
		System.out.println(str);
		
		//2.ƥ��
		String str2 = "13858802041";
		//ȥ�����Ƿ�����132��138��ͷ�ĵ绰����
		//ֱ����String��metches����
		boolean tmp =str2.matches("^1(32|38)\\d{8}$");
		if(tmp) {
			System.out.println("ƥ��ɹ�");
		}else {
			System.out.println("ƥ��ʧ��");
		}
		
		//3.�ָ�
		//���� *��-�����ֻ�#ȥ�ָ��ַ�
		String str3 = "hello*adb21smith#������-����";
		String[] strList = str3.split("-|\\*|#|\\d+");//�����Ƿָ�����,����*Ҫת�壬��Ȼ���쳣
		//Dangling meta character '*' near index 2
		System.out.println(Arrays.toString(strList));
	}
}
