package array;

import java.util.Arrays;
import java.util.Scanner;


/*
 * ע��ṹ�����ǳ���
 * ____----->����Ҳ�Ƕ��󡣶���  ����
 * ���鸴��-->���ô��ݣ������µĵ�ַ�ռ�
 */
public class arrayCreate {

	public static void main(String[] args) {
		int[] s;//����
		s= new int[10];//����
		for(int i=0;i<10;i++) {
			s[i]=i;
		}//��ֵ
		for(int i=0;i<10;i++) {
			System.out.println(s[i]);
		}
		
		Apple[] apple;//����
		apple = new Apple[10];//����
		for(int i=0;i<10;i++) {
			apple[i]=new Apple(i,10*i);
		}//��ֵ���������ͣ�ʵ�ʸ����Ƕ������ݵĵ�ַ
		
		for(int i=0;i<10;i++) {
			System.out.println("apple "+i+"cost :"+apple[i].getCost()+"  weig :"+apple[i].getWeig());
		}
		
		//���ô��ݣ�����һ���ѵ�ַ����һ����һ��Ҳ���
		int[] arr1= {10,20,30};
		int[] arr2=arr1;
		arr2[1]=1;
		System.out.println("arr1: "+Arrays.toString(arr2));
		System.out.println("arr2: "+Arrays.toString(arr2));//����arr2��arr1Ҳ�����仯
		
		//�����µĵ�ַ�ռ�
		//��С arr1.length;
		//
		int[] arr3=new int[arr1.length];
		int i=0;
		for(int t:arr1) {
			arr3[i]=t;
			i++;
		}
		System.out.println("arr3: "+Arrays.toString(arr3));
		arr3[1]=10;
		System.out.println("arr1: "+Arrays.toString(arr2));
		System.out.println("arr3: "+Arrays.toString(arr3));
		//�޸�arr3��arr1�������仯

		//���鶯̬����
		int[] a= {1,2,3};
		Scanner scanner=new Scanner(System.in);
		
		for(;;) {
			System.out.println("�Ƿ����y/n");
			String input =scanner.next();
			if(input.equals("y")) {
				int[] at=new int[a.length+1];
				int m=0;

				System.out.println("�������ӵ�Ԫ�غ�λ��");
				int ins=scanner.nextInt();
				int loc=scanner.nextInt();
				for(int f=0;f<a.length;) {
					for(int j=0;j<at.length;j++) {
					if(j==loc) {
						at[j]=ins;
					}else {
						at[j]=a[f];
					    f++;
					}
				    }
				}
				a=at;//���ô��ݣ����ĵ�ַ
			}else {
				break;
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
}
class Apple{
	private int cost;
	private int weig;
	public Apple(int cost, int weig) {
		super();
		this.cost = cost;
		this.weig = weig;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getWeig() {
		return weig;
	}
	public void setWeig(int weig) {
		this.weig = weig;
	}
	
	
}
