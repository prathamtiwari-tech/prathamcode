package Sorts;

public class InsertionSortPratham {

	public static void main(String a[]){
		
		Integer[] ar={ 10, 3, 1, 5, 6, 2, 8, 4 };
		InsertionSortPratham insertionSort=new InsertionSortPratham();
		insertionSort.insertionSort(ar);
	}
	
	public <T extends Comparable<T>> void insertionSort(T[] ar) {

		int length = ar.length;
		for (int i = 1; i < length - 1; i++) {

			T element = ar[i];
			int index = i;
			while (index > 0 && ar[index - 1].compareTo(element) > 0) {
				ar[index] = ar[index - 1];
				index = index - 1;
			}

			ar[index] = element;

		}
		
		for (int j = 0; j < length - 1; j++) {
			System.out.println(ar[j]);
		}

	}
}
