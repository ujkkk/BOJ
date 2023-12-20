import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int [] arr;
    public static boolean [] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;
    public static int nums[][];

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        nums = new int [10001][1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            nums[n][0]++;
        }

        int [] arr = new int[M];
        DFS(arr, 0);

        System.out.println(sb);

    }

    public static void DFS(int [] arr, int depth){
        if(depth == M){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i= 0; i<10_001; i++){
            if(nums[i][0] == 0)
                continue;

            nums[i][0]--;
            arr[depth] = i;
            DFS(arr, depth +1);
            nums[i][0]++;
        }

    }

}
