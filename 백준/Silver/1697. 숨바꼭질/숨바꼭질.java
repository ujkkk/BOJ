import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static final int MIN = 0;
    static final int MAX = 100_000;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 현재 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        int ans = Integer.MAX_VALUE;

        Queue<Data2> que = new LinkedList<>();
        que.add(new Data2(N, 0));

        int [] dp = new int[100_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        while(!que.isEmpty()){
            Data2 curData = que.poll();
            if(curData.pos == K){
                ans = dp[K];
                break;
            }
            int nextTime = curData.time +1;
            // +1칸
            int nextPos = curData.pos +1;
            if(isRange(nextPos) && dp[nextPos]> nextTime){
                dp[nextPos] = nextTime;
                que.add(new Data2(nextPos, nextTime));
            }

            //-1칸
            nextPos = curData.pos - 1;
            if(isRange(nextPos) && dp[nextPos]> nextTime){
                dp[nextPos] = nextTime;
                que.add(new Data2(nextPos, nextTime));
            }

            // *2칸
            nextPos = curData.pos *2;
            if(isRange(nextPos) && dp[nextPos]> nextTime){
                dp[nextPos] = nextTime;
                que.add(new Data2(nextPos, nextTime));
            }
        }

        bw.write(ans +"\n");

        bw.flush();

        bw.close();
        br.close();
    }

    public static boolean isRange(int x){
        if(x >= MIN && x <=MAX)
            return true;
        return false;
    }
}

class Data2{
    int pos;
    int time;

    public Data2(int pos,int time){
        this.pos = pos;
        this.time = time;
    }
}
