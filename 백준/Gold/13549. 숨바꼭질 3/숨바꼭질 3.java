import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N;
    static Queue<Data> que;
    static int ans =100001;

    public static void main(String [] args) throws Exception{
        br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] times = new int[100001];
        Arrays.fill(times, 100001);

        que = new LinkedList<>();
        que.add(new Data(N, 0));
        times[N] = 0;
        while(!que.isEmpty()){

            Data curData = que.poll();
            if(curData.pos == K){
                ans = Math.min(curData.time, ans);
            }
            if(curData.pos >0 && times[curData.pos-1] > curData.time+1){
                times[curData.pos-1] = curData.time+1;
                que.add(new Data(curData.pos-1, curData.time +1));
            }
            if(curData.pos <100000 && times[curData.pos+1] > curData.time+1){
                times[curData.pos+1] = curData.time+1;
                que.add(new Data(curData.pos+1, curData.time +1));
            }

            if(curData.pos*2 < 100001 && times[curData.pos*2] > curData.time){
                times[curData.pos*2] = curData.time;
                que.add(new Data(curData.pos*2, curData.time));
            }
        }
        System.out.println(ans);
    }
}

class Data{
    int pos;
    int time;

    public Data(int pos, int time){
        this.pos = pos;
        this.time = time;
    }
}
