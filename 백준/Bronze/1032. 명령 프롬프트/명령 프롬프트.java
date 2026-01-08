import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       int N = Integer.parseInt(br.readLine());
       String [] strs = new String[N];
       for(int i=0; i<N; i++){
           strs[i] = br.readLine();
       }
       StringBuilder sb = new StringBuilder();

       for(int i=0; i<strs[0].length(); i++){

           char first = strs[0].charAt(i);
           int j;
           for(j=1; j<N; j++){
               if(strs[j].charAt(i) != first){
                   break;
               }
           }
           if(j != N){
               sb.append("?");
           }
           else{
               sb.append(first);
           }
       }
        System.out.println(sb.toString());
    }

}