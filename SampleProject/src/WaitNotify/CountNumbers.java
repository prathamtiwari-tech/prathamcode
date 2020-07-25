package WaitNotify;

public class CountNumbers implements Runnable {
	int total=0;
	@Override
	public void run() {
		synchronized(this){
			for(int i=0;i<1000;i++){
				total=i+total;
			}
			notify();
		}
	}

	
}
