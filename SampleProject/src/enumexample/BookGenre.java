package enumexample;

public enum BookGenre {

	BIOGRAPHY(22), HORROR(10);

	private int minAgeToRead;

	BookGenre(int ageToRead) {
		this.minAgeToRead = ageToRead;
	}
	
	public int getMinAgeToRead(){
		return minAgeToRead;
	}

	public static void main(String app[]) {

		for (BookGenre bookGenre : BookGenre.values()) {
			System.out.print("\nName: " + bookGenre); //toString
            System.out.print(", name(): " + bookGenre.name());
            System.out.print(", Ordinal: " + bookGenre.ordinal());
            System.out.print(", Declaring Class: " + bookGenre.getDeclaringClass());	
            System.out.print(", compareTo(HORROR): " + bookGenre.compareTo(BookGenre.HORROR));
            System.out.print(", equals(HORROR): " + bookGenre.equals(BookGenre.HORROR));
            System.out.print(", minAgeToRead: " + bookGenre.getMinAgeToRead());
		}
	}
}
