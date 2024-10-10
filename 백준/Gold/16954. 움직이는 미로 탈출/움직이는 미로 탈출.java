import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int R = 8;
    public static int C = 8;

    public static int [][] map;
    public static int [][] visitCount;


    public static boolean solution() throws IOException {
        map = new int [8][8];
        visitCount = new int[8][8];

        for(int i=0; i<R; i++){
            String [] infos = br.readLine().split("");
            for(int j=0; j<C; j++){
                if(infos[j].equals(".")){
                    // 빈칸
                    map[i][j] = 0;
                } else{
                    // 벽
                    map[i][j] = 1;
                }
            }
        }

        if(map[R-1][0] == 1){
            return false;
        }
        return dfs(R -1, 0, map);
    }

    public static boolean dfs(int r, int c, int [][] map){
        int dr [] = {1, 1, 0, -1, -1, -1, 0, 1};
        int dc [] = {0, 1, 1, 1, 0, -1, -1, -1};

        // 탈출 확인
        if(r == 0 && c == C-1){
            return true;
        }
        // 맵 움직임
        int [][] moveMap = move(map);
        if(r== R-1 && c == 0 && visitCount[R-1][0] == 0){
            moveMap = map;
        }
        // 캐릭터 확인
        if(moveMap[r][c] == 1){
            // 해당 경로는 불가능
            return false;
        }
        // 가능한 위치 넣기
        for(int i=0; i<dr.length; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextR >= R || nextC <0 || nextC >= C){
                continue;
            }
            if(moveMap[nextR][nextC] == 1){
                continue;
            }
            if(visitCount[nextR][nextC] > 9){
                continue;
            }

            visitCount[nextR][nextC]++;
            if(dfs(nextR, nextC, moveMap)){
                return true;
            }
            visitCount[nextR][nextC]--;
        }
        // 현재 위치
        if(moveMap[r][c] == 0 && visitCount[r][c]<10 ){
            visitCount[r][c]++;
            if(dfs(r, c, moveMap)){
                return true;
            }
            visitCount[r][c]--;
        }
        return false;
    }


//    public static boolean bfs(int r, int c, int [][] map){
//
//        Queue<Board> que = new LinkedList<>();
//
//
//
//        // 가능한 위치 넣기
//        for(int i=0; i<dr.length; i++){
//            int nextR = r + dr[i];
//            int nextC = c + dc[i];
//
//            if(nextR < 0 || nextR >= R || nextC <0 || nextC >= C){
//                continue;
//            }
//            if(map[nextR][nextC] == 1){
//                continue;
//            }
//            que.add(new Board(nextR, nextC, map));
//        }
//        // 현재 위치
//        if(map[r][c] == 0){
//            que.add(new Board(r, c, map));
//        }
//
//        while(!que.isEmpty()){
//            Board cur = que.poll();
//
//            // 탈출 확인
//            if(cur.r == 0 && cur.c == C-1){
//                return true;
//            }
//            // 맵 움직임
//            int [][] moveMap = move(cur.map);
//            // 캐릭터 확인
//            if(moveMap[cur.r][cur.c] == 1){
//                // 해당 경로는 불가능
//                continue;
//            }
//
//            // 가능한 위치 넣기
//            for(int i=0; i<dr.length; i++){
//                int nextR = cur.r + dr[i];
//                int nextC = cur.c + dc[i];
//
//                if(nextR < 0 || nextR >= R || nextC <0 || nextC >= C){
//                    continue;
//                }
//                if(map[nextR][nextC] == 1){
//                    continue;
//                }
//                que.add(new Board(nextR, nextC, moveMap));
//            }
//            // 현재 위치
//            if(map[cur.r][cur.c] == 0){
//                que.add(new Board(r, c, moveMap));
//            }
//
//        }
//
//        return false;
//    }


    public static int [][] move(int [][] map){
        int [][] next = new int[R][C];

        for(int i=1; i<R; i++){
            for(int j=0; j<C; j++){
                next[i][j] = map[i-1][j];
            }
        }
        return next;
    }

    public static void main(String[] args) throws IOException {
        if(solution()){
            System.out.println("1");
        } else{
            System.out.println("0");
        }
        bw.flush();
    }

}

class Board{
    int r;
    int c;
    int [][] map;

    public Board(int r, int c, int[][] map) {
        this.r = r;
        this.c = c;
        this.map = map;
    }
}


