import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<Integer, String> hashNum = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            hash.put(name, i);
            hashNum.put(i, name);
        }

        for(int i=0; i<M; i++){
            String str = null;
            try{
                str = br.readLine();
                int n = Integer.parseInt(str);
                bw.write(hashNum.get(n) + "\n");
            }catch (NumberFormatException e){
                // 문자열 일 떄
                bw.write(hash.get(str) + "\n");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }


}
