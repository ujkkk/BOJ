import java.io.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        long ans = N*4;
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}