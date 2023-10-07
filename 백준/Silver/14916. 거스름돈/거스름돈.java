import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br;
    public int n;
    public int count;

    public Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        count = 0;
    }

    public void run() throws Exception{
        getInput();
        solution();
        print();
    }

    public void getInput() throws Exception {
        n = Integer.parseInt(br.readLine());
    }

    public void solution(){
        int remainValue;
        count = n/5;
        while(count >= 0){
            remainValue = n - (5*count);
            if(remainValue %2 == 0){
                count += remainValue/2;
                break;
            }
            else{
                count--;
            }
        }
    }

    public void print(){
        System.out.println(count);
    }
    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}

