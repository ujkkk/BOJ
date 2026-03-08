import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       int A = Integer.parseInt(br.readLine());
       int B = Integer.parseInt(br.readLine());
       int C = Integer.parseInt(br.readLine());

       int sum = A * B * C;
       String numStr = Integer.toString(sum);

       int [] counts = new int[10];
       for(char c : numStr.toCharArray()){
           counts[c-'0']++;
       }

       StringBuilder sb = new StringBuilder();
       for(int i=0 ;i<counts.length; i++){
           sb.append(counts[i]).append("\n");
       }
        System.out.println(sb);
    }



}