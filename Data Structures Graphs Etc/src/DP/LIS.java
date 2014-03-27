package DP;

public class LIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {10,20,1,2,3,4,30,2};
		
		_LIS2(a);	

	}
	
	public static void _LIS(int[] a){
		int dp[] = new int[a.length];
		dp[0]=1;
		System.out.print(dp[0]+" ");
		for(int i=1;i<a.length;i++){
			dp[i] = dp[i-1];
			int maxCount=1;
			for(int j=0;j<i;j++){
				if(dp[j]==dp[i]){
					if(a[j]<a[i])
						maxCount++;
					if(maxCount>dp[i])
						dp[i]=dp[i-1]+1;
				}
			}
			
			System.out.print(dp[i]+" ");
		}
		//System.out.println(dp[a.length-1]);
	}
	
	public static void _LIS2(int[] a){
		int dp[] = new int[a.length];
		for(int i=0;i<a.length;i++)
			dp[i]=1;
		for(int i=1;i<a.length;i++){
			int max = 1;
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					if(dp[j]>max)
						max=dp[j];
					dp[i]=1+max;
				}	
						
			}		
			
			System.out.print(dp[i]+" ");
		}
	}
	

}
