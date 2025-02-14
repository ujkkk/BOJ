import java.util.*;

public class Main {
    static int N, M;
    static int [][] map;
    static int [] dr = {0, 1, 0, -1};
    static int [] dc = {1, 0, -1, 0};

    public static int getGold(int k, int r, int c, boolean [][] check){
        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(Math.abs(i-r) + Math.abs(j-c) <= k){
                    count += map[i][j];
                }
            }
        }
        return count;
    }

    public static int solution(){
        int max = 0;
        for(int k=0; k<=2*(N-1); k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    boolean [][] check = new boolean [N][N];
                    int sum = getGold(k, i, j, check);
                    // 3. 최대치 계산 - 재귀(k) - k^2 + (k+1)^2
                    if(sum*M - k*k - (k+1)*(k+1) >=  0){
                        max = Math.max(sum, max);
                    }
                }
            }
            
        }
       return max;
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
    }
    public static void main(String[] args) {
        // 입력
        input();

        // solution
        System.out.println(solution());
    }
}