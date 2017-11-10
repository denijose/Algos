/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
	
	private int[] stampDenominations;
	
    public StampDispenser(int[] stampDenominations)
    {
    	this.stampDenominations = stampDenominations;
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	int[] stamps = new int[request+1];
    	stamps[0] = 0;
    	stamps[1] = 1;
    	
    	for(int i=2;i<=request;i++){
    		int  min = (int)Double.POSITIVE_INFINITY;
    		for(int j=stampDenominations.length-1;j>=0;j--){    			
    			if(i>=stampDenominations[j]){
    				if(stamps[i-stampDenominations[j]]+1 < min)
    					min = stamps[i-stampDenominations[j]]+1;
    			}
    			else
    				break;
    		}
    		stamps[i] =  min;
    	}
    	return stamps[request];
    }
    
    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        System.out.print( stampDispenser.calcMinNumStampsToFillRequest(7));
    }
}
