import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        long [] nums = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<nums.length; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        long min = 4000000000L;
        long [] result = new long[3];
        for(int i=0; i< N-2; i++){
            long a = nums[i]*(-1);

            long [] temp = solution(nums, a, i);

            if(temp[0] < min){
                result[0] = nums[i];
                result[1] = temp[1];
                result[2] = temp[2];

                min = temp[0];
            }

            if(temp[0] == 0){
                break;
            }
        }
        for(int i=0; i<3; i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
    }

    private static long[] solution(long [] nums, long find, int idx){
        long []  result = new long[3];
        long min = 4000000000L;

        int left = idx + 1;
        int right = nums.length-1;

        while(left < right){

            long cur = nums[left] + nums[right];
            long curMin = Math.abs(find - cur);
            
            if(curMin < min){
                min = curMin;
                result[0] = min;
                result[1] = nums[left];
                result[2] = nums[right];
            }

            if(cur > find){
                right--;
            }
            else if(cur < find){
                left++;
            }
            else{
                return result;
            }
        }

        return result;

    }
}

