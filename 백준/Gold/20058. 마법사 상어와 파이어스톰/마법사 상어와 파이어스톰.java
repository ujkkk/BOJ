import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int [][] map;
    static int out = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[(int)Math.pow(2,N)][(int)Math.pow(2,N)];
        for(int i=0; i<map.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<map.length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // end init map..

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            int L = Integer.parseInt(st.nextToken());
            simulation(L);
        }

        int sum = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);

        int max = 0;
        boolean [][] isVisited = new boolean[map.length][map.length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(isVisited[i][j] || map[i][j] <= 0) continue;
                max = Math.max(bfs(i, j, isVisited), max);
            }
        }
        System.out.println(max);

    }

    public static void simulation(int L){
        int length = (int)Math.pow(2, L);
        // 쪼개고 회전
        for(int i=0; i<map.length; i+=length){
            for(int j=0; j<map.length; j+=length){
                rotation(i, j,length);
            }
        }

        // 녹이기
        melt();

    }

    private static int bfs(int r, int c, boolean [][] isVisited){

        int [] dr = {-1, 0, 1, 0};
        int [] dc ={0, 1, 0, -1};

        int cnt = 0;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        isVisited[r][c] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            cnt++;

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0|| nr >=map.length || nc <0 || nc >=map.length)
                    continue;
                if(isVisited[nr][nc] || map[nr][nc] <= 0)
                    continue;

                que.add(new Point(nr, nc));
                isVisited[nr][nc] =true;
            }
        }

       return cnt;
    }

    private static void melt(){
        int [][] temp = copy(map);

        // 비교는 map(origin)으로만 하고, 다 끝나고 temp 값을 복사함
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(temp[i][j] == 0) continue;

                if(isMelt(i ,j)){
                    temp[i][j]--;
                }
            }
        }

        // 옮김
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                map[i][j] = temp[i][j];
            }
        }


    }



    private static boolean isMelt(int r, int c){
        int [] dr = {-1, 0, 1, 0};
        int [] dc ={0, 1, 0, -1};

        int cnt = 0;   // 얼음과 인전합 수
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0|| nr >=map.length || nc <0 || nc >=map.length)
                continue;
            if(map[nr][nc] > 0)
                cnt++;

        }

        if(cnt < 3) // 녹음
            return true;
        else    // 안녹음
            return false;
    }

    private static int [][] copy(int [][] list){
        int [][] copy = new int[list.length][list[0].length];
        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[0].length; j++){
                copy[i][j] = list[i][j];
            }
        }
        return copy;
    }

    public static void rotation(int sr, int sc, int length){
        int [][] temp = new int[length][length];
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                temp[i][j] = map[sr+i][sc+j];
            }
        }

        // 90도 회전
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                // 여기서 sr, sc 안 더해서 실수
                map[sr+ j][sc+ length-1-i] = temp[i][j];
            }
        }
    }


}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

