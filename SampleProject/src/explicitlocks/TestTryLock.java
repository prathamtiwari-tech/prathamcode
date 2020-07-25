package explicitlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock {

	public static void main(String[] args) {
		Lock myLock=new ReentrantLock();
		new Thread(new TryRunnable(myLock)).start();
		new Thread(new TryRunnable(myLock)).start();
		new Thread(new TryRunnable(myLock)).start();
	}

}

class TryRunnable implements Runnable{

	Lock myLock;
	
	public TryRunnable(Lock myLock) {
		this.myLock=myLock;
	}
	
	@Override
	public void run() {
		boolean isLockedAcquired=myLock.tryLock();
		
		if(isLockedAcquired){
			try{
				for(int i=0;i<100;i++){
					System.out.println(Thread.currentThread().getName() +" "+i);
				}
			}finally{
				myLock.unlock();
			}
			
		}else{
			
			for(int i=0;i<10;i++){
				System.out.println("Doing Something else  "+ Thread.currentThread().getName() +" "+i);
			}
			run();
		}
	}
	
}
