import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        long [] nums  = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;

        long min = Integer.MAX_VALUE * 10L;
        long selectedNums [] = new long[2];
        while(start < end){

            long cur = nums[start] + nums[end];
            if(min >= Math.abs(cur)){
                min = Math.abs(cur);
                selectedNums[0] = nums[start];
                selectedNums[1] = nums[end];
            }

            if(cur > 0){
                end--;
            }
            else if(cur < 0){
                start++;
            }
            else{
                break;
            }
        }

        System.out.println(selectedNums[0] +" " + selectedNums[1]);
    }
}
