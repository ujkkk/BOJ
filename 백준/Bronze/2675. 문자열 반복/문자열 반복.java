import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T; t++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int i=0; i<s.length(); i++){
                for(int r=0;r<R; r++){
                    sb.append(s.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }




}