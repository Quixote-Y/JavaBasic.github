package enumTest;

public class Test {

	public static void main(String[] args) {
		Week[] week=Week.values();
		System.out.println("==所有星期的信息如下==");
		for(Week t:week) {
			System.out.println(t.getName());
			System.out.println(t.toString());
		}
	}
}
enum Week{
	MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期天");
	
	private Week(String string) {
		// TODO 自动生成的构造函数存根
		this.name=string;
	}

	private String name;

	public String getName() {
		return name;
	}
}