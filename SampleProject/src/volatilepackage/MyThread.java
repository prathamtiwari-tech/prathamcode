package volatilepackage;

/*Since Java 5 the volatile keyword guarantees more than just the reading from and writing to main memory of variables.

If Thread A writes to a volatile variable and Thread B subsequently reads the same volatile variable, then all variables visible to Thread A 
before writing the volatile variable, will also be visible to Thread B after it has read the volatile variable.

Developers may use this extended visibility guarantee to optimize the visibility of variables between threads. 
Instead of declaring each and every variable volatile, only one or a few need be declared volatile.
*/
public class MyThread {

	private static int Shared_Variable = 0;

	public static void main(String[] args) {
		new ReadOnChange().start();
		new Writer().start();
	}

	static class ReadOnChange extends Thread {
		@Override
		public void run() {
			int local_value = Shared_Variable;
			while (local_value < 5) {
				if (local_value != Shared_Variable) {
					System.out.println("Value changed for Shared_Variable :"
							+ Shared_Variable);
					local_value = Shared_Variable;
				}
			}
			System.out.println("Local Value "+local_value);
		}
	}

	static class Writer extends Thread {
		@Override
		public void run() {

			int local_value = Shared_Variable;
			while (Shared_Variable < 5) {
				System.out.println("changing the Shared_Variable to "
						+ (local_value + 1));
				Shared_Variable = ++local_value;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
