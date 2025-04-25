import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0;
    private static int N;

    public static void main(String[] args) throws IOException {

       // 작은거 두개를 합치면 됨, 하나가 될 때 까지
        PriorityQueue<Integer> que = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            que.add(Integer.parseInt(br.readLine()));
        }

        long cnt = 0;
        while(que.size() != 1){
            int n1 = que.poll();
            int n2 = que.poll();

            cnt += (n1+n2);

            que.add((n1+n2));
        }

        System.out.println(cnt);
    }
}
