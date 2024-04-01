import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int [] result = new int[3];
    public static int map [][];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(N, new Point(0,0));

        for (int i : result) {
            bw.write(i+"\n");
        }

        bw.flush();
    }

    public static void solution(int N, Point start){
        int value = map[start.r][start.c];

        if(N == 1){
            apply(value, N);
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 중간에 다른 것이 있을 때
                if(map[start.r + i][start.c+j] != value){
                    int newN = N/3;
                    // 9등분하기
                    for(int r=0; r<3; r++){
                        for(int c=0; c<3; c++){
                            solution(newN, new Point(start.r +r*newN, start.c+ c*newN));
                        }
                    }
                    
                    return;
                }
            }
        }

        // 모두가 같은 값으로 이뤄진 종이라면 장 수 추가
        apply(value, N);
    }

    public static void apply(int value, int N){
        // 결과 반영
        if(value == -1)
            result[0]++;
        else if(value == 0)
            result[1]++;
        else if(value == 1)
            result[2]++;
    }


}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}




