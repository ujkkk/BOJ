import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 에너지 드링크

    public static BufferedReader br;
    public static BufferedWriter bw;

    public double result;
    public int N;
    public int [] drinks;

    public Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        if(bw == null){
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        this.result = 0;
    }

    public void run() throws IOException{
        input();
        solution();
        print();
    }

    public void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        drinks = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            drinks[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void solution(){
        // 내림차순 정렬
        Arrays.sort(drinks);
        result = drinks[drinks.length-1];

        for(int i=0; i<N-1; i++){
            result += (double)(drinks[i])/2;
        }
    }

    public void print() throws IOException {
        bw.write(result+"\n");
        bw.flush();
    }

    public static void main(String [] args) throws IOException{
        new Main().run();
    }

}
