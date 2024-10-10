import java.util.*;

class Solution {
       public static int solution(int N, int number) {

           if(N == number){
               return 1;
           }
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<Integer>();
        }

        dp[1].add(N);

        for (int i = 2; i <= 8; i++) {
            // N을 i번 이어붙인 수 만들기
            StringBuilder sb = new StringBuilder();
            for (int p = 0; p < i; p++) {
                sb.append(N);
            }
            dp[i].add(Integer.parseInt(sb.toString()));
            
            for (int j = 1; j < i; j++) {
                int left = j;
                int right = i - j;

                for (int l : dp[left]) {
                    for (int r : dp[right]) {
                        dp[i].add(l * r);
                        dp[i].add(l + r);
                        dp[i].add(l - r);
                        if (r != 0) {
                            dp[i].add(l / r);
                        }
                    }
                }
                
            }

            if(dp[i].contains(number)){
                return i;
            }
        }
        return -1;
    }

}