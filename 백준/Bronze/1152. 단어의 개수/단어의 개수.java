import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       String [] strs = br.readLine().split(" ");

       int cnt=0;
       for(String s : strs){
           if(s.isEmpty()) continue;
           cnt++;
       }
        System.out.println(cnt);
    }



}