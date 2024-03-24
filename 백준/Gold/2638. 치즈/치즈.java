import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int initCount, time = 0;
    public static int [][] map;
    public static boolean [][] ex_air;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        // 치즈 정보 입력 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if(data == 1)
                    initCount++;
            }
        }
        
        // BFS로 외부공기 체크
        while(initCount > 0){
            time++;
            // 외부공기 체크
            ex_air = checkExternalAir();
            
            // 없어질 치즈 체크
            removeCheese(ex_air);
        }
        
        System.out.println(time);

    }
    public static void removeCheese(boolean[][] ex_air){
        int dr [] = {0, -1, 0, 1};
        int dc [] = {1, 0, -1, 0};
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0)
                    continue;
                
                int count = 0;
                for(int p=0; p<4; p++) {
                    int r = i + dr[p];
                    int c = j + dc[p];

                    if(r<0 || r>= N || c<0 || c>=M)
                        continue;
                    // 외부 공기와 몇 변 맞닿는지 체크
                    if(ex_air[r][c] == true)
                        count++;
                }
                if(count >=2){
                    map[i][j] = 0;
                    initCount--;
                }
            }
        }
    }
    
    public static boolean[][] checkExternalAir(){
        int dr [] = {0, -1, 0, 1};
        int dc [] = {1, 0, -1, 0};
        boolean [][] isVisited = new boolean[N][M];
        
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0,0));
        isVisited[0][0] = true;
        
        while(!que.isEmpty()){
            Point cur = que.poll();
            
            for(int i=0; i<4; i++){
                int r = cur.r + dr[i];
                int c = cur.c + dc[i];
                
                if(r<0 || r>= N || c<0 || c>=M)
                    continue;
                if(isVisited[r][c] || map[r][c] == 1)
                    continue;
                que.add(new Point(r,c));
                isVisited[r][c] = true;
            }
        }
        return isVisited;
    }


}
class Point{
    int r;
    int c;
    
    public Point(int r, int c){
        this.r = r;
        this.c =c;
    }
}



