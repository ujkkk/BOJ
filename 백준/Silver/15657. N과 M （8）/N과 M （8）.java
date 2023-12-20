import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int [] arr;
    public static boolean [] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;
    public static List<Integer> result;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        result = new ArrayList<>();
        Arrays.sort(num);

        arr = new int[M];
        visit = new boolean[N+1];
        dfs(0,0, num);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int n, int depth, int [] num){
        // 중복 허용, 다음수는 같거나 높아야 한다.
        if(depth == M){
            int digit = (int)Math.pow(10, M-1);
            int completeN = 0;
            for(int val : arr){
                completeN += val*digit;
                digit/=10;
            }
            if(!result.contains(completeN)){
                for(int val : arr){
                    sb.append(val).append(' ');
                }
                result.add(completeN);
                sb.append('\n');
            }

            return;
        }

        for(int i=0; i<num.length; i++){
            if(num[i] >= n){
                // 깊이에 따라 변경을 해주니 넣고 빼줄 필요가 없다.
                arr[depth] = num[i];
                dfs(num[i],depth+1, num);
            }
        }

    }
}
