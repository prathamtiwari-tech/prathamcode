package volatilepackage;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					t.concurrentMethodWrong();
				}
			}).start();
		}

	}

	private static volatile long counter = 0;

	private void concurrentMethodWrong() {
		counter = counter + 5;
		System.out.println("Test");

		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");
		counter = counter - 5;
		System.out.println(counter);
	}

}
