package array;

import java.util.Arrays;
import java.util.Comparator;

//定制排序
/*
 * 有4本书，有name 和price属性，按price排序
 * 
 */
public class Practice1 {

	public static void main(String[] args) {
		Book[] books= {
				new Book("红楼梦",100),
				new Book("金瓶梅",90),
				new Book("文艺青年",5),
				new Book("呐喊",300)
		};
		priceSort(books,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				Integer i1=(Integer)o1;
				Integer i2=(Integer)o2;
				return i1-i2;
				//return i2-i1;
			}
		});
		System.out.println(Arrays.toString(books));
	}
	public static void priceSort(Book books[],Comparator c) {
		Book tmp=new Book("",0);
		for(int i=0;i<books.length;i++) {
			for(int j=0;j<books.length;j++) {
				if(c.compare(books[i].price, books[j].price)>0) {
					tmp=books[j];
					books[j]=books[i];
					books[i]=tmp;
				}
			}
		}
		
	}
}

class Book{
	String name;
	int price;
	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]"+"\n";
	}
	
}
