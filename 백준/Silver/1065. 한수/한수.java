import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

       int N = Integer.parseInt(br.readLine());
       int ans = 0;

       for(int n = 1; n<=N; n++){
           if(isHansu(String.valueOf(n).toCharArray())){
               ans++;
           }
       }
        System.out.println(ans);
    }



    public static boolean isHansu(char [] nums){
        if(nums.length <= 1) {
            return true;
        }

        int term = (nums[1]-'0') - (nums[0] - '0');
        for(int i=2; i<nums.length; i++){
            if(!((nums[i]-'0') - (nums[i-1] - '0') == term)){
                return false;
            }
        }
        return true;
    }

}