package threadlocal;

public class InheritableThreadLocalExample {

	// Java program to illustrate parent thread, ThreadLocal variable
	// by default not available to child thread

	public static void main(String[] args) {
		ParentThread gfg_pt = new ParentThread();
		gfg_pt.start();
	}

}

class ParentThread extends Thread {
	
	//If we change InheritableThreadLocal to ThreadLocal then value is not visible to child thread
	public static InheritableThreadLocal gfg_tl = new InheritableThreadLocal();

	public void run() {

		// setting the new value
		gfg_tl.set("parent data");

		// returns the ThreadLocal value associated with current thread
		System.out.println("Parent  Thread Value :" + gfg_tl.get());

		ChildThread gfg_ct = new ChildThread();
		gfg_ct.start();
	}
}

class ChildThread extends Thread {
	public void run() {

		// returns the ThreadLocal value associated with current thread
		System.out.println("Child Thread Value :" + ParentThread.gfg_tl.get());
		/*
		 * null (parent thread variable thread local value is not available to
		 * child thread )
		 */
	}
}
