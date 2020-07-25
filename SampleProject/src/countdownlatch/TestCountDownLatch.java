package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {

	public static void main(String a[]){
		CountDownLatch latch=new CountDownLatch(3);
		ExecutorService es=Executors.newFixedThreadPool(3);
		es.submit(new DependentTask(latch));
		es.submit(new DependentTask(latch));
		es.submit(new DependentTask(latch));
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Dependent Service Initialized ");
		
	}
	
	
}

class DependentTask implements Runnable{
	private CountDownLatch latch;
	public DependentTask(CountDownLatch latch){
		this.latch=latch;
	}

	@Override
	public void run() {
		System.out.println("Dependent Task ");
		latch.countDown();
		System.out.println("Task is done");
	}
	
}
