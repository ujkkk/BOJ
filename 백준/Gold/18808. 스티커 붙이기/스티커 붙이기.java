import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static int [][] noteBook;
    public static Sticker [] stickers;
    public static int N;
    public static int M;
    public static int K;

   public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken()); // 세로
       M = Integer.parseInt(st.nextToken());  // 가로
       K = Integer.parseInt(st.nextToken()); // 스티커의 개수

       noteBook = new int[N][M];
       // 스티커 입력 받기
       stickers = new Sticker[K];

       for(int k=0; k<K; k++){
           st = new StringTokenizer(br.readLine());
           int r = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           int [][] map = new int[r][c];
           // 스티커 맵 정보 입력 받기
           for(int i=0; i<r; i++){
               st = new StringTokenizer(br.readLine());
               for(int j=0; j<c; j++){
                   map[i][j] = Integer.parseInt(st.nextToken());
               }
           }

           stickers[k] = new Sticker(r,c, map);
       }

       // 스티커 붙이기 시작
       for(int k=0; k<K; k++) {
           Sticker cur = stickers[k];
           // 그냥 붙이기
           if (find(cur.r, cur.c, cur.map))
               continue;
           // 회전해서 붙이기 (90, 180, 270)
           int[][] rotateMap = rotation90(cur.map);
           // 90도 회전 붙이기
           if (find(cur.c, cur.r, rotateMap))
               continue;

           // 180도 회전 붙이기
           rotateMap = rotation90(rotateMap);
           if (find(cur.r, cur.c, rotateMap))
               continue;

           // 270도 회전 붙이기
           rotateMap = rotation90(rotateMap);
           find(cur.c, cur.r, rotateMap);
       }

       // 남아있는 칸 확인
       int ans = 0;
       for(int i=0; i<N; i++){
           for(int j=0; j<M; j++){
               if(noteBook[i][j] == 1)
                   ans++;
           }
       }

       System.out.println(ans);
   }

   public static int [][] rotation90 (int [][] map){
       int R = map.length;
       int C = map[0].length;
       int [][] temp = new int[C][R];
       for(int i=0; i<R; i++){
           for(int j=0; j<C; j++){
               temp[j][R-i-1] = map[i][j];
           }
       }
       return temp;
   }

    public static boolean find(int r, int c, int [][] map){
       for(int i=0; i<= N-r; i++){
           for(int j=0; j<= M-c; j++){
               if(check(i, j, map)){
                   addSticker(i, j, map);
                   return true;
               }
           }
       }
       return false;
    }

    public static void addSticker(int startR, int startC, int [][] map){
        for(int i=0; i< map.length; i++){
            for(int j= 0; j < map[0].length; j++){
                // 노트북에 스티커 붙이기
                if(map[i][j] == 1)
                    noteBook[startR+ i][startC + j] = 1;
            }
        }
    }

    public static boolean check(int startR, int startC, int [][]map){
       for(int i=0; i< map.length; i++){
           for(int j= 0; j < map[0].length; j++){
               if(map[i][j] == 0)
                   continue;
               if(!isIn(startR + i, startC +j) ||  noteBook[startR + i][startC +j] == 1)
                   return false;
           }
       }
       return true;
    }

    public static boolean isIn(int r, int c){
       if(r>= 0 && r<N && c >=0 && c<M)
           return true;
       return false;
    }

}

class Sticker{
    int r;
    int c;
    int [][] map;

    Sticker(int r, int c ,int [][] map){
        this.r = r;
        this.c = c;
        this.map = map;
    }
}
