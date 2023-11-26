import java.io.*;
import java.util.*;

public class Main {
    static  boolean [] isVisited;
    static int count = 0;
    static int row;
    static int col;
    static HashMap<Integer, Integer> ropes;
    static HashMap<Integer, Integer> snakes;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[101];

        ropes = new HashMap<>();
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            ropes.put(cur, next);
        }

        snakes = new HashMap<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            snakes.put(cur, next);
        }

        BFS(1);
        bw.write(count+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int start){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(start, 0));
        isVisited[start] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            if(cur.pos == 100){
                count = cur.count;
                return;
            }

            for(int i=1; i<=6; i++){
                int nextPos = cur.pos + i;
                if(nextPos <=100 && !isVisited[nextPos]){
                    if(ropes.containsKey(nextPos)){
                        nextPos = ropes.get(nextPos);
                    }
                    if(snakes.containsKey(nextPos)){
                        nextPos = snakes.get(nextPos);
                    }
                    isVisited[nextPos] = true;
                    que.add(new Point(nextPos, cur.count+1));
                }
            }
        }
    }
}

class Point{
    int pos;
    int count;
    public Point(int pos, int count){
        this.pos = pos;
        this.count = count;
    }
}