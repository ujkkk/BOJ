import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int [] nums;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i=0; i<N; i++){
           // 내 왼쪽보다 큰 사람 몇명인지
           nums[i] = Integer.parseInt(st.nextToken());
       }

       int [] ans = new int[N];
       boolean [] isSelected = new boolean[N];
       solution(0, isSelected, ans);

       StringBuilder sb = new StringBuilder();
       for(int selected : ans){
           sb.append(selected+1).append(" ");
       }
        System.out.println(sb);
    }

    public static boolean solution(int depth, boolean [] isSelected, int [] select){
        if(depth == N){
            if(isCorrect(select)){
                return true;
            }
            return false;
        }

        for(int i=0; i<N; i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            select[depth] = i;
            if(solution(depth+1, isSelected, select))
                return true;
            isSelected[i] = false;
        }
        return false;
    }

    public static boolean isCorrect(int [] select){
        for(int i=0; i<N; i++){
            int count = 0;
            for(int j=0; j<i; j++){
                if(select[j] > select[i]) count++;
            }
            if(nums[select[i]] != count){
                return false;
            }
        }
        return true;
    }
}

