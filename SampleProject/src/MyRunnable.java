
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		try {
			this.doWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doWork() throws InterruptedException{
		
		for(int i=0;i<100;i++){
			Thread.yield();
			System.out.println(Thread.currentThread().getName() +" "+i);
			
		}
	}

}
