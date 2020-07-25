package Sorts;

public class SelectionSortPratham {

	public static void main(String ap[]){
		
		SelectionSortPratham ss=new SelectionSortPratham();
		
		Integer ar[]={2,5,6,1,0};
		ss.selectionSort(ar);
		
	}
	
	public <T extends Comparable<T>> void selectionSort(T[] ar){
		int length=ar.length;
		for(int i=0;i<length-1;i++){
			
			int min=i;
			
			for(int j=i+1;j<length;j++){
				if(ar[min].compareTo(ar[j])<0){
					min=j;
				}
			}
			
			if(min!=i){
				T temp=ar[min];
				ar[min]=ar[i];
				ar[i]=temp;
			}
			
		}
		
		print(ar);
		
	}
	
	public <T extends Comparable<T>> void print(T[] ar){
		
		for(int j=0;j<ar.length;j++){
			System.out.print(ar[j]);
		}
		
	}
}
