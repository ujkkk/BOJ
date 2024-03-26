import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int ME = 2;
    public static final int FIRE = 4;

    public static int N, M;
    public static int [][] map;
    public static ArrayList<Point> fires;
    public static Point start;
    public  static int reuslt= 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=0; t<T; t++){
            reuslt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            fires = new ArrayList<>();

            for(int i=0; i<N; i++){
                String [] str = br.readLine().split("");
                for(int j=0; j<M; j++){
                    switch (str[j]){
                        case ".":
                            map[i][j] = EMPTY;
                            break;
                        case "#":
                            map[i][j] = WALL;
                            break;
                        case "@":
                            map[i][j] = ME;
                            start = new Point(i,j);
                            break;
                        case "*":
                            map[i][j] = FIRE;
                            fires.add(new Point(i,j));
                            break;
                    }

                }
            }

            // 탐색 시작
            if(BFS()){
                bw.write(reuslt +"\n");
            }else{
                bw.write("IMPOSSIBLE\n");
            }

        }
        bw.flush();
    }

    public static boolean BFS(){
        // 불부터 움직이기
        Queue<Point> fireQue = new LinkedList<>();
        Queue<Point> meQue = new LinkedList<>();

        boolean meVisited [][] = new boolean[N][M];
        boolean fireVisited [][] = new boolean[N][M];

        meQue.add(start);
        meVisited[start.r][start.c] = true;

        for(Point fire : fires){
            fireQue.add(fire);
            fireVisited[fire.r][fire.c] = true;
        }

        while(true){
            if(meQue.size() == 0){
                return false;
            }
            reuslt++;
            // 불 움직이기
            moveFires(fireQue, fireVisited);
            // 상근이 움직이기
            if(moveMe(meQue, meVisited)){
                break;
            }
        }
        return true;
    }

    public static boolean escape(){
        for(int i=0; i<N; i++){
            if(map[i][0]== ME || map[i][M-1]== ME)
                return true;
        }

        for(int i=0; i<M; i++){
            if(map[0][i]==ME || map[N-1][i]==ME )
                return true;
        }
        return false;
    }

    public static boolean moveMe(Queue<Point> que, boolean isVisited [][]){
        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};

        int size = que.size();

        for(int i=0; i<size; i++){
            Point cur = que.poll();

            for(int j =0; j<4; j++){
                int r = cur.r + dr[j];
                int c = cur.c + dc[j];

                if(r< 0 || r >=N || c<0 || c>=M)
                    return true;

                if(!isVisited[r][c] && map[r][c] == EMPTY){
                    map[r][c] = ME;
                    isVisited[r][c] = true;
                    que.add(new Point(r,c));
                }
            }
        }
        // 추가한게 없으면 더 이상 이동을 못하므로 실패
        return false;
    }

    public static void moveFires(Queue<Point> que, boolean isVisited [][]){
        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};

        int size = que.size();

        for(int i=0; i<size; i++){
            Point cur = que.poll();

            for(int j =0; j<4; j++){
                int r = cur.r + dr[j];
                int c = cur.c + dc[j];

                if(r< 0 || r >=N || c<0 || c>=M)
                    continue;
                if(isVisited[r][c] || map[r][c] == WALL)
                    continue;

                map[r][c] = FIRE;
                que.add(new Point(r,c));
                isVisited[r][c] = true;

            }
        }
    }
}

class Point{
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}


