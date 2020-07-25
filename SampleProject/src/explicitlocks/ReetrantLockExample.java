package explicitlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample {

	public static void main(String a[]){
		Lock lock=new ReentrantLock();
		Condition con=lock.newCondition();
		List<Integer> number=new ArrayList<Integer>(10);
		
		ExecutorService ex=Executors.newFixedThreadPool(2);
		ReetrantLockExample re=new ReetrantLockExample();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.print("Inside first thread");
				re.getLockAndPrint(lock, con, number);
			}
		}).start();
		
	new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.print("Inside second thread");
				re.removeLockAndPrint(lock, con, number);
				
			}
		}).start();
		
	}
	
	public void getLockAndPrint(Lock lock,Condition con,List<Integer> number){
		
		while(true){
			try {
				System.out.print("Getting LOck");
				lock.lock();
			
			while(number.size()==10){
				try {
					System.out.print("Going to wait for remove");
					con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Random random = new Random();
			int i = random.nextInt();
			
				System.out.print("Producing value : " + i);
				number.add(1);
				con.signalAll();
			}finally{
				System.out.print("Inside finally");
				lock.unlock();
			}
		}
		
	}
	
	public void removeLockAndPrint(Lock lock,Condition con,List<Integer> number){
		while(true){
			try {
				System.out.print("Getting LOck");
				lock.lock();
			while(number.isEmpty()){
					System.out.print("Going to wait for add");
					try {
						con.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			System.out.println("Consuming value : " + number.remove(0));
			con.signalAll();
			}finally{
				System.out.print("Inside finally");
				lock.unlock();
			}
		}
		
		
		
	}
}
