package interrupt;

//Java Program to illustrate the 
//concept of interrupt() method 
//while a thread does not stops working 
class MyClass extends Thread { 
	public synchronized void run() 
	{ 
		try { 
			for (int i = 0; i < 5; i++) { 
				System.out.println("Child Thread executing"); 

				// Here current threads goes to sleeping state 
				// Another thread gets the chance to execute 
				Thread.sleep(1000); 
			} 
		} 
		catch (InterruptedException e) { 
			System.out.println("InterruptedException occur"); 
		} 
	} 
} 

class MyInterrupt { 
	public static void main(String[] args) 
			throws InterruptedException 
	{ 
		MyClass thread = new MyClass(); 
		thread.start(); 

		// main thread calls interrupt() method on 
		// child thread 
		thread.interrupt(); 

		System.out.println("Main thread execution completes"); 
	} 
} 

