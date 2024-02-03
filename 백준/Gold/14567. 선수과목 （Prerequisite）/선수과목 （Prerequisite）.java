import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static ArrayList<Integer> [] preSubjects;
    static int [] minTerms;
    public static void main(String [] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        preSubjects = new ArrayList[N+1];
        minTerms = new int[N+1];
        Arrays.fill(minTerms, 1);
        for(int i=1; i<= preSubjects.length-1; i++){
            preSubjects[i] = new ArrayList<>();
        }

        // 선수과목 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            preSubjects[A].add(B);
        }

        for(int i=1; i<= N; i++){

            for(int preSubject : preSubjects[i]){
                minTerms[preSubject] =Math.max( minTerms[i] +1, minTerms[preSubject]);
            }
        }

        for(int i=1; i<minTerms.length; i++){
            bw.write(minTerms[i] + " ");
        }
        bw.flush();
    }
}
