import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            // 옷 종류 입력 받기
            for(int i=0; i<N; i++){
                String [] clothes = br.readLine().split(" ");
                String kind = clothes[1];
                map.put(kind, map.getOrDefault(kind,0) +1);
            }

            String [] kinds = map.keySet().toArray(new String[0]);
            int ans = 1;
            for(int i=0; i<kinds.length; i++){
                ans *= (map.get(kinds[i])+1);
            }
            bw.write((ans-1)+"\n");

        }


        bw.flush();

        bw.close();
        br.close();
    }


}
