import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;

    /*
        solution :  열을 하나씩 검사한다
            1. 현재 열이 전부 '.'이면 그냥 넘어간다. (숫자 절대 아님)
            2. 현재 열에 '#'이 하나라도 있으면, 그 열을 시작으로 3열을 묶어 0~9(1제외) 중 무엇인지 검사.
            3. 만약 3열 패턴에 맞는 숫자가 없으면 1이다.
         */
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int L = N/5;
        map = new char[5][L];

        // 1. 시그널을 5행 L열의 2차원 배열로 재배치
        for(int i=0; i<5; i++){
            for(int j=0; j<L; j++){
                map[i][j] = str.charAt(i*L + j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<L; j++){
            if(isEmptyColumn(j)) continue;

            // 1은 1열, 나머지는 3열이므로 3열을 먼저 체크
            String num = getNumber(j, L);
            sb.append(num);

            if(num.equals("1")){
                j+=0;
            } else{
                j+=2;
            }
        }
        System.out.println(sb);
    }

    static String getNumber(int col, int maxL){
        if (col + 2 >= maxL) return "1";

        // 3x5 영역을 하나의 문자열로 합침
        StringBuilder shape = new StringBuilder();
        for(int i=0; i<5; i++){
            for(int j=col; j<col+3; j++){
                shape.append(map[i][j]);
            }
        }

        String s = shape.toString();
        if (s.equals("####.##.##.####")) return "0";
        if (s.equals("###..#####..###")) return "2";
        if (s.equals("###..####..####")) return "3";
        if (s.equals("#.##.####..#..#")) return "4";
        if (s.equals("####..###..####")) return "5";
        if (s.equals("####..####.####")) return "6";
        if (s.equals("###..#..#..#..#")) return "7";
        if (s.equals("####.#####.####")) return "8";
        if (s.equals("####.####..####")) return "9";

        return "1";

    }

    static boolean isEmptyColumn(int col){
        for(int i=0; i<5; i++){
            if (map[i][col] == '#') return false;
        }
        return true;
    }
}