package array;
//����java�����鳣�ð�Arrays���ú����÷�

import java.util.Arrays;
public class arrayArrays {

	public static void main(String[] args) {
		//�ȿ���ô���鿽��
		String[] s = {"nihao","hellow","hi","good moring","afternoon","evening"};
		String[] sC=new String[10];//��������Ҫ���Ƶ���Ŀ���ַ
		
		//���鿽����������������Ϊ��ԭ���飬ԭ��ʼλ�ã�Ŀ�����飬Ŀ����ʼλ�ã����Ƴ���
		System.arraycopy(s, 0, sC, 0, s.length);

		//���sC
		System.out.println(Arrays.toString(sC));
		
		
	
		
		int[] a= {10,20,40,1,594,60,2319};
		//Arrays.toString(),��object���toString��ͬ���ǽ�����ָ�������ת��Ϊ�ַ����������
		System.out.println(Arrays.toString(a));
		//�������������
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//����Ԫ�����ڵ�����λ�ã���δ�ҵ��򷵻ظ���
		//���ֲ���
		System.out.println("159��λ��:"+Arrays.binarySearch(a, 159));
		System.out.println("594��λ��:"+Arrays.binarySearch(a, 594));
		
		System.out.println("����Ϊ�ַ��滻����-------");
		//����ַ�������ʼλ�õ�����λ��֮ǰ��Ԫ�ض��滻Ϊָ��Ԫ��
		int[] b = {1,2,3,4,5,6,7,8,9,0,};
		Arrays.fill(b,2,7,100);//������b�ĵڶ���λ����ʼ�����߸�λ��֮ǰ�������滻Ϊ100
		System.out.println(Arrays.toString(b));
	}
}
