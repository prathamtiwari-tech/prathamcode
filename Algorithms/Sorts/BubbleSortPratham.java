package Sorts;

public class BubbleSortPratham {

	public static void main(String a[]) {

		Integer[] ar = { 10, 3, 1, 5, 6, 2, 8, 4 };
		BubbleSortPratham sort = new BubbleSortPratham();
		sort.bubbleSort(ar);
	}

	public <T extends Comparable> void bubbleSort(T[] ar) {
		int length = ar.length;

		for (int j = 0; j < length - 1; j++) {
			boolean isSwapped = false;
			for (int i = 0; i < length - j - 2; i++) {

				if (ar[i].compareTo(ar[i + 1]) < 0) {
					T number = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = number;
					isSwapped = true;
				}
			}

			if (!isSwapped) {
				break;
			}
		}

		for (int j = 0; j < length - 1; j++) {
			System.out.println(ar[j]);
		}
	}
}
