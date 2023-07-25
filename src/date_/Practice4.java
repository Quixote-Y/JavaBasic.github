package date_;
//输入字符串，判断多少个大写字母，多少个小写字母，多少个数字
public class Practice4 {

	public static void main(String[] args) {
	
		String str="213SDAsasAd1SDd";
		//需要对字符串每个元素进行操作，转为char数组
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
		String format=String.format("大写字母%d个，小写字母%d个，数字%d个",up,low,num);
		System.out.println(format);
		
	}
	
	
}
