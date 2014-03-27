package DP;

public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		
		LCS_(x.toCharArray(),y.toCharArray());
	}
	
	public static void LCS_(char[] x, char[] y){
		Integer dp[][] = new Integer[x.length+1][y.length+1];
		
		for(int i=0; i<=x.length;i++)
			dp[i][0] = 0;
		
		for(int i=0; i<=y.length;i++)
			dp[0][i] = 0;	
		
		
		for(int i=1; i<=x.length;i++)
			for(int j=1; j<=y.length;j++){
				if(x[i-1] == y[j-1])
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = (dp[i-1][j] >= dp[i][j-1])? dp[i-1][j] : dp[i][j-1];
			}
		
		String sub = new String();
		for(int i=x.length;i>1;i--)
			for(int j=y.length;j>1;j--)
				if(dp[i][j]>dp[i-1][j-1]){
					sub+=x[i-1];
					i--;
					j--;
				}	
		int i=0, j=sub.length()-1;
		char array[] = sub.toCharArray();
		while(i<j){
			char temp = array[i];
			array[i++] = array[j];
			array[j--] = temp;
		}
		
		sub = new String();
		for(i=0;i<array.length;i++)
			sub+=array[i];
		
		System.out.println(dp[x.length][y.length] + " substring = " + sub );
	}

}
