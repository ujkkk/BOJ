class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        String [] nums = Integer.toString(n, k).split("0");
        
        for(String num : nums){
            num = num.trim();
            if(num.isEmpty()){
                continue;
            }
            if(isPrime(Long.parseLong(num))){
                ans++;
            }
        }
        return ans;
    }
    
    public boolean isPrime(long n){
        if(n<=1){
            return false;
        }
        if(n==2 || n==3){
            return true;
        }
        
        for(long i=2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

}