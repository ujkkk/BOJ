import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] map;
    static boolean [][][] options;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        map = new int[9][9];
        for(int i=0; i<9; i++){
            String [] st = br.readLine().split("");
            for(int j=0; j<9; j++){
                map[i][j] = Integer.parseInt(st[j]);
                if(map[i][j] != 0){
                    count++;
                }
            }
        }

        // 스도쿠 시작
        sudoku(0, 0, 0);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static boolean sudoku(int depth, int r, int c){
        if(depth == 81){
            return true;
        }

        if(c == 9){
            r = r+1;
            c = 0;
        }

        if(map[r][c] != 0)
            return sudoku(depth+1, r, c+1);

        for(int p=1; p<=9; p++){
            if(!isOk(r, c, p))
                continue;

            map[r][c] = p;

            if(sudoku(depth+1, r, c+1)){
                return true;
            }
            map[r][c] = 0;
        }

        return false;
    }

    private static boolean isOk(int r, int c, int n){
        // 한 블록에 내정된 숫자 확인
        for(int i= 0; i< 3; i++){
            for(int j=0; j< 3; j++){
                if(map[r/3 * 3 + i][c/3* 3 + j] == n){
                    return false;
                }
            }
        }

        // 같은 행, 같은 열에 중복된 숫자 있는지 체크
        for(int p=0; p<9; p++){
            if(map[r][p] == n){
                return false;
            }
            if(map[p][c] == n){
                return false;
            }
        }
        return true;
    }
}

