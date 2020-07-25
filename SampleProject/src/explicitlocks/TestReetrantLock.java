package explicitlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReetrantLock {

	public static void main(String a[]){
		Lock myLock=new ReentrantLock();
		new Thread(new MyRunnable(myLock)).start();
		new Thread(new MyRunnable(myLock)).start();
		new Thread(new MyRunnable(myLock)).start();
	}
}

class MyRunnable implements Runnable{
	
	Lock myLock;
	
	public MyRunnable(Lock myLock) {
		this.myLock=myLock;
	}

	@Override
	public void run() {
		
		myLock.lock();
		
		for(int i=0;i<1000;i++){
			System.out.println(Thread.currentThread().getName() +" "+i);
		}
		
		myLock.unlock();
	}
	
}