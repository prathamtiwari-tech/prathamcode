package atomicvariable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicVariableExample {
	
	public static void main(String a[]){
		ExecutorService es=Executors.newFixedThreadPool(100);
		
		MyIdIncremental incremtn=new MyIdIncremental();
		for(int i=0;i<1000;i++){
			es.submit(incremtn);
		}
	}

	
	
	
}

class MyIdIncremental implements Runnable{

	private AtomicLong id=new AtomicLong();
	
	@Override
	public void run() {
		
		System.out.println(getNewId());
	}
	
	public long getNewId(){
		return id.getAndIncrement();
	}
	
}
