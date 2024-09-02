import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int HORIZON = 0;
    public static int DIAGONAL = 1;
    public static int VERTICAL = 2;

    public int run () throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         if(map[N-1][N-1] == 1){
            return 0;
        }
        return getReachCount(N, map);
    }

    public int getReachCount(int N, int [][] map){
        Queue<Pipe> que = new LinkedList<>();
        boolean [][] isVisited = new boolean[N][N];
        int count = 0;

        que.add(new Pipe(new int[]{0,1}, HORIZON));
        isVisited[0][1] = true;


        while(!que.isEmpty()){
            Pipe cur = que.poll();


            if(cur.point[0] == N-1 && cur.point[1] == N-1){
                count++;
                continue;
            }

            if(cur.dir == HORIZON){
                if(connectHorizon(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0], cur.point[1] + 1}, HORIZON));
                }

                if(connectDiagonal(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0] + 1, cur.point[1] + 1}, DIAGONAL));
                }
            }
            else if (cur.dir == VERTICAL){
                if(connectVertical(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0] + 1, cur.point[1]}, VERTICAL));
                }

                if(connectDiagonal(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0] + 1, cur.point[1] + 1}, DIAGONAL));
                }
            }
            else if (cur.dir == DIAGONAL){
                if(connectHorizon(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0], cur.point[1] + 1}, HORIZON));
                }

                if(connectVertical(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0] + 1, cur.point[1]}, VERTICAL));
                }

                if(connectDiagonal(cur.point, map)){
                    que.add(new Pipe(new int[]{cur.point[0] + 1, cur.point[1] + 1}, DIAGONAL));
                }
            }
        }
        return count;
    }

    public boolean connectHorizon(int [] point, int [][] map){
        int nextR = point[0];
        int nextC = point[1]  + 1;

        // 유효 범위인지 체크
        if(!isRange(nextR, nextC, map.length)){
            return false;
        }
        // 인전 캅이 모두 빈칸인지 체크
        if(map[nextR][nextC] == 1){
            return false;
        }

        return true;
    }

    public boolean connectVertical(int [] point, int [][] map){
        int nextR = point[0] + 1;
        int nextC = point[1];

        // 유효 범위인지 체크
        if(!isRange(nextR, nextC, map.length)){
            return false;
        }
        // 인전 캅이 모두 빈칸인지 체크
        if(map[nextR][nextC] == 1){
            return false;
        }
        return true;
    }

    public boolean connectDiagonal(int [] point, int [][] map){
        int nextR = point[0] + 1;
        int nextC = point[1] + 1;

        // 유효 범위인지 체크
        if(!isRange(nextR, nextC, map.length )|| map[nextR][nextC] == 1){
            return false;
        }
        if(!isRange(nextR -1, nextC, map.length )|| map[nextR-1 ][nextC] == 1){
            return false;
        }
        if(!isRange(nextR, nextC-1, map.length )|| map[nextR][nextC-1] == 1){
            return false;
        }
        return true;
    }

    public boolean isRange(int x, int y, int n ){
        if(x>=0 && x<n && y>=0 && y <n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(new Main().run());
    }
}

class Pipe{
    int [] point;
    int dir;

    public Pipe(int[] point, int dir) {
        this.point = point;
        this.dir = dir;
    }
}

