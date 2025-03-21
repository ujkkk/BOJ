class Solution {
    public int solution(int[][] triangle) {
        int [][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            
            for(int j=0; j<=i; j++){
                if(j== 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<triangle.length; i++){
            ans = Math.max(dp[triangle.length-1][i], ans);
        }
        
        return ans;
    }
}