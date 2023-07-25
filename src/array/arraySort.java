package array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class arraySort {

	//���������㷨
	/*
	 * 1.�Լ�д�����㷨����Arrays�ṩ��sort�㷨
	 * 2.��Ϊ�������������ͣ�ͨ��sort������ֱ��Ӱ�쵽ʵ��arr
	 * 3.sort�����صģ�Ҳ����ͨ������һ���ӿ�Comparatorʵ�ֶ�������
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Ĭ������

		Integer[] arr= {1,434,21,212,35312,2,3,5,6,21};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//Ĭ���ɴ�С��˳��
        
        //��������
        /*
         * 1.���ö�������ʱ���贫������������
	     * 
	     *    ��1�����������arr
	     *    ��2��ʵ��comparator�ӿڵ������ڲ��࣬Ҫ��ʵ��compare����
	     *2.����·�ߣ�
	     *    ��1��Arrays.sort(arr, new Comparator(
	     *    ��2���������е� binarySort(a, lo, hi, lo + initRunLen, c);����
	     *    ��3�����Ǹ�������������������һ�δ��룺
	     *              while (left < right) {
                            int mid = (left + right) >>> 1;
                            if (c.compare(pivot, a[mid]) < 0)
                                      right = mid;
                            else
                                      left = mid + 1;}
                  ����compare�����Ĳ�ͬ��������һ���Ķ��������ݶ�̬�󶨻�ص�����
                  
                 ��4��@Override
			           public int compare(Object o1, Object o2) {
				          // TODO �Զ����ɵķ������
				           Integer i1=(Integer) o1;
				           Integer i2=(Integer) o2;
				           return i2-i1;
				        ����ֵ>0����<0��Ӱ��������
         */
        Arrays.sort(arr, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO �Զ����ɵķ������
				Integer i1=(Integer) o1;
				Integer i2=(Integer) o2;
				return i2-i1;
			}  	
        });//��������int����	
        
        System.out.println(Arrays.toString(arr));
        //�������binarySearch
        /*
         * 1.Ҫ��Ŀ����������������
         * 2.�������ڣ�����return -(low+1);
         */
        int index=Arrays.binarySearch(arr,21);
        System.out.println(index);
        
        //copyOf ����Ԫ�ظ���
        //��arr�����п���arr.length��Ԫ��
        Integer[] newArr =Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));
        //equals����������Ԫ�����
        //asList��������ת��ΪList����
        //asList ���������� List���ӿڣ�
        //        ���������� java.util.Arrays$ArrayList��
        //         ��Arrays�����һ����̬�ڲ���
        List<Integer> asList=Arrays.asList(arr);
        System.out.println("asList: "+asList);
        System.out.println("asList�����������ǣ� "+asList.getClass());
	}
}
