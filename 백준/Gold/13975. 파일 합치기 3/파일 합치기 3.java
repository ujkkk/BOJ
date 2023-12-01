import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


class Main
{

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            long result=0;
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Long> nums = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<k; i++){
                long key = Integer.parseInt(st.nextToken());
                nums.put(key, nums.getOrDefault(key,0L) +1);
            }

            while(nums.size() != 1){
                // 매번 가장 작은 거 2개를 뽑고 합쳐서 하나로 집어넣기
                long n1 = nums.firstKey();
                if(nums.firstEntry().getValue() == 1){
                    nums.pollFirstEntry();
                } else{
                    nums.put(n1, nums.get(n1)-1);
                }

                long n2 = nums.firstKey();
                if(nums.firstEntry().getValue() == 1){
                    nums.pollFirstEntry();
                } else{
                    nums.put(n2, nums.get(n2)-1);
                }
                result += n1+n2;
                nums.put(n1+n2, nums.getOrDefault(n1+n2,0L) +1);

            }
            bw.write(result+"\n");
        }


        bw.flush();

        bw.close();
        br.close();

    }

}

