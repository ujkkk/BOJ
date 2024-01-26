import java.io.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            bw.write(1+"/"+1);
        }
        else {

            int row = 1;
            int cur = 1;
            while (true) {
                cur += row;
                row++;

                if (N >= cur && N < cur + row) {
                    // 짝수 행이면 앞부터 시작
                    int bunmo = row;
                    int bunja = 1;

                    while (cur != N) {
                        bunmo--;
                        bunja++;
                        cur++;
                    }
                    if (row % 2 == 0) {
                        bw.write(bunja + "/" + bunmo);
                    } else {
                        bw.write(bunmo + "/" + bunja);
                    }
                    break;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();

    }

}