import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        char [] str = br.readLine().toCharArray();
        int [] index = new int[26];
        Arrays.fill(index, -1);

        for(int i=0; i<str.length; i++){
            int cur = str[i] - 'a';
            if(index[cur] != -1){
                continue;
            }
            index[cur] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : index){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

}