package DP;

public class RecAlgosOfDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int coins[] = {1,2,3};
		System.out.println(coinChange(coins, coins.length-1, 4));
		
	}
	
	//LCS recursiv solution - runtime is expo
	public static double LCS(char[] x, char[] y, int i, int j){
		if(i<0 || j<0)
			return 0;
		
		if(x[i]==y[j])
			return 1 + LCS(x,y,i-1,j-1);
		else
			return Math.max(LCS(x,y,i-1,j), LCS(x,y,i,j-1));
	}
	
	
	//LIS recursion way with memoization
		public static int[] lisArr = null;
		public static void LISRec(int[] arr,int start){
			if(lisArr==null){
			   lisArr = new int[arr.length+1];
			}
			if(start==arr.length-1){
				lisArr[start]=1;
				return;
			}
			
			for(int i=start;i<arr.length;i++){
				LISRec(arr,i+1);
				int max=lisArr[i+1];
				for(int j=i+1;j<arr.length;j++){
					if(lisArr[j]==max){
						if(arr[j]>arr[i]){
							max++;
							break;
						}
					}					
				}
				lisArr[i]=max;
			}		
		}
	
	//LPS  given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB”
	//“BBBBB” and “BBCBB” are also palindromic subsequences
	public static double LPS(char[] x, int i, int j){
		if(i==j)
			return 1;
		if(j<i)
			return 0;
		if(x[i]==x[j])
			return 2 + LPS(x,i+1,j-1);
		else
			return Math.max(LPS(x,i+1,j), LPS(x,i,j-1));		
	}
	
	/* LPSubstring
	 * */

	
	//rod cutting	
	public static int rodCutting(int[] p, int length){
		if(length==0)
			return 0;
		int max=p[length];
		for(int i=1;i<=length;i++){
			int price=p[i]+rodCutting(p, length-i);
			if(max<price)
				max=price;
		}
		return max;
	}
	//rodcutting with memoization	
	public static int rodCuttingMemo(int[] p, int length,int[] bestPrices){
		if(length==0)
			return 0;
		int max=p[length];
		for(int i=1;i<=length;i++){
			int price=bestPrices[length-i];
			if(price==0)
			  price=p[i]+rodCutting(p, length-i); 
			if(max<price){
				max=price;
				bestPrices[i]=max;
			}
		}
		return max;
	}
	//matrix multiplication
	
	/* Coin Change Problem - given a set of coins and a sum S, in how many ways can the coins add up to S?
	 * The solution is to say take one particular coin and find out in how many ways can we add up to S-value of that coin(thus including the coin)
	 * and in how many ways can we add up to S if we do not include that coin
	 * In other words, for any particular coin, there are 2 choices - either include the coin or dont include the coin and the solution is the sum of the
	 * solutions to these. Thus the recursion would be -
	 * dp(i,S) = dp(i,S) + dp(i-1, S-value(i-1)) where S = sum  
	 * */
	public static int coinChange(int[] coins, int coinIndex ,int S){
		if(S==0)
			return 1;
		if(S<0)
			return 0;
		if(coinIndex<0 && S>0)
			return 0;
		
		return coinChange(coins,coinIndex-1,S) + coinChange(coins,coinIndex,S-coins[coinIndex]);		
	}
	

		

	//Maximum size square sub-matrix with all 1s recursive
	

}
