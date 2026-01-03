import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int S_STUDENT = 0;   // 이다솜 (4명이상)
    static int Y_STUDENT = 1;   // 임도연
    static int map [][] = new int[5][5];
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    static List<int[]> sStudents = new ArrayList<>();
    static List<int[]> yStudents = new ArrayList<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<5; j++){
                if(str.charAt(j) == 'Y'){
                    yStudents.add(new int[]{i,j});
                }
                else{
                    sStudents.add(new int[]{i,j});
                }
            }
        }

        for(int i=4; i<=7; i++){
            selectStudent(S_STUDENT, i, 0, 0, new ArrayList<>());
        }

        System.out.println(ans);
    }


    public static void selectStudent(int type, int selectCount, int curCount, int idx, List<int[]> points){
        if(curCount == selectCount){
            if(points.size() == 7){
               // System.out.println("7개 뽑음");
                bfs(points);
            }
            else{
                selectStudent(type==S_STUDENT? Y_STUDENT:S_STUDENT, 7-selectCount, 0, 0, points);
            }
            return;
        }

        int size = (type==S_STUDENT)? sStudents.size(): yStudents.size();

        for(int i=idx; i<size; i++){
            int [] cur = (type==S_STUDENT)? sStudents.get(i) : yStudents.get(i);
            points.add(new int[]{cur[0], cur[1]});

            selectStudent(type, selectCount, curCount +1, i+1, points);

            points.remove(points.size()-1);
        }
    }

    public static void bfs(List<int[]> points){
        Queue<int [] > que = new ArrayDeque<>();
        boolean [][] isSelected = new boolean[5][5];
        boolean [][] isVisited = new boolean[5][5];

        for(int[] point : points){
            isSelected[point[0]][point[1]] = true;
        }

        int firstR = points.get(0)[0];
        int firstC = points.get(0)[1];
        que.add(new int [] {firstR, firstC});
        isVisited[firstR][firstC] = true;

        int count = 0;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            count++;
            if(count >= 7){
                ans++;
                return;
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr <0 || nr >=5 || nc <0 || nc >=5 || isVisited[nr][nc])
                    continue;

                if(!isSelected[nr][nc] || isVisited[nr][nc]){
                    continue;
                }
                isVisited[nr][nc] = true;
                que.add(new int[]{nr, nc});
            }
        }
        return;
    }

}

