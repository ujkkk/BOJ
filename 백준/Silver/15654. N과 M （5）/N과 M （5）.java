import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;
    public static int nums[];
    public static boolean isVisited[];

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        isVisited = new  boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

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

        for(int i= 0; i<N; i++){
            int now = nums[i];
            if(isVisited[i])
                continue;

            isVisited[i] = true;
            arr[depth] = nums[i];
            DFS(arr,depth +1);
            isVisited[i] = false;

        }

    }

}
