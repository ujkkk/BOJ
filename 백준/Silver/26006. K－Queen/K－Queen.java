import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static List<int[]> queens = new ArrayList<>();
    static int[] king;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        king = new int[]{r, c};

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            queens.add(new int[]{r,c});
        } // 입력 끝


        int [] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int [] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        int attackCount = 0;
        for(int d=0; d<dr.length; d++){
            int nr = king[0] + dr[d];
            int nc = king[1] + dc[d];

            // 범위를 벗어난 경우 판단을 위해 공격 카운팅을 증가시킴
            if(nr <1 || nr >N || nc <1 || nc >N){
                attackCount++;
                continue;
            }

            for(int [] queen : queens){
                if(isAttack(nr, nc, queen[0], queen[1])){
                    attackCount++;
                    break;
                }
            }
        }

        // 현재 공격받고 있는지 확인
        boolean isAttacking = false;
        for(int [] queen : queens){
            if(isAttack(king[0], king[1], queen[0], queen[1])){
                isAttacking = true;
                break;
            }
        }

        if(isAttacking){
            if(attackCount < 8){
                System.out.println("CHECK");
            }
            else{
                System.out.println("CHECKMATE");
            }
        }
        else{
            if(attackCount == 8){
                System.out.println("STALEMATE");
            }
            else{
                System.out.println("NONE");
            }
        }
    }

    public static boolean isAttack(int kingR, int kingC, int queenR, int queenC){
        if(kingR == queenR){
            return true;
        }
        if(kingC == queenC){
            return true;
        }
        if(kingR -queenR == kingC-queenC){
            return true;
        }
        if(kingR-queenR == (-1)*(kingC-queenC)){
            return true;
        }
        return false;
    }

}