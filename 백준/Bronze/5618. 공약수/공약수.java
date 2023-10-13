import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static BufferedReader br;
    public static int result = 0;
    public static void main(String [] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        if(n==2){
            nums = new int[2];
            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
        }
        else{
            nums = new int[3];
            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
            nums[2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int max = nums[nums.length-1];
        for(int i=1; i<= max; i++){
            if(max%1 == 0){
                int j;
                for(j=0; j<nums.length; j++){
                    if(nums[j]%i != 0)
                        break;
                }
                if(j == nums.length){
                    System.out.println(i);
                }
            }
        }

    }
}