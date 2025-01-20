import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int [] m = new int[N];
        int [] w = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            m[i] = Integer.parseInt(st1.nextToken());
            w[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(m);
        Arrays.sort(w);

        int wIdx = 0;
        int count = 0;
        for(int i=N-1; i>=0; i--){
            // 키가 더 큰 여성을 만나기
            if(m[i] > 0){
                // 여자는 키가 더 작은 남성을 만나기 원하고, 실제 더 커야함
                if(w[wIdx] < 0 && Math.abs(w[wIdx]) > m[i]){
                    count++;
                    wIdx++;
                    continue;
                }

            }
            // 키가 더 작은 여성 만나기
            else{
                while(wIdx<N && w[wIdx] < 0){
                    wIdx++;
                }
                if(wIdx >= N){
                    break;
                }

                // 여자는 키가 더 큰 남성을 만나기 원하고, 실제로 더 작아야함
                if(w[wIdx] > 0 && w[wIdx] < Math.abs(m[i])){
                    count++;
                    wIdx++;
                    continue;
                }
            }

        }

        System.out.println(count);
    }
}

/*
5
-18 -16 -10 10 120
-10 -8 10 100 121
 */