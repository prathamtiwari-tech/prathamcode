package innerclasses.localclass;

import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class DataTranslator {	
	
	public static String getBookAsXml(int id, String title, double rating, int fbLikesCount, int tweetCount) {
		
		int a=0;
		
		//Local inner classes can’t be static.
		//No. Local inner classes can’t be declared with access modifiers.They can’t be private or protected or public.
		//We can’t use non-final local variables inside a local inner class.
		class Book {
			private int id;
			private String title;
			private double rating;
			private int fbLikesCount;
			private int tweetCount;
			int b=a+1;
			
			public Book (int id, String title, double rating, int fbLikesCount, int tweetCount) {
				this.id = id;
				this.title = title;
				this.rating = rating;
				this.fbLikesCount = fbLikesCount;
				this.tweetCount = tweetCount;
			}		
		}
			
		Book book = new Book(id, title, rating, fbLikesCount, tweetCount);
		
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("book", Book.class);
		StringWriter writer = new StringWriter();
		xstream.marshal(book,  new PrettyPrintWriter(writer));
		
		return writer.toString();
		//return xstream.toXML(book);		
	}
	
	public static void main(String[] args) {
		System.out.println(DataTranslator.getBookAsXml(2002, "Interface vs Abstract Class", 3.0, 5, 6));
	}
}

