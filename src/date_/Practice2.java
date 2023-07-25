package date_;

//输入用户名，密码，邮箱，输入正确注册成功，输入错误返回异常
//用户名长度2--4
//密码长度为6且全是数字
//邮箱中包含@和.且@在.前面 
public class Practice2 {

	public static void main(String[] args) {

		String name="yan";
		String sec="212321";
		String email="12@qq.com";
		try {
			
		register(name,sec,email);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	// 注册作为一个方法，判断3个参数合格与否，输出对应异常
	//参数为null考虑
	public static void register(String name,String sec,String email) {
		if(name==null||sec==null||email==null) {
			throw new RuntimeException("参数不能为空");
		}
		if(!(name.length()>=2&&name.length()<=6)) {
			throw new RuntimeException("输入姓名长度不对！");
		}
		
		
		if(!(isDigital(sec)&&sec.length()==6)) {
			throw new RuntimeException("输入密码格式不正确！");
		}
		
		if(!(isEmial(email))) {
			throw new  RuntimeException("输入邮箱格式异常");
		}
		
		System.out.println("注册成功！");
	}
	
	
	
	
	//写个方法来检查字符串是不是数字
	public static boolean isDigital(String sec) {
		//这是我自己想的方法
//		try {
//			Integer.parseInt(sec);
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//		return true;
		
		//这是讲的
		char[] chars=sec.toCharArray();
		for(int i=0;i<sec.length();i++) {
			if(chars[i]<'0'||chars[i]>'9') {
				return false;
			}
		}
		return true;
	}
	//写个方法来检查邮箱格式
	public static boolean isEmial(String email) {
		int indexof1=email.indexOf('@');
		int indexof2=email.indexOf('.');
		if(!(indexof1<indexof2 && indexof1>=0 && indexof2>=0)) {
			return false;
		}
		return true;
	}
}
