package array;

import java.util.Arrays;
import java.util.Scanner;


/*
 * 注意结构，老是出错
 * ____----->数组也是对象。对象  对象
 * 数组复制-->引用传递，开辟新的地址空间
 */
public class arrayCreate {

	public static void main(String[] args) {
		int[] s;//声明
		s= new int[10];//创建
		for(int i=0;i<10;i++) {
			s[i]=i;
		}//给值
		for(int i=0;i<10;i++) {
			System.out.println(s[i]);
		}
		
		Apple[] apple;//声明
		apple = new Apple[10];//创建
		for(int i=0;i<10;i++) {
			apple[i]=new Apple(i,10*i);
		}//赋值，引用类型，实际给的是堆内数据的地址
		
		for(int i=0;i<10;i++) {
			System.out.println("apple "+i+"cost :"+apple[i].getCost()+"  weig :"+apple[i].getWeig());
		}
		
		//引用传递，两个一个堆地址，改一个另一个也会变
		int[] arr1= {10,20,30};
		int[] arr2=arr1;
		arr2[1]=1;
		System.out.println("arr1: "+Arrays.toString(arr2));
		System.out.println("arr2: "+Arrays.toString(arr2));//改了arr2，arr1也发生变化
		
		//开辟新的地址空间
		//大小 arr1.length;
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
		//修改arr3，arr1不发生变化

		//数组动态扩容
		int[] a= {1,2,3};
		Scanner scanner=new Scanner(System.in);
		
		for(;;) {
			System.out.println("是否继续y/n");
			String input =scanner.next();
			if(input.equals("y")) {
				int[] at=new int[a.length+1];
				int m=0;

				System.out.println("输入增加的元素和位置");
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
				a=at;//引用传递，传的地址
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
