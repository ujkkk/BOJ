import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int start = 0;
        int end = N-1;
        int ans = 0 ;

        while(true){
            if(start >= end) break;
            if(start >= N || end <0) break;

            int cur = nums[start] + nums[end];

            if(cur > M){
                end--;
            }
            else if(cur < M){
                start++;
            }
            else{
                ans++;
                if(start+1 <N && nums[start+1] == nums[start]){
                    start++;
                }
                else if(end -1 >=0 && nums[end-1] == nums[end]){
                    end--;
                }
                else{
                    start++;
                    end--;
                }
            }
        }

        System.out.println(ans);
    }
}
