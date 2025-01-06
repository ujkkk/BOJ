import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] cogWheels;
    static int [] d;
    public static void main(String[] args) throws IOException {

        cogWheels = new int[5][8];
        d = new int[5];

        for(int i=1;i<=4; i++){
            String [] cogWheel = br.readLine().split("");
            for(int j=0; j<8; j++){
                cogWheels[i][j] = Integer.parseInt(cogWheel[j]);
            }
        }

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int originDir = dir;

            if(number == 1){
                d[1] = dir;

                for(int n=1; n<=3; n++){
                    if(cogWheels[n][2] != cogWheels[n+1][6]){
                        d[n+1] = d[n]*(-1);
                    }
                    else
                        d[n+1] = 0;
                }
            }

            else if(number == 2){
                d[2] = dir;
                for(int n=2; n<=3; n++) {
                    if (cogWheels[n][2] != cogWheels[n + 1][6]) {
                        d[n + 1] = d[n] * (-1);
                    }
                    else
                        d[n+1] = 0;
                }

                if (cogWheels[1][2] != cogWheels[2][6]) {
                    d[1] = d[2] * (-1);
                }
                else
                    d[1] = 0;

            }

            else if(number == 3){
                d[3] = dir;
                for(int n=3; n<=3; n++) {
                    if (cogWheels[n][2] != cogWheels[n + 1][6]) {
                        d[n + 1] = d[n] * (-1);
                    }
                    else
                        d[n+1] = 0;
                }

                for(int n=2; n>=1; n--){
                    if (cogWheels[n][2] != cogWheels[n+1][6]) {
                        d[n] = d[n+1] * (-1);
                    }
                    else
                        d[n] = 0;
                }

            }

            else if(number == 4){
                d[4] = dir;
                for(int n=3; n>=1; n--){
                    if (cogWheels[n][2] != cogWheels[n+1][6]) {
                        d[n] = d[n+1] * (-1);
                    }
                    else
                        d[n] = 0;
                }

            }

            rotate();
        }

        // 결과
        int ans = 0;
        for(int i=1; i<=4; i++){
            if(cogWheels[i][0] == 1){
                ans += (int)Math.pow(2, i-1);
            }
        }
        System.out.println(ans);
    }

    private static void rotate(){
        for(int i=1 ; i<=4; i++){
            // 반시계 방향으로 회전
            if(d[i] == -1){
//                System.out.println("############");
//                System.out.println(a+ "번 반시계 방향 회전");
//                for(int i=0; i<=7; i++) {
//                    System.out.print(cogWheels[a][i] +" ");
//                }
//                System.out.println();
                int temp = cogWheels[i][0];

                for(int j=0; j<7; j++){
                    cogWheels[i][j] = cogWheels[i][j+1];
                }
                cogWheels[i][7] = temp;

            }
            // 시계 방향으로 회전
            else if(d[i] == 1){
//                System.out.println("############");
//                System.out.println(a+ "번 시계 방향 회전");
//                for(int i=0; i<=7; i++) {
//                    System.out.print(cogWheels[a][i] +" ");
//                }
//                System.out.println();
                int temp = cogWheels[i][7];

                for(int j=6; j>=0; j--){
                    cogWheels[i][j+1] = cogWheels[i][j];
                }
                cogWheels[i][0] = temp;
            }
        }

//
//        for(int i=0; i<=7; i++) {
//            System.out.print(cogWheels[a][i] +" ");
//        }
//        System.out.println();
    }

}
