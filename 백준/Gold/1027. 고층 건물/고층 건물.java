import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import javax.swing.Popup;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int [] buildings;
    int max;
    int maxCount;

    public void run () throws IOException {

        N = Integer.parseInt(br.readLine());
        buildings  = new int[N];

        max = -1;
        maxCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 빌딩 하나하나 탐색 시작
        for(int i=0; i<N; i++){
            int count = 0;
            for(int j=i+1; j<N; j++){
                if(i == j)
                    continue;

                //(i,h), (j,h)에 대한 접선의 방정식 구하기
                if(isViewableC(i, j)){
                    count++;
                }
            }

            for(int k=i-1; k>=0; k--){
                if(i == k)
                    continue;

                if(isViewableC(k, i)){
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
            }
        }

        bw.write(maxCount +"\n");
        bw.flush();

    }

    public boolean isViewableC(int b1, int b2){
        // 접선의 방정식 구하기
        double m = (double) (buildings[b2] - buildings[b1]) / (b2-b1);

        // b1, b2 사이에 접하거나 초과하는 건물이 있는지 확인
        for(int i= b1+1; i<b2; i++){
            double standardY = m*(i - b1) + buildings[b1];

            // i빌딩이 접선보다 크거나 접함
            if(standardY <= buildings[i]){
                return false;
            }
        }
        // b1, b2 사이까지 접하거나 초과하는 건물이 없음
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}


