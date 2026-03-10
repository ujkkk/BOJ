import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       StringTokenizer st = new StringTokenizer(br.readLine());
       int H = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       if(M >=45){
           M -= 45;
       }
       else{
           if(H == 0){
               H = 24;
           }
           H--;
           M = M + 60 - 45;
       }
        System.out.println(H + " " + M);
    }



}