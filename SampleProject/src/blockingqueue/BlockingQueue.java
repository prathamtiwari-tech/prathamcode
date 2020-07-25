package blockingqueue;

import java.util.*;

public class BlockingQueue {

	private List<String> queue = new LinkedList<String>();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			System.out.println("Wait enqueue");
			wait();
		}
		if (this.queue.size() == 0) {
			System.out.println("Notify enqueue");
			notifyAll();
		}
		System.out.println("Adding item "+item);
		this.queue.add((String) item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			System.out.println("Wait dequeue");
			wait();
		}
		if (this.queue.size() == this.limit) {
			System.out.println("Notify dequeue");
			notifyAll();
		}
		String item=this.queue.remove(0);
		System.out.println("Removing item "+item);
		return item;
	}
	
	public static void main(String a[]){
		BlockingQueue queue=new BlockingQueue(10);
		
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<50;i++){
					try {
						queue.enqueue("Pratham "+i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<50;i++){
					try {
						System.out.println(queue.dequeue());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
	}
}