package array;

import java.util.Arrays;
import java.util.Comparator;

//����һ������ʽ
public class ArraySortSelf {

	public static void main(String[] args) {
		int[] arr= {1,4343,12,432,21,43};
		bobbleSort(arr,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO �Զ����ɵķ������
				Integer i1=(Integer)o1;
				Integer i2=(Integer)o2;
				
				//return i1-i2;//��С����
				return i2-i1;//�Ӵ�С
			}
		});
		System.out.println(Arrays.toString(arr));
		
	}
	public static void bobbleSort(int arr[],Comparator c) {//��Comparator�ӿ�Ҳ�������
		int tmp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				     /*a[i]>a[j]*/
				if((c.compare(arr[i], arr[j]))>0) {//���compareʵ��ʱʱi-j���Ǿ���ð��
					tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
		}
	}
}
