import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       boolean [] isContain = new boolean[42];

       for(int i=0; i<10; i++){
           int remain = Integer.parseInt(br.readLine())%42;
           isContain[remain] = true;
       }

       int count = 0;
       for(int i=0 ; i<isContain.length; i++){
           if(isContain[i]) count++;
       }
        System.out.println(count);
    }



}