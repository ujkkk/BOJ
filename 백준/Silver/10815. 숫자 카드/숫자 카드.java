import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hasNum = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            hasNum.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int value = Integer.parseInt(st.nextToken());
            int result = hasNum.contains(value)? 1:0;
            bw.write( result+ " ");
        }

        bw.flush();
    }



}


