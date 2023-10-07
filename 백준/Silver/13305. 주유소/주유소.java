import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public long result;
    public int N;
    public int [] oil;
    public int [] load;

    public Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public void run() throws IOException{
        input();
        solution();
        print();
    }
    public void input () throws IOException {
        N = Integer.parseInt(br.readLine());
        load = new int[N];
        oil = new int[N];

        int i =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도로 길이 입력
        while(st.hasMoreTokens()){
            load[i++] = Integer.parseInt( st.nextToken());
        }

        // 기름 가격 입력
        i = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            oil[i++] = Integer.parseInt(st.nextToken());
        }

    }

    public void solution(){
        int i =0;
        int j =1;
        while(i < N-1){
            while (oil[i] < oil[j]){
                result += oil[i]*load[j-1];
                j++;
                if(j>= N) break;
            }
            result += oil[i]*load[j-1];
            i = j++;
        }

    }

    public void print(){
        System.out.println(result);
    }

    public static void main(String [] args) throws IOException{
        new Main().run();
    }
}
