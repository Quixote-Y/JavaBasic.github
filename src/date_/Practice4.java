package date_;
//�����ַ������ж϶��ٸ���д��ĸ�����ٸ�Сд��ĸ�����ٸ�����
public class Practice4 {

	public static void main(String[] args) {
	
		String str="213SDAsasAd1SDd";
		//��Ҫ���ַ���ÿ��Ԫ�ؽ��в�����תΪchar����
		char[] strc=str.toCharArray();
		int num=0,up=0,low=0;
		for(int i=0;i<strc.length;i++) {
			if('A'<=strc[i]&&strc[i]<='Z') {
				up++;
			}
			if('a'<=strc[i]&&strc[i]<='z'){
				low++;
			}
			if('0'<=strc[i]&&strc[i]<='9') {
				num++;
			}
		}
		String format=String.format("��д��ĸ%d����Сд��ĸ%d��������%d��",up,low,num);
		System.out.println(format);
		
	}
	
	
}
