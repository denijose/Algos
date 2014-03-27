package BitWise;

public class IsMultipleOf3 {
	
	public boolean isMultipleOf3(int n){
		
		//while(n){
			if((n & 1)== 1)
				System.out.println("1st bit set");
			
			n = n>>1;
			
			if( (n & 1) == 1 )
				System.out.println("2nd bit set");
			return true;
			
		//}
		
	}
}
