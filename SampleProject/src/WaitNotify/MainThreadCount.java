package WaitNotify;

public class MainThreadCount {

	public static void main(String a[]){
		CountNumbers runnable=new CountNumbers();
		Thread threadB=new Thread(runnable);
		threadB.start();
		
		synchronized(threadB){
			System.out.println("Waiting to Thread B to complete");
			try {
				threadB.wait();
			} catch (InterruptedException e) {
				System.out.println(runnable.total);
			}
			
			System.out.println(runnable.total+"----end");
		}
	}
}
