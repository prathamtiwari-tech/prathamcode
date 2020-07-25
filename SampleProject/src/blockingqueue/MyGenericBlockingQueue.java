package blockingqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyGenericBlockingQueue<T> {

	List<T> list=new LinkedList<T>();
	private int capacity;
	
	public MyGenericBlockingQueue(int capacity){
		this.capacity=capacity;
	}
	
	public synchronized void enqueue(T object) throws InterruptedException{
		while(list.size()==capacity){
			System.out.println("Capacity is full");
			wait();
		}
		System.out.println("Item added to list "+object);
		list.add(object);
		notifyAll();
	}
	
	public synchronized void dequeue() throws InterruptedException{
		while(list.size()==0){
			System.out.println("No capacity");
			wait();
		}
		System.out.println("Item Deqeued :" +list.get(0));
		
		list.remove(0);
		notifyAll();
	}
	
	public static void main(String a[]) throws InterruptedException{
		MyGenericBlockingQueue<Integer> myGenericBlockingQueue=new MyGenericBlockingQueue<Integer>(10);
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				for(int a=0;a<100;a++){
					try {
						myGenericBlockingQueue.enqueue(a);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				for(int a=0;a<100;a++){
					try {
						myGenericBlockingQueue.dequeue();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		es.shutdown();
		
		if(!es.awaitTermination(10, TimeUnit.SECONDS)){
			System.out.println("Shut down now is invoked");
			es.shutdownNow();
		}
		
		
	}
}
