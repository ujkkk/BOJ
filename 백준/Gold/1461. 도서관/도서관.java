import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur > 0 ){
                plus.add(cur);
            }
            else{
                minus.add(cur);
            }
        }

        Collections.sort(minus);
        Collections.sort(plus, Comparator.reverseOrder());
        int ans = 0;

        // 제일 큰 기회비용 찾기
        int pIdx = 0;
        int mIdx = 0;

        if(minus.isEmpty()){
            ans += plus.get(0);
            pIdx = M;
        }
        else if(plus.isEmpty()){
            ans += Math.abs(minus.get(0));
            mIdx = M;
        }
        else{
            if(plus.get(0) > Math.abs(minus.get(0))){
                ans += plus.get(0);
                pIdx = M;
            }
            else{
                ans += Math.abs(minus.get(0));
                mIdx = M;
            }
        }

        // 뒤에 부터 묶기
        while(mIdx < minus.size()){
            ans += Math.abs(minus.get(mIdx)*2);
            mIdx += M;
        }

        while(pIdx < plus.size()){
            ans += Math.abs(plus.get(pIdx)*2);
            pIdx += M;
        }

        System.out.println(ans);
    }
}
