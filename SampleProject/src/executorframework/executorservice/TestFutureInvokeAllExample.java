package executorframework.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


//TO invoke submit method in one go and if if all task are not completed within a time then it will automatically
// cancelled all task which are not completed yet.

//If timout expire for invoke all method then any incomplete task will be cancelled and it is taken care implicitly by invokeall method.
public class TestFutureInvokeAllExample {

	public static void main(String a[]) throws InterruptedException, ExecutionException{
		
		List<Callable<Integer>> listOfCallable=new ArrayList<Callable<Integer>>();
		
		listOfCallable.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int a=0;
				for(int i=0;i<100000000;i++){
					a=a+i;
				}
				return a;
			}
			
		});
		listOfCallable.add(new Callable<Integer>() {
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
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		List<Future<Integer>> futureList=es.invokeAll(listOfCallable, 2, TimeUnit.SECONDS);
		
		for(Future<Integer> f:futureList){
			if(f.isCancelled()){
				System.out.println("This taks is cancelled");
			}else{
				System.out.println(f.get());
			}
			
		}
		
		es.shutdown();
		
	}
}
