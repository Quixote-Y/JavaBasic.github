package collection;

import java.util.ArrayList;

//ArrayList���ƽ���
public class ArrayListTest {

	public static void main(String[] args) {
		//ArrayList֧������Ԫ�أ�����null
		//���vector��arrylist���죬��vector֧�ֶ��߳�
		
		/*ArrayList�µ�add��������ArrayList���̲߳���ȫ�ģ�Դ��û��synchronized ��־
		 * private void add(E e, Object[] elementdata, int s) { 
		 * if (s ==elementdata.length)
		 *    elementdata = grow(); 
		 *    elementdata[s] = e; 
		 *    size = s + 1; 
		 *  }
		 */
		
		
		/*�ײ���ƣ�
		 * 1.ArrayListά����һ��Object���͵�����Elementdata.
		 *     transient Object[] elementdata;
		 * 2.������ArrayList����ʱ�����ʹ�õ����޲ι����������ʼelementdata����Ϊ0
		 *   ����һ����ӣ�������Ϊ10�������ٴ����ݣ�������Ϊelementdata��1.5��
		 * 3.���ʹ�õ���ֱ��ָ����С�Ĺ�����new ArrayList(int);�����ʼλָ����С������
		 *   ���ݣ�ֱ������λelementdata��1.5��
		 */
		
		/*��Դ��׷·����//�ҵİ汾����Ƶ���Ĳ�ͬ������������
		 * 1.��Ϊ����add��ֵʱint�������������ͣ�
		 * ����װ��Integer�� public static Integer valueOf(int i)
		 * 2.��ʽ����add������
		 * public boolean add(E e) {
              modCount++;//��¼�޸��˼��Σ����ж��̸߳���ʱ�׳��쳣
              add(e, elementdata, size);//����͵�����һ��add�ˣ�e�Ǽ���Ԫ�أ�
                                    //elementdata��ArrayList��Ŷ�������飬size������elementdata�������Ĵ�С����ʼ��0
                                    //�������£�size���������С������һ��������ָ������һ��Ҫ����elementdata��Ԫ��Ӧ�ü����λ��
              return true;
           }
		 * 3.����add
		 * private void add(E e, Object[] elementdata, int s) {
               if (s == elementdata.length)//��ʼʱs=0��elementdata.length=0��
               elementdata = grow();        //��һ�����Ԫ�ص����޲�grow����
               elementdata[s] = e;
               size = s + 1;
            }
		 * 
		 * 4.�����޲�grow()
		 *  private Object[] grow() {
                    return grow(size + 1);//�����в�grow���������������е�elementdata�ߴ�+1
                  }
	 	 * 
	 	 * 
	 	 * 5.�����в�grow����
	 	 * private Object[] grow(int minCapacity) {//int minCapacity��ǰ����Ҫ�Ĵ�С��
                   int oldCapacity = elementdata.length;
                   if (oldCapacity > 0 || elementdata != DEFAULTCAPACITY_EMPTY_ELEMENTdata) {
                             int newCapacity = ArraysSupport.newLength(oldCapacity,
                             minCapacity - oldCapacity,  
                             oldCapacity >> 1  );//��һ�δ�����˼�ǵ���һ�γ�ʼ��֮��length����10�Ȼ��ڶ������ݻ������������ʹelementdata����1.5��
                              return elementdata = Arrays.copyOf(elementdata, newCapacity);//��Arrays��copyOf�����������еĵ��µ�elementdata��
                  } else {
                            return elementdata = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
                            //��һ������ʱ��newһ����СΪDEFAULT_CAPACITY=10��Object���飬��Ϊ��һ�ε�ʱ��minCapacity=1��
                      
                  }
            }
	 	 * 
	 	 *֮����Ƿ�����
		 */
		ArrayList arrayList=new ArrayList();
		for(int i=0;i<10;i++) {
			arrayList.add(i);
		}
		for(int i=10;i<15;i++) {
			arrayList.add(i);
		}
		
		/*3.���ʹ�õ���ֱ��ָ����С�Ĺ�����new ArrayList(int);�����ʼλָ����С������
		 *   ���ݣ�ֱ������λelementdata��1.5��
		 * �ײ㣺
		 * ��ʼ����ʱ��ᴴ��һ����СΪ��ָ���Ĵ�С��elementdata,
		 * ���������2������3�μ���Ԫ��ʱ������ȥ����grow��Ȼ��grow��������
		 * if (oldCapacity > 0 || elementdata != DEFAULTCAPACITY_EMPTY_ELEMENTdata) {
		 *����ֱ�ӿ�ʼ����1.5��
		 */
		
		ArrayList arrayList2=new ArrayList(2);
		for(int i=0;i<10;i++) {
			arrayList2.add(i);
		}
	}
}
