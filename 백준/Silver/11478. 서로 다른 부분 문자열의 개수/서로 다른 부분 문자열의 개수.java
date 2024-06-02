import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        String str = br.readLine();

        int length = str.length();

        HashSet<String> set = new HashSet();
        for(int i=0; i<length; i++){
            for(int j=i+1; j<=length; j++){
                String cur = str.substring(i,j);
                set.add(cur);
            }
        }
        bw.write(set.size()+"");
        bw.flush();
    }



}


