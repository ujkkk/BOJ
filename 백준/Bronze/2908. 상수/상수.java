import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int max = Math.max(getReverseNumber(s1), getReverseNumber(s2));
        System.out.println(max);
    }


    public static int getReverseNumber(String s){
        int n = 0;
        for(int i=s.length()-1; i>=0; i--){
            n += (int)(s.charAt(i) - '0');
            n *= 10;
        }
        return n/10;
    }


}