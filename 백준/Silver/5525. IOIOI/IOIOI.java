import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char [] S = br.readLine().toCharArray();

        String IOI = "";
        for(int i=1; i<= 2*N+1; i++){
            if(i%2 == 1){
                IOI += "I";
                continue;
            }
            IOI += "O";
        }

        char [] tempString = new char[IOI.length()];

        int ans = 0;
        for(int i=0; i<=M-IOI.length(); i++){
            System.arraycopy(S, i, tempString,0, IOI.length());
            String temp = new String(tempString);
            if(temp.equals(IOI))
                ans++;
        }
        bw.write(ans +"\n");
        bw.flush();

        bw.close();
        br.close();
    }


}

