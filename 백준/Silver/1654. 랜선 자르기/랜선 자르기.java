import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K =  Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 수
        int [] lanCable = new int[K];
        int max = 0;
        for(int i=0; i<K; i++){
            lanCable[i] = Integer.parseInt(br.readLine());
            max = Math.max(lanCable[i], max);
        }

        long right = max;
        long left = 1;
        long result = 0;
        while (left <= right){
            // 랜선의 길이
            long mid = (left+right)/2L;
            long count = 0;
            for(int i=0; i<K; i++){
                count += lanCable[i]/mid;
            }
            if(count>= N){
                left = mid+1;
                result= Math.max(result, mid);
            }else{
                right = mid-1;
            }

        }
        bw.write(result+"\n");
        bw.flush();
    }

}
