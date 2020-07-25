package volatilepackage;

import java.util.concurrent.TimeUnit;

public class StopThread {

	private static boolean stop=false;
	private int i=0;
	
	public static void main(String a[]) throws InterruptedException{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!stop){
					System.out.println("In While");
				}
				
			}
		}).start();
		
		TimeUnit.SECONDS.sleep(1);
		stop=true;
	}
}
