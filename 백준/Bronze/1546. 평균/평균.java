import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] num = new int[N];
        double max = 0;
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, num[i]);
        }

        // 평균구하기
        double sum = 0;
        for(int i=0; i<N; i++){
            sum += (num[i]/max*100);
        }
        System.out.println(sum/N);
    }
}
