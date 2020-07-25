package blockingqueue;

import java.util.LinkedList;
import java.util.List;

public class TestBlockingQueue {

	List<String> list=new LinkedList<String>();
	private static int limit=10;
	
	public synchronized void enqueue(String item) throws InterruptedException{
		if(list.size()==limit){
			wait();
		}
		
		if(list.size()==0){
			notifyAll();
		}
		
	}
	
	public synchronized String dequeue() throws InterruptedException{
	
		if(list.size()==0){
			wait();
		}
		
		if(list.size()==limit){
			notifyAll();
		}
		
		return list.get(0);
	}
}
