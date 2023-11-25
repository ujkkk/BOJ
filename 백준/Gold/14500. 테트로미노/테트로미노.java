import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 도형 정보
    static int [][][] ternomino1 = {{{1,1,1,1}},
            {{1},{1},{1},{1}}};
    static int [][][] ternomino2 = {{{1,1}, {1,1}}};
    static int [][][] ternomino3 = {{{1,0}, {1,0}, {1,1}},
            {{1,1,1},{1,0,0}},
            {{1,1},{0,1},{0,1}},
            {{0,0,1},{1,1,1}}};
    static int [][][] ternomino4 = {{{1,0}, {1,1}, {0,1}} , {{0,1,1},{1,1,0}}};
    static int [][][] ternomino5 = {{{1,1,1}, {0,1,0}},
            {{0,1},{1,1},{0,1}},
            {{0,1,0},{1,1,1}},
            {{1,0},{1,1},{1,0}}};

    static  int [][] map;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        // map 점수 입력
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i< ternomino1.length; i++){
            getMax(ternomino1[i]);
        }
        for(int i=0; i< ternomino2.length; i++){
            getMax(ternomino2[i]);
        }
        for(int i=0; i< ternomino3.length; i++){
            getMax(ternomino3[i]);
            getMax(symmetry(ternomino3[i]));
        }
        for(int i=0; i< ternomino4.length; i++){
            getMax(ternomino4[i]);
            getMax(symmetry(ternomino4[i]));
        }
        for(int i=0; i< ternomino5.length; i++){
            getMax(ternomino5[i]);
            getMax(symmetry(ternomino5[i]));
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getMax(int [][] ternomino){
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0; i<ternomino.length; i++){
            for(int j=0; j<ternomino[0].length; j++){
                if(ternomino[i][j] == 1)
                    points.add(new Point(i,j));
            }
        }

        for(int i=0; i< map.length; i++){
            for(int j=0; j<map[0].length; j++){
                int sum = 0;
                for(Point p : points){
                    if(p.row +i >= map.length || p.col+j >=map[0].length){
                        sum = 0;break;
                    }
                    sum += map[p.row+i][p.col+j];
                    if(sum == 25){
                        int d =0;
                    }
                }
                max = Math.max(max, sum);
            }
        }
    }
    public static int[][] symmetry(int [][] ternomino){
        int [][] newTernomino;
        newTernomino = new int[ternomino.length][ternomino[0].length];

        for(int i=0;i <ternomino.length; i++){
            for(int j=0; j<ternomino[0].length; j++){
                newTernomino[i][j] = ternomino[i][ternomino[0].length-1-j];
            }
        }
        return newTernomino;
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
