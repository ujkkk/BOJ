import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br;

    public static void main(String [] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] diffs = new int[N-1];
        int pre_num = 0;
        int cur_num = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(i == 0){
                pre_num = Integer.parseInt(st.nextToken());
                continue;
            }
            cur_num = Integer.parseInt(st.nextToken());
            int diff = cur_num - pre_num;
            diffs[i-1] = diff;

            pre_num = cur_num;
        }

        Arrays.sort(diffs);

        int result = 0;
        for(int i=0; i< N-K; i++){
            result += diffs[i];
        }

        System.out.println(result);

    }


}
