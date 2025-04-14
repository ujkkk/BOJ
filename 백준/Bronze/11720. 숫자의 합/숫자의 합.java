import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String [] str = br.readLine().split("");

        int sum =0;
        for(int i=0; i<str.length; i++){
            sum += Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}
