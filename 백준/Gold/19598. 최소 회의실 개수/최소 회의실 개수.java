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

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            Meeting cur = meetings.get(i);
            if(que.isEmpty() || que.peek() > cur.start){
                // 새로운 회의실 배정
                que.add(cur.end);
            }
            else{
                que.poll();
                que.add(cur.end);
            }
        }
        System.out.println(que.size());
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

