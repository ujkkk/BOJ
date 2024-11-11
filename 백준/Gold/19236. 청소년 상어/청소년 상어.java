import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int result = 0;

    static int [] dr = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {

        // 현재 물고기가 있는 맵을 저장
        Fish [][] map = new Fish[4][4];

        // 물고기는 좌표(r,c)와 방향을 가짐
        for(int i=0; i<4; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[i][j] = new Fish(number, i, j, dir-1);
            }
        }

        BFS(map);
        bw.write(result +"");
        bw.flush();
    }

    public static void BFS(Fish [][] map){

        // 상어의 정보와 물고기가 있는 맵 정보를 저장
        Queue<Cycle> que = new LinkedList<>();
        que.add(new Cycle(new Shark(0,0, map[0][0].dir,0), map));

        while (!que.isEmpty()){

            Cycle cycle = que.poll();
            // 상어 이동
            Shark shark = cycle.shark;
            Fish [][] curMap = cycle.map;
            // 해당 부분 먹기
            shark.count += curMap[shark.r][shark.c].number;
            curMap[shark.r][shark.c] = null;

            // 물고기들 이동
            moveFishes(cycle.map, cycle.shark);

            boolean isMove = false;
            for(int i=0; i<4; i++){
                int nextR = shark.r + dr[shark.dir]*(i+1);
                int nextC = shark.c + dc[shark.dir]*(i+1);

                if(nextR < 0 || nextR >=4 || nextC <0 || nextC >=4){
                    continue;
                }

                if(curMap[nextR][nextC] == null){
                    continue;
                }

                isMove = true;
                Fish dieFish = curMap[nextR][nextC];
                que.add(
                    new Cycle(
                        new Shark(nextR, nextC, dieFish.dir, shark.count )
                        , copyMap(curMap))
                );
            }

            if(!isMove){
                result = Math.max(result, shark.count);
            }
        }
    }

    public static void moveFishes(Fish[][] map, Shark shark){
        boolean isFind = false;
        for(int c=1; c<=16; c++){
            for(int i=0; i<4; i++){
                if(isFind){
                    break;
                }
                for(int j=0; j<4; j++){
                    if(map[i][j] != null &&  map[i][j].number == c){
                        moveFish(map, map[i][j], shark);
                        isFind = true;
                        break;
                    }
                }
            }
            isFind = false;
        }
    }

    private static Fish[][] copyMap(Fish[][] map) {
        // 복제
        Fish [][] copy = new Fish[4][4];
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map[0].length; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static void moveFish(Fish[][] map, Fish curFish, Shark curShark){
        for(int i=0; i<8; i++){
            int nextR = curFish.r + dr[(curFish.dir + i)%8];
            int nextC = curFish.c + dc[(curFish.dir + i)%8];
            int nextDir = (curFish.dir + i)%8;

            if(nextR < 0 || nextR >=4 || nextC <0 || nextC >=4){
                continue;
            }
            if(nextR == curShark.r && nextC == curShark.c){
                continue;
            }

            // 이동
            if(map[nextR][nextC] != null){  // 이동할 위치에 물고기가 있을 때
                Fish temp = map[nextR][nextC];
                map[nextR][nextC] = new Fish(curFish.number, nextR, nextC, nextDir);
                map[curFish.r][curFish.c] = new Fish(temp.number, curFish.r, curFish.c, temp.dir);
            }
            else{   // 이동할 위치에 물고기가 없을 때
                map[nextR][nextC] = new Fish(curFish.number, nextR, nextC, nextDir);
                map[curFish.r][curFish.c] = null;
            }
            return;

        }
    }
}

class Cycle {
    Shark shark;
    Fish [][] map;

    public Cycle(Shark shark, Fish[][] map) {
        this.shark = shark;
        this.map = map;
    }
}

class Shark{
    int r;
    int c;
    int dir;
    int count;

    public Shark(int r, int c, int dir, int count) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.count = count;
    }
}
class Fish{
    int number;
    int r;
    int c;
    int dir;

    public Fish(int number, int r, int c, int dir) {
        this.number = number;
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
