import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public int A;
    public int B;

    Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public void run() throws IOException {
        input();
        int result = solution();
        print(result);
    }


    public void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public int solution(){
        int count = 1;
        while(B > A){
            if(B%2== 0){
                B /=2;
            }
            else{
                if(A == 1 && (B-1)/10 == 1){
                    if((B-1)%10 != 0)
                        return -1;
                }
                B = (B-1)/10;
            }
            count++;
        }
        if(A == B)
            return count;
        else
            return -1;
    }

    public void print(int n){
        System.out.println(n);
    }

    public static void main(String [] args) throws IOException{
        new Main().run();
    }
}
