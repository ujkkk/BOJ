import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for(int n : nums){
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

}
