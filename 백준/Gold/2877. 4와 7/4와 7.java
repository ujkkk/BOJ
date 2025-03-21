import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());

        List<Integer> bits = new ArrayList<>();
        intToBinary(K+1, bits);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<bits.size(); i++){
            sb.append(bits.get(i)==0? "4" : "7");
        }
        System.out.println(sb.toString());
    }


    public static void intToBinary(int n, List<Integer> bits){
        if (n== 1 || n == 0){
            bits.add(n);
            return;
        }

        intToBinary(n/2, bits);
        bits.add(n%2);
    }

}

