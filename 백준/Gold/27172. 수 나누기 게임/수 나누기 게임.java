import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int points [] = new int[N+1];
        int nums [] = new int[N+1];

        // 카드 번호, 플레이어 번호
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());

            nums[i] = cur;
            map.put(cur, i);
        }

        for(int i=0; i<N; i++){
            int cur = nums[i];
            int count = 0;
            for(int j= cur*2; j <= 1000000; j += cur){
                if(map.containsKey(j)){
                    points[map.get(j)]--;
                    count++;
                }
            }
            points[i] += count;
        }

        for(int i=0; i<N; i++){
            bw.write(points[i] +" ");
        }
        bw.flush();
    }



}

