package DP;

public class CoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int NXNFindingAllPathsRec(int i, int j){
		if(i==1 || j==1)
			return 1;
		return NXNFindingAllPathsRec(i-1,j) + NXNFindingAllPathsRec(i,j-1);
	}
	
	/*DP Algo for finding all paths in a NxN grid moving only in two directions */
	public static int NXNFindingAllPathsDP(int m, int n){
		int[][] dp = new int[m][n];
		dp[0][0]=0;
		for(int i=0;i<m;i++)
			dp[i][0]=1;
		for(int i=0;i<n;i++)
			dp[0][i]=1;
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++)
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
		}
		
		return dp[m-1][n-1];
		
		
	}
}
