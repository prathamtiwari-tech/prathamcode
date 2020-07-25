package WaitNotify.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Test<T> {
	
	Class<T> myClass;
	
	List<T> list=new ArrayList<T>();

	public Class<T> getMyClass() {
		return myClass;
	}

	public void setMyClass(Class<T> myClass) {
		this.myClass = myClass;
	}
	
	public static void main(String a[]){
		Test<java.lang.Long> b=new Test<java.lang.Long>();
		b.list.add(1l);
		System.out.println(b.list.get(0));
	}

}
