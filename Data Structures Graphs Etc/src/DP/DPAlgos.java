package DP;

import java.util.Arrays;

public class DPAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long i=5;
		System.out.print(i/2.0);
	}

	//rod cutting
    public static int rodCutting(int[] price, int length){
    	int[] bestPrice =  new int[price.length+1];
    	for(int i=1;i<=length;i++){
    		bestPrice[i]=price[i];
    		for(int j=0;j<=i;j++){
    			int max=bestPrice[j]+bestPrice[i-j];
    			if(max>bestPrice[i])
    				bestPrice[i]=max;
    		}
    	}
    	return bestPrice[length];
    	
    	
    }
	
	//matrix multiplication
	
    /* Coin Change Problem1 - given a set of coins and a sum S, in how many ways can the coins add up to S?
	 * The solution is to say take one particular coin and find out in how many ways can we add up to S-value of that coin(thus including the coin)
	 * and in how many ways can we add up to S if we do not include that coin
	 * In other words, for any particular coin, there are 2 choices - either include the coin or dont include the coin and the solution is the sum of the
	 * solutions to these. Thus the recursion would be -
	 * dp(i,S) = dp(i,S) + dp(i-1, S-value(i-1)) where S = sum  
	 * there are two states here - the value of coins as the columns and the sum as the rows for DP
	 * */
    public static int coinChange(int[] coins, int sum){
    	int dp[][] = new int[sum+1][coins.length];
    	
    	for(int i=0;i<coins.length;i++)
    		dp[0][i]=1;
    	
    	for(int i=1;i<=sum;i++){
    		for(int j=0;j<coins.length;j++){
    			//find the sol for including the coin coin[j];
    			int x=0;
    			if(i-coins[j]>=0)
    			  x = dp[i-coins[j]][j];
    			
    			//find the solution for excluding the coin
    			int y=0;
    			if(j>=1)
    		    	y = dp[i][j-1];
    			dp[i][j] = Math.min(x, y);
    		}
    	}
    	return dp[sum][coins.length-1];
    }
    
    /* Coin Change Problem2 - given a set of coins and a sum S, in how many minimum ways can the coins add up to S?
	 */
    public static int coinChange2(int[] coins, int sum){
    	int[] change = new int[sum+1];
    	change[0] = 0;
    	change[1] = 1;
    	
    	for(int i=2;i<=sum;i++){
    		int  min = (int)Double.POSITIVE_INFINITY;
    		for(int j=coins.length-1;j>=0;j--){    			
    			if(i>=coins[j]){
    				if(change[i-coins[j]]+1 < min)
    					min = change[i-coins[j]]+1;
    			}
    			else
    				break;
    		}
    		change[i] =  min;
    	}
    	return change[sum];
    }
    
	
    //LCS with DP
    /* dp[i][j] = {if x[i]=y[j] then dp[i][j]=dp[i-1][j-1]+1}
     *             else
     *                dp[i][j] = max( dp[i-1][j], dp[i][j-1])
	*/
    public static int LCS(char[] x, char[] y){
    	int[][] dp = new int[x.length+1][y.length+1];
    	
    	for(int i=0;i<=x.length;i++){
    		for(int j=0;j<=y.length;j++){
    			if(i==0 || j==0)
    				dp[i][j]=0;
    			else if(x[i-1]==y[j-1])
    				dp[i][j]=dp[i-1][j-1]+1;
    			else
    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    		}
    	}
    	System.out.println(dp[x.length][y.length]);
    	return dp[x.length][y.length];    	
    }
    
    /*LPSubString
     * */
    public static int LPSubstring(char[] x){
    	int[][] dp = new int[x.length+1][x.length+1];
    	int max=0, row=0, col=0;
    	char[] y = new char[x.length];
    	int j=0;
    	System.out.println(x[0]);
    	
    	//reverse the string
    	for(int i=x.length-1;i>=0;i--)
    		y[j++]=x[i];
    	
    	for(int i=0;i<=x.length;i++){
    		for(j=0;j<=y.length;j++){
    			if(i==0 || j==0)
    				dp[i][j]=0;
    			else if(x[i-1]==y[j-1]){
    				dp[i][j]=dp[i-1][j-1]+1;
    				if(max<dp[i][j]){
    					max=dp[i][j];
    					row=i-1;
    					col=j-1;
    				}
    				//else
    					//palindrome="";
    			}
    			else
    				dp[i][j]=0;
    		}
    	}
    	System.out.println(max + " " + row + " "  + col);
    	int count=max;
    	while(count>0){
    		System.out.print(x[row]);
    		row--;
    		count--;
    	}
    	return max;    	
    }
    
    //LIS with DP
    //dp(i) = { 1 + Max ( dp(j) ) } where j < i and arr[j] < arr[i] 
	public static int LIS(int[] arr){
		int[] lisArr = new int[arr.length];
		lisArr[0]=1;
		for(int i=1;i<arr.length;i++){
			lisArr[i]=lisArr[i-1];
			for(int j=i-1;j>=0;j--){
				if(lisArr[j]>=lisArr[i]){
					if(arr[j]<arr[i]){
						lisArr[i]++;
						break;
					}	
				}
			}
		}
		return lisArr[arr.length-1];
	}
	
	//longest palindrom subsequence
	
	//edit distance
    
    //Maximum size square sub-matrix with all 1s
	// S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
    public static void maxSizeSquareSubMatrix(int[][] M){
    	int row = M.length, col = M[0].length;
    	int[][]res = new int[row][col];
    	for(int i=0;i<col;i++)
    		res[0][i] = M[0][i];
    	for(int i=0;i<col;i++)
    		res[i][0] = M[i][0];
    	int size=1, x=0,y=0;
    	for(int i=1;i<row;i++){
    		for(int j=1;j<col;j++){
    			if(M[i][j]==1){
    				int min=res[i-1][j-1];
    				if(min>res[i-1][j])
    					min=res[i-1][j];
    				if(min>res[i][j-1])
    					min=res[i][j-1];
    				res[i][j]=min+1;
    				if(size<min){
    				    x=i;y=j;
    					size=min;
    				}	
    			}
    			else
    				res[i][j] = 0;
    		}
    	}
    	
    	System.out.println(size + " " + x + " " +y);    	
    }
	
	
}
