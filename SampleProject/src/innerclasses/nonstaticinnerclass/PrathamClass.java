package innerclasses.nonstaticinnerclass;


public class PrathamClass implements PrathamInterface{

	@Override
	public int go() {
		// TODO Auto-generated method stub
		return 0;
	}
	private static int a=0;
	 private class PrathamInnerClass implements PrathamInnerInterface{
		 public int go() {
			 
			 PrathamClass.this.go();
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public void print() {
			
		}
		
	}

	 public static void main(String ap[]){
		 
		 PrathamClass pi=new PrathamClass();
		 PrathamInnerInterface prw=pi.new PrathamInnerClass();
		 
		 
		 PrathamInterface.PrathamInnerInterface pr=pi.new PrathamInnerClass();
	 }
}
