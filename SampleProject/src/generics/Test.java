package generics;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String a[]){
		Integer b=3;
		List<Integer> i=(List<Integer>) go(new ArrayList<Number>());
	}
	
	static List<?> go(List<Number> number) {
		number.add(24.5);
		
		return number;
	}
}
