package generics.boundparameters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericBounds<T extends ArrayList & List & Serializable> {

	public static void main(String a[]){
		
		GenericBounds<ArrayList> obj2=new GenericBounds<>();
		
		
	}
	
	public void go(T list){
		list.add("Pratham");
	}
}
