import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String [][] colors;
    static boolean isVisited [][];
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        colors = new String[N][N];
        isVisited = new boolean[N][N];

        for(int row =0; row<N; row++){
            String [] colorInput = br.readLine().split("");
            for(int col =0; col<N; col++){
                colors[row][col] = colorInput[col];
            }
        }
        // 적록색약이 아닌 사람이 보는 그룹의 수
        int ans1 = 0;
        for(int row =0; row<N; row++){
            for(int col =0; col<N; col++){
                if(!isVisited[row][col]){
                    BSF1(new Point(row,col));
                    ans1++;
                }
            }
        }

        int ans2 = 0;
        isVisited = new boolean[N][N];
        for(int row =0; row<N; row++){
            for(int col =0; col<N; col++){
                if(!isVisited[row][col]){
                    BSF2(new Point(row,col));
                    ans2++;
                }
            }
        }
        bw.write(ans1 +" " + ans2);
        bw.flush();

        bw.close();
        br.close();
    }

    public static void BSF1(Point start){
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        isVisited[start.row][start.col] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            String color = colors[cur.row][cur.col];

            for(int i=0; i<4; i++){
                int nextRow = cur.row + dx[i];
                int nextCol = cur.col + dy[i];

                if(isRange(nextRow,nextCol) && !isVisited[nextRow][nextCol]){
                    // 탐색하고 있는 색과 같은 색일 때만
                    if(colors[nextRow][nextCol].equals(color)){
                        que.add(new Point(nextRow,nextCol));
                        isVisited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }

    public static void BSF2(Point start){
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        isVisited[start.row][start.col] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            String color = colors[cur.row][cur.col];

            for(int i=0; i<4; i++){
                int nextRow = cur.row + dx[i];
                int nextCol = cur.col + dy[i];

                if(isRange(nextRow,nextCol) && !isVisited[nextRow][nextCol]){
                    // 탐색하고 있는 색과 같은 색일 때만
                    switch (color){
                        case "R":
                        case "G":
                            if(!colors[nextRow][nextCol].equals("B")){
                                que.add(new Point(nextRow,nextCol));
                                isVisited[nextRow][nextCol] = true;
                            }
                            break;
                        case "B":
                            if(colors[nextRow][nextCol].equals(color)){
                                que.add(new Point(nextRow,nextCol));
                                isVisited[nextRow][nextCol] = true;
                            }
                    }
                }
            }
        }
    }

    public static boolean isRange(int r, int c){
        if(r>=0 && r<N && c>=0 && c<N)
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