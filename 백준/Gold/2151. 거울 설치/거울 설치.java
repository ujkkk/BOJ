import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int mirrorCount = 0;
    static int sr, sc = -1;
    static int er, ec;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        char [][] map = initMap();

        int result = bfs(map);
        System.out.println(result);
    }

    public static int bfs(char [][] map){
        int [] dr = {-1, 1, 0,0,};
        int [] dc = {0, 0, 1, -1};
        PriorityQueue<Mirror>  que = new PriorityQueue<>();
        boolean [][][] visited = new boolean[N][N][4];

        // 처음 좌표에 대해서 네 방향 모두 검사
        for(int i=0; i<4; i++){
            int nextR = sr + dr[i];
            int nextC = sc + dc[i];

            if(nextR >=0 && nextR < N && nextC >=0 && nextC < N && map[nextR][nextC] != '*'){

                que.add(new Mirror(nextR, nextC, i, 0));
            }
        }

        while(!que.isEmpty()){
            Mirror cur = que.poll();
            visited[cur.r][cur.c][cur.dir] = true;

            if(cur.r == er && cur.c == ec){
                return cur.cnt;
            }

            // 직선 방향 넣기
            int nextR = cur.r + dr[cur.dir];
            int nextC = cur.c+ dc[cur.dir];

            if(nextR >=0 && nextR < N && nextC >=0 && nextC < N && map[nextR][nextC] != '*' && !visited[nextR][nextC][cur.dir]){
                que.add(new Mirror(nextR, nextC, cur.dir, cur.cnt));
                visited[nextR][nextC][cur.dir] = true;
            }

            // 거울이 있는 경우
            if(map[cur.r][cur.c] == '!'){
                int [] idxs = new int[2];
                if(cur.cnt >= mirrorCount){
                    continue;
                }
                // 방향 확인
                if(cur.dir == 0 || cur.dir == 1){   // 위, 아래에서 온 빛
                    // 왼쪽, 오른쪽으로 빛이 반사
                    idxs[0] = 2; idxs[1] = 3;
                }
                else{   // 왼쪽, 오른쪽에서 온 빛
                    // 위쪽, 오른쪽으로 빛이 반사
                    idxs[0] = 0; idxs[1] = 1;
                }

                for(int i=0; i<2; i++){
                    nextR = cur.r + dr[idxs[i]];
                    nextC = cur.c+ dc[idxs[i]];

                    if(nextR >=0 && nextR < N && nextC >=0 && nextC < N && map[nextR][nextC] != '*' && !visited[nextR][nextC][idxs[i]]){
                        que.add(new Mirror(nextR, nextC, idxs[i], cur.cnt + 1));
                    }
                }

            }
        }
        return mirrorCount;
    }

    public static char [][] initMap() throws IOException {
        char [][] map = new char[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<N; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;

                if(ch == '#'){
                    if(sc == -1){
                        sr = i; sc = j;
                    }
                    else{
                        er = i; ec = j;
                    }
                }
                else if(ch == '!'){
                    mirrorCount++;
                }
            }
        }
        return map;
    }
}

class Mirror implements Comparable<Mirror> {
    int r;
    int c;
    int dir;
    int cnt;

    public Mirror(int r, int c, int dir, int cnt) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Mirror o){
        return this.cnt - o.cnt;
    }

}


