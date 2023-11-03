import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean isVisited [][];
    static boolean isState [][];
    static ArrayList<Integer> stateCounts;
    static Queue<Point> que;
    public static void  main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stateCounts = new ArrayList<>();
        isVisited = new boolean[N+2][N+2];
        isState = new boolean[N+2][N+2];
        que = new LinkedList<>();

        //1. 2차원 배열로 단지 값 받기(Data)
        for(int i=1; i<=N; i++){
           String [] st = br.readLine().split("");
            for(int j=1; j<= N; j++){
                if(st[j-1].equals("1")){
                    isState[i][j] = true;
                }
                else{
                    isState[i][j] = false;
                }

            }
        }

        int [] dx = new int[]{-1,0,1,0};
        int [] dy = new int[]{0,1,0,-1};
        for(int row = 1; row <=N; row++){
            for(int col =1; col <= N; col++){
                if(!isState[row][col]){
                    continue;
                }
                // isStatie
                if(!isVisited[row][col]){
                    int count = 0;
                    que.add(new Point(row, col));
                    isVisited[row][col] = true;

                    while(!que.isEmpty()){
                        count++;
                        Point point = que.poll();
                        int x = point.x;
                        int y = point.y;

                        // 상하 좌우 보기 - 1이면 큐에 삽입
                        for(int i=0;i<dx.length; i++){
                            int curX = x+dx[i];
                            int curY = y+dy[i];

                            if(isState[curX][curY] && !isVisited[curX][curY]){
                                que.add(new Point(curX, curY));
                                isVisited[curX][curY] = true;
                            }
                        }
                    }
                    stateCounts.add(count);
                }
            }
        }

        stateCounts.sort(Comparator.naturalOrder());
        System.out.println(stateCounts.size());
        for(int count : stateCounts){
            System.out.println(count);
        }
    }


    // 2. 방문안한 요소에 대해 BFS(상하 좌우)확인

    // 3. 결과 리스트에 ADD
}
