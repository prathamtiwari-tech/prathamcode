package innerclasses.staticmemberclass;

public class TestPrathamNonStatic {
	
	private static int a=0;
	private int b=0;
	public static class StaticMemberClass{
		private static int c=a+1;
	}

}
