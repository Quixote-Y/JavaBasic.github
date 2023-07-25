package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//����
public class Practice5 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		News new1=new News("�¹�ȷ�ﲡ�����ɷ������ٷ�ӡ�Ƚ���ͽ����ӡ�ʥԡ�������ڵ���");
	    News new2=new News("����ͻȻ����2����ǰ�����㻹�����������һ���Ͻ�����");
	    List list=new ArrayList();
	    list.add(new1);
	    list.add(new2);
	    Collections.reverse(list);//daoxu
	    for(Object t:list) {
	    	
	    	if(!(t instanceof News)) {
	    		System.out.println("list worng");
	    		System.exit(0);
	    	}
	    	String tittle=((News)t).getTittle();
	    	if(tittle.length()>15) {
	    		tittle=tittle.substring(0, 15)+"...";
	    	}
	    	System.out.println(tittle);
	    }
	}
}
class News{
	private String tittle;
	private String content;
	public News(String tittle) {
		super();
		this.tittle = tittle;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return tittle;
	}
}




