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

    static int N, M;
    static int [][] map;
    static int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dc ={0, 1, 1, 1, 0, -1, -1,-1};

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<int []> noSand = new LinkedList<>();

        for(int i=0; i<N; i++){
            String [] str = br.readLine().split("");
            for(int j=0; j <M; j++){
                if(str[j].equals(".")){
                    map[i][j] = 0;
                    noSand.add(new int[]{i,j});

                }else{
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
        }

        // 시뮬
        int waveCount = 0;

        while(!noSand.isEmpty()){
            int size = noSand.size();

            waveCount++;
            for(int i=0; i<size; i++){
                int [] cur = noSand.poll();

                for(int j=0; j<dr.length; j++){
                    int nr = cur[0] + dr[j];
                    int nc = cur[1] + dc[j];

                    if(nr <0 || nr >= N || nc <0 || nc >=M){
                        continue;
                    }
                    if(map[nr][nc] == 0){
                        continue;
                    }
                    map[nr][nc]--;

                    if(map[nr][nc] == 0){
                        noSand.add(new int[]{nr,nc});
                    }
                }
            }
        }
        System.out.println(waveCount -1);
    }
}

