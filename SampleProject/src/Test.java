
public class Test {

	public static void main(String ar[]) throws InterruptedException{

		Runnable r=new MyRunnable();
		Thread t1=new Thread(r);
		t1.setName("Pratham");
		
		Thread t2=new Thread(r);
		t2.setName("Sakshi");
		
		t1.start();
		t2.start();
		
	}
	
}
