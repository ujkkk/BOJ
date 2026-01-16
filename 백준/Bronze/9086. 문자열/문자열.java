import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T; t++){
            String s = br.readLine();
            sb.append(s.charAt(0));
            sb.append(s.charAt(s.length()-1)).append("\n");
        }
        System.out.println(sb);
    }




}