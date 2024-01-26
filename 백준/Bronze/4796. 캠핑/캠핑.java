import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int t = 0;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L==0 && P== 0 && V ==0)
                break;

            int sum =0;
            sum += (V/P)*L;
            sum += Math.min(V%P, L);

            t++;
            bw.write("Case " + t+ ": " + sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}