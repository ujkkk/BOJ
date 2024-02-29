
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static int [][] map;
    public static ArrayList<Point> chickens;
    public static ArrayList<Point> homes;
    public static int N;
    public static int M;
    public static int ans = Integer.MAX_VALUE;
    static boolean[] chickenVisited; // 뽑은 치킨집 체크

   public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken()); // 세로
       M = Integer.parseInt(st.nextToken());  // 폐업시키지 않을 치킨집의 개수
       map = new int[N][N];
       chickens = new ArrayList<>();
       homes = new ArrayList<>();

       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<N; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
               if(map[i][j] == 1){
                   homes.add(new Point(i,j));
               }
               else if(map[i][j] == 2){
                   chickens.add(new Point(i,j));
               }
           }
       }

       chickenVisited = new boolean[chickens.size()];
       getDis(0,0);

       System.out.println(ans);
   }

   public static void getDis(int cnt, int idx){
       if(cnt == M){
           int total = 0; // 도시의 치킨거리

           for(int i = 0; i < homes.size(); i++) {
               int sum = Integer.MAX_VALUE;
               for(int j = 0; j < chickens.size(); j++) {
                   if(chickenVisited[j]) { //i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
                       Point chicken = chickens.get(j);
                       int dist = Math.abs(homes.get(i).r - chicken.r)
                               + Math.abs(homes.get(i).c - chicken.c);
                       sum = Math.min(sum, dist);
                   }
               }
               total += sum;
           }
           ans = Math.min(total, ans);
           return;
       }
       for(int i=idx; i < chickens.size(); i++){
           chickenVisited[i] = true;
           getDis(cnt+1, i+1);
           chickenVisited[i] = false;
       }
   }

}

class Point {
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
