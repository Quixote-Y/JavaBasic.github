package collection;

import java.util.LinkedHashSet;

public class Practice4 {

	public static void main(String[] args) {
		LinkedHashSet li=new  LinkedHashSet();
		li.add(new Car("°ÂÍÐ",1000));
		li.add(new Car("°ÂµÏ",300000));
		li.add(new Car("·¨À­Àû",1000000));
		li.add(new Car("°ÂµÏ",300000));
		li.add(new Car("±£Ê±½Ý",70000000));
		li.add(new Car("°ÂµÏ",300000));
		System.out.println(li);
	}
}
class Car{
	private String name;
	private double price;
	public Car(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
	
}