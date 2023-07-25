package array;
/*
 * 测试数组遍历
 */
public class arrayForeach {

	public static void main(String[] args) {
		String[] a= {"北京","上海","广东","深圳"};
		
		//一般遍历
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//for-each遍历
		//只能用于简单的数组或容器的内容读取，不能修改数据内容
		for(String t:a) {
			System.out.println(t);
		}
		
		//for-each中第一个参数String t是遍历元素，而a是遍历对象，
		//从头开始取a中的元素放到String t中，每次都执行循环体中的算法
	}
}
