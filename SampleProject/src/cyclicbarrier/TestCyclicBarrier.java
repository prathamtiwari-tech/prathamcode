package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3, new FinalAction());

		ExecutorService es = Executors.newFixedThreadPool(3);

		es.submit(new Passenger("Test1", cb));
		es.submit(new Passenger("Test2", cb));
		try {
			System.out.println("Wating for other thread");
			cb.await();
			System.out.println("Processing is done");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Barrier Completes Starting new Barrier");
		
		es.submit(new Passenger("Test3", cb));
		es.submit(new Passenger("Test4", cb));
		System.out.println("Wating for other thread");
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Processing is done");
		
		es.shutdown();

	}

}

class FinalAction implements Runnable {

	@Override
	public void run() {
		System.out.println("Final Action");

	}

}

class Passenger implements Runnable {

	String name;
	CyclicBarrier cb;

	Passenger(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("Thread name is " + name);
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Wating for other thread");
			cb.await();
			System.out.println("Processing is done");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}