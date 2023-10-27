import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br;

    public static boolean[][] maze;
    public static boolean [][] isVisited;
    public static int N;
    public static int M;
    public static int result;

    public static void main(String [] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        result = 1;
        createMaze();

        Queue<Data> que = new LinkedList<>();
        que.add(new Data(1,1, 1));

        // 시계방향 (상부터)
        List<Integer> dr = Arrays.asList(-1, 0, 1, 0);
        List<Integer> dc = Arrays.asList(0,1,0,-1);

        while(!que.isEmpty()){
            Data curData = que.poll();
            if(curData.row == N && curData.col == M){
                result = curData.count;
                break;
            }
            // 인접 노드 삽입
            for(int i = 0; i< dr.size(); i++){
                int curRow = curData.row + dr.get(i);
                int curCol = curData.col + dc.get(i);
                int curCount = curData.count;
                if(maze[curRow][curCol] && !isVisited[curRow][curCol]){
                    isVisited[curRow][curCol] = true;
                    que.add(new Data(curRow, curCol, curCount+1));
                }
            }
        }

        System.out.println(result);
    }

    public static void createMaze() throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new boolean[N+2][M+2];
        isVisited = new boolean[N+2][M+2];

        for(int r = 1; r <= N; r++){
            String [] row = br.readLine().split("");
            for(int c = 0; c<row.length; c++){
                if(row[c].equals("1")){
                    maze[r][c+1] = true;
                }
                else{
                    maze[r][c+1] = false;
                }
            }
        }
    }
}

class Data{
    int row;
    int col;
    int count;

    public Data(int row, int col, int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
