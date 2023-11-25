import java.io.*;
import java.util.*;

public class Main {
    static  String [][] map;
    static int count = 0;
    static int row;
    static int col;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new String[row][col];

        Point start = null;
        for(int i=0; i<row; i++){
            String infos [] = br.readLine().split("");
            for(int j=0; j<col; j++){
                map[i][j] = infos[j];
                if(map[i][j].equals("I")){
                    start = new Point(i,j);
                }
            }
        }
        BFS(start);
        if(count == 0)
            bw.write("TT");
         else
            bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(Point start){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        boolean [][] isVisited = new boolean[map.length][map[0].length];
        Queue<Point> que = new LinkedList();

        isVisited[start.row][start.col] = true;
        que.add(start);

        while(!que.isEmpty()){
            Point cur = que.poll();
            if (map[cur.row][cur.col].equals("P"))
                count++;

            for(int i=0; i<dx.length; i++){
                int nextRow = cur.row + dx[i];
                int nextCol = cur.col + dy[i];
                if(isRange(nextRow,nextCol) && !isVisited[nextRow][nextCol] && !map[nextRow][nextCol].equals("X")){
                    que.add(new Point(nextRow,nextCol));
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }
    }

    public static boolean isRange(int r, int c){
        if(r>=0 && r<row && c>=0 &&c <col)
            return true;
        return false;
    }
}

class Point{
    int row;
    int col;
    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}
