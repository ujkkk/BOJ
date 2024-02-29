
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static String[][] map;
    public static boolean[][] crushMap;
    public static boolean[][] isVisited;
    public static int ans = 0;
    static final int ROW = 12;
    static final int COL = 6;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new String[ROW][COL];


        for (int r = 0; r < ROW; r++) {
            String[] st = br.readLine().split("");
            for (int c = 0; c < COL; c++) {
                map[r][c] = st[c];
            }
        }

        solution();

        System.out.println(ans);
    }

    public static void solution() {
        boolean existDelete;
        while (true) {
            existDelete = false;
            crushMap = new boolean[ROW][COL];
            isVisited = new boolean[ROW][COL];
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (!map[i][j].equals(".") && !isVisited[i][j]) {
                        ArrayList<Block> crushBlocks = new ArrayList<>();
                        BFS(i, j, crushBlocks);

                        // 충돌 처리 해주기
                        if (crushBlocks.size() >= 4) {
                            existDelete = true;
                            for (Block block : crushBlocks) {
                                map[block.r][block.c] = ".";
                            }
                        }
                    }
                }
            }
            if (!existDelete)
                break;
            ans++;
            // 남은 블록 떨어지게 하기
            gravity();
        }
    }

    public static void gravity() {
        for (int c = 0; c < COL; c++) {
            String[] temp = new String[ROW];
            // 복사
            for (int i = 0; i < ROW; i++) {
                temp[i] = map[i][c];
            }
            for(int i=ROW-2; i >=0; i--){
                if(map[i][c].equals("."))
                    continue;
                int count = 0;
                int curR = i+1;
                while (curR <= ROW -1 && map[curR][c].equals(".")) {
                    curR++;
                    count++;
                }
                map[i][c] = ".";
                map[curR-1][c] = temp[i];
            }
        }
    }


    public static void BFS(int r, int c, ArrayList<Block> crushBlocks) {
        int dr[] = {1, 0, -1, 0};
        int dc[] = {0, 1, 0, -1};

        Queue<Block> que = new LinkedList<>();
        crushBlocks.add(new Block(r, c));
        que.offer(new Block(r, c));
        isVisited[r][c] = true;

        while (!que.isEmpty()) {
            Block current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (isRange(nr, nc) && map[nr][nc].equals(map[r][c])) {
                    if (isVisited[nr][nc])
                        continue;
                    isVisited[nr][nc] = true;
                    crushBlocks.add(new Block(nr, nc));
                    que.offer(new Block(nr, nc));
                }
            }
        }
    }

    //   public static void DFS(int r, int c, int depth, ArrayList<Block> crushBlocks){
//
//       isVisited[r][c] = true;
//
//       if(depth >=4){
//           for(Block block : crushBlocks){
//               crushMap[block.r][block.c] = true;
//           }
//       }
//        for(int i=0; i<4; i++){
//            int nextR = r + dr[i];
//            int nextC = c + dc[i];
//
//            if(isRange(nextR, nextC) && map[r][c].equals(map[nextR][nextC])){
//                if(isVisited[nextR][nextC])
//                    continue;
//
//                Block block = new Block(nextR,nextC);
//                crushBlocks.add(block);
//                DFS(nextR, nextC, depth+1, crushBlocks);
//                crushBlocks.remove(block);
//            }
//        }
//   }
    public static boolean isRange(int r, int c) {
        if (r >= 0 && r < ROW && c >= 0 && c < COL)
            return true;
        return false;
    }
}
class Block{
    int r;
    int c;
    public Block(int r, int c){
        this.r = r;
        this.c = c;
    }
}
