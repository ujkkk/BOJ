import java.io.*;
import java.util.StringTokenizer;
/*
    다음 블록은 어떻게 선택할지 모르겠다
    1. 현재 좌표는 빼고 넘겨줘야 하는데, 그럼 next 블록의 좌표는 위, 아래, 밑, 중 어디
    현재 좌표에서 선택할 수 있는 방법이 4개나 된다?
    ->

    선택하기 애매하니깐 방문여부를 고려해서 선택
    현재 좌표에서 갈 수 있는 방향은
    1. 현재 좌표
    2. 가로
    3. 세로

    누적값은 어떻게 구하나?
    내가 했던 방향대로, 현재에서 모두 구한 다음에 넘겨준다
    그래서 연결고리를 현재에서 끊는다

    끝은 어떻게 아나?
    depth가 n*m 일 때
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int run(int N, int M, int [][] nums){
        int [] ans = {Integer.MIN_VALUE};
        boolean [][] isSelect =  new boolean[N][M];

        dfs(0, 0, isSelect, nums, ans);

        return ans[0];
    }

    private void dfs(int cur, int sum, boolean [][] isSelect, int [][] nums, int [] ans){
        int N = nums.length;
        int M = nums[0].length;

        if(cur == N*M){
            ans[0] = Math.max(ans[0], sum);
            return;
        }

        int r = cur/M;
        int c = cur %M;
        if(isSelect[r][c]){
            dfs(cur+1, sum, isSelect, nums, ans);
            return;
        }

        // 1. 현재 좌표 선택
        isSelect[r][c] = true;
        dfs(cur+1, sum + nums[r][c], isSelect, nums, ans);


        // 2. 가로 선택
        int curSum = nums[r][c];
        int nc;
        for(nc=c+1; nc<M; nc++){
            if(isSelect[r][nc])
                break;

            isSelect[r][nc] = true;
            curSum = (curSum)*10 + nums[r][nc];
            dfs(cur+1, sum + curSum, isSelect, nums, ans);
        }
        // 되돌리기
        for(int i=c+1; i<nc; i++){
            isSelect[r][i] = false;
        }

        // 3. 세로 선택
        curSum = nums[r][c];
        int nr;
        for(nr=r+1; nr<N; nr++){
            if(isSelect[nr][c])
                break;

            isSelect[nr][c] = true;
            curSum = (curSum)*10 + nums[nr][c];
            dfs(cur+1, sum + curSum, isSelect, nums, ans);
        }
        // 되돌리기
        for(int i=r+1; i<nr; i++){
            isSelect[i][c] = false;
        }

        isSelect[r][c] = false;
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        for(int i=0; i<N; i++){
            String [] str = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(new Main().run(N, M, map));
    }


}

