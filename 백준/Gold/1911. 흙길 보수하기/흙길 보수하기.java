import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Pool> polls = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            polls.add(new Pool(start, end));
        }

        int boardCount = 0;
        int end = 0;

        while(!polls.isEmpty()){
            Pool cur = polls.poll();

            while(end < cur.end){
                // 새 널판지
                boardCount++;
                if(end <= cur.start){
                    end = cur.start + L;
                }
                else{
                    end = end + L;
                }
            }
        }

        System.out.println(boardCount);
    }
}

class Pool implements Comparable<Pool>{
    int start;
    int end ;

    public Pool(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pool o){
        return this.start - o.start;
    }
}