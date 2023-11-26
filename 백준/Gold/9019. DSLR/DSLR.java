import java.io.*;
import java.util.*;

public class Main {

    public static String ans;
    public static boolean [] isVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int [] countMap = new int[10001];
            isVisited = new boolean[10001];
            Arrays.fill(countMap, Integer.MAX_VALUE);
            BFS(A,B, countMap);
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void BFS(int a, int b, int[] countMap) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(a,""));
        countMap[a] = 0;

        while(!que.isEmpty()){
            Point current = que.poll();
            if(current.pos == b){
                ans = current.command;
                return;
            }
            // 4가지 연산
            for(int i=0; i<4; i++){
                int nextPos = 0;
                String nextCommand = null;
                if(i==0){
                    //1. D
                    nextPos = (current.pos*2)%10000;
                    nextCommand = current.command + "D";
                }
                else if(i ==1){
                    // 2. S
                    nextPos = current.pos-1;
                    nextCommand = current.command + "S";
                    if(nextPos <0)
                        nextPos = 9999;
                }
                else if(i==2){
                    // 3. R
                    nextPos = (current.pos%10)*1000 + current.pos/10;
                    nextCommand = current.command + "R";
                }
                else if(i==3){
                    // 4. L1
                    nextPos = (current.pos/1000) + (current.pos%1000)*10;
                    nextCommand = current.command + "L";
                }

                if(!isVisited[nextPos]){
                    que.add(new Point(nextPos,nextCommand));
                    isVisited[nextPos] = true;
                }
            }
        }
    }
}

class Point{
    int pos;
    String command;

    public Point(int pos, String command){
        this.pos = pos;
        this.command =command;
    }
}