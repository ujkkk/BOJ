
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.String;
import java.util.StringTokenizer;


class Main {
    public static int [][] map;
    public static int n;
    public static int result = Integer.MAX_VALUE;
    public static boolean [][] isFlower;
    public static boolean [][] isVisited;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // map 완성
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                isFlower = new boolean[n][n];

                isVisited[i][j] = true;
                dfs(i, j, 0,0);
            }
        }
        bw.write(result +"\n");
        bw.flush();

        bw.close();
        br.close();

    }

    public static void dfs(int r, int c, int depth, int sum){
        if(depth == 3){
            result = Math.min(result, sum);
            return;
        }

        int [] dr ={0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};

        int i;
        for(i=0; i< dr.length; i++){
            //if(isRange(r+dr[i], c + dc[i]))
                //isVisited[r+dr[i]][c + dc[i]] = true;

            if(!isRange(r+dr[i], c + dc[i]) || isFlower[r+dr[i]][c+dc[i]]) {
                break;
            }
        }

        // 꽃을 피울 수 있는 기회
        if(i == dr.length){
            sum += map[r][c];
            isFlower[r][c] = true;

            for(i=0; i< dr.length; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                isFlower[newR][newC] = true;
                sum += map[newR][newC];
            }

           for(int a =0; a<n; a++){
               for(int b =0; b<n; b++){
                   if(!isFlower[a][b]){
                       dfs(a,b, depth +1, sum);

                       }
                   }
                }

            isFlower[r][c] = false;
            //isVisited[r][c] = false;

            for(i=0; i< dr.length; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                isFlower[newR][newC] = false;
               // isVisited[newR][newC] = false;
           }

        }



    }

    public static boolean isRange(int r, int c){
        if(r >=0 && r< n && c >=0 && c <n)
            return true;
        return false;
    }
}



