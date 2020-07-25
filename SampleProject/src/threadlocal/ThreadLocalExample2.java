package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample2 {

	public static void main(String a[]){
		
		ExecutorService es=Executors.newCachedThreadPool();
		
		MyRunnableExample myRunnable=new MyRunnableExample();
		
		es.submit(myRunnable);
		
		es.submit(myRunnable);
		
		es.submit(myRunnable);
		es.shutdown();
	}
}

class MyRunnableExample implements Runnable{

	ThreadLocal<Double> threadLocal=new ThreadLocal<Double>();
	
	@Override
	public void run() {
		
		threadLocal.set(Math.random() * 100D);
		
		 try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	        }
		
		System.out.println(threadLocal.get());
	}
	
}
