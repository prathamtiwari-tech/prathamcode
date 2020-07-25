package executorframework.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestFuture {

	public static void main(String a[]) throws InterruptedException, ExecutionException{
		
		
		ExecutorService es=Executors.newFixedThreadPool(10);
		
		Future<Integer> future=es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int a=0;
				for(int i=0;i<100000000;i++){
					a=a+i;
				}
				return a;
			}
			
		});
		
		Future<Integer> future1=es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int a=0;
				for(int i=0;i<100000000;i++){
					a=a+i;
				}
				Thread.sleep(10000);
				return a;
			}
			
		});
		//es.shutdown();
		if(!es.awaitTermination(1, TimeUnit.SECONDS)){
			System.out.print("Terminatingsadddddddddddddddddddddddddddddddddddddddd");
			es.shutdownNow();
		}
		
		
		System.out.print("sdsdsdsd   "+  future.get());
		System.out.print("sdsdsdsd   "+future1.get());
		
		
		//Invoke ALL example
		
		
		
		
	}
}

