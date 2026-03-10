
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // 최소 - 짧은 것부터 앞에 세우기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums [] = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int prefixSum = 0;
        int curSum = 0;
        for(int i=0; i<N; i++){
            curSum += nums[i];
            prefixSum += curSum;
        }
        System.out.println(prefixSum);
    }



}