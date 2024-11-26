import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int map [][] = new int[3][3];
        while(true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }

            boolean result = startGame(map, str);
            if(result){
                bw.write("valid\n");
            }else{
                bw.write("invalid\n");
            }
        }
        bw.flush();
    }

    private static boolean startGame(int[][] map, String str) throws IOException {
        // init map
        int xCount = 0;
        int oCount = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map[i][j] = str.charAt(i*3 + j);
                if(map[i][j] == 'X'){
                    xCount++;
                }
                else if(map[i][j] == 'O'){
                    oCount++;
                }
            }
        }

        if(oCount > xCount){
            return false;
        }

        // 연속된 것이 있는지 체크
        boolean isXWin = Check(map, 'X');
        boolean isOWin = Check(map, 'O');

        // 꽉 채울 때
        if(oCount + xCount == 9 && oCount+1 == xCount){
            // 두 말 모두 우승인 경우 제회
            if(isOWin && isXWin){
                return false;
            }
            if(!isOWin && !isXWin){
                return true;
            }
            if(isOWin){
                return false;
            }
            return true;
        }
        else{
            // 두 말 모두 우승인 경우 제회
            if(isOWin && isXWin){
                return false;
            }

            // 꽉 채우지 않았는데 우승자가 없을 때
            if(!isOWin && !isXWin){
                return false;
            }

            if(isOWin && (oCount == xCount)){
                return true;
            }
            if(isXWin && (oCount +1 == xCount)){
                return true;
            }
            return false;
        }
    }
    private static boolean Check(int [][] map, char tiktakto) {

        //가로가 성립할 때
        for(int i=0; i<3; i++) {
            int cnt = 0;
            for(int j=0; j<3; j++) {
                if(map[i][j]==tiktakto) cnt++;
            }
            if(cnt==3) return true;
        }
        //세로로 성립할 때
        for(int j=0; j<3; j++) {
            int cnt = 0;
            for(int i=0; i<3; i++) {
                if(map[i][j]==tiktakto) cnt++;
            }
            if(cnt==3) return true;
        }
        //대각선으로 성립할 때
        if(map[0][0]==tiktakto && map[1][1]==tiktakto
            && map[2][2]==tiktakto) return true;
        if(map[0][2]==tiktakto && map[1][1]==tiktakto
            && map[2][0]==tiktakto) return true;

        return false;
    }
}
