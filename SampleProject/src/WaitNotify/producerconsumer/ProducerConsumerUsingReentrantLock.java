package WaitNotify.producerconsumer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Simple Java program to demonstrate How to use wait, notify and notifyAll()
 * method in Java by solving producer consumer problem.
 * 
 * @author Javin Paul
 */
public class ProducerConsumerUsingReentrantLock {

	public static void main(String args[]) {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");

		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 10;
		
		Lock myLock=new ReentrantLock();
		Condition myCondition=myLock.newCondition();

		Thread producer = new ProducerReentrant(myLock,myCondition,buffer, maxSize, "PRODUCER");
		Thread consumer = new ConsumerReentrant(myLock,myCondition,buffer, maxSize, "CONSUMER");

		producer.start();
		consumer.start();

	}

}

/**
 * Producer Thread will keep producing values for Consumer to consumer. It will
 * use wait() method when Queue is full and use notify() method to send
 * notification to Consumer Thread.
 * 
 * @author WINDOWS 8
 *
 */
class ProducerReentrant extends Thread {
	private Queue<Integer> queue;
	private int maxSize;
	private Lock myLock;
	private Condition myCondition;

	public ProducerReentrant(Lock myLock, Condition myCondition,Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
		this.myLock=myLock;
		this.myCondition=myCondition;
		
	}

	@Override
	public void run() {
		while (true) {
			myLock.lock();
			try{
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, " + "Producer thread waiting for "
								+ "consumer to take something from queue");
						myCondition.await();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				Random random = new Random();
				int i = random.nextInt();
				System.out.println("Producing value : " + i);
				queue.add(i);
				myCondition.signalAll();
			}finally{
				myLock.unlock();
			}

		}
	}
}

/**
 * Consumer Thread will consumer values form shared queue. It will also use
 * wait() method to wait if queue is empty. It will also use notify method to
 * send notification to producer thread after consuming values from queue.
 * 
 * @author WINDOWS 8
 *
 */
class ConsumerReentrant extends Thread {
	private Queue<Integer> queue;
	private int maxSize;
	private Lock myLock;
	private Condition myCondition;

	public ConsumerReentrant(Lock myLock, Condition myCondition,Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
		this.myCondition=myCondition;
		this.myLock=myLock;
	}

	@Override
	public void run() {
		while (true) {
			
			try{
				myLock.lock();
				while (queue.isEmpty()) {
					System.out.println("Queue is empty," + "Consumer thread is waiting"
							+ " for producer thread to put something in queue");
					try {
						myCondition.await();
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
				System.out.println("Consuming value : " + queue.remove());
				myCondition.signalAll();
			}finally{
				myLock.unlock();
			}

		}
	}
}

