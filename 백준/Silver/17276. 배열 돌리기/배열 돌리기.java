import java.io.*;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t= 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 음수이면 360도에서 빼기
            d = (d <0)? 360+d : d;

            int [][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = d/45;
            int [][] result = rotation(map, count);

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    bw.write(map[i][j] +" ");
                }
                bw.write("\n");
            }
        }

        bw.flush();


    }

    public static int[][] rotation(int [][] map, int count){
        int length = map.length;
        for(int r=0; r<count; r++){
            int [][] newMap = new int[length][length];

            // 1. 주 대각선 회전
            for(int i=0; i<length; i++){
                newMap[i][length/2] = map[i][i];
            }
            // 2. 가운데 열 회전
            for(int i=0; i<length; i++){
                newMap[i][length-1-i] = map[i][length/2];
            }
            // 3. 부대각선 옮기기
            for(int i=0; i<length; i++){
                newMap[length/2][length-1-i] = map[i][length-1-i];
            }
            // 4. 가운데 행 옮기기
            for(int i=0; i<length; i++){
                newMap[i][i] = map[length/2][i];
            }
            // 5. 나머지 원소 옮기기
            for(int i=0; i<length; i++){
                for(int j=0; j<length; j++){
                    if(newMap[i][j] != 0)
                        map[i][j] = newMap[i][j];
                }
            }
        }
        return map;
    }


}


