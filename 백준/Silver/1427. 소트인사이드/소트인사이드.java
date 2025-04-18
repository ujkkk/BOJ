import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String [] strN = br.readLine().split("");

        Integer [] nums = new Integer [strN.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(strN[i]);
        }

        Arrays.sort(nums, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int n : nums){
            sb.append(n);
        }
        System.out.println(sb);
    }

}
