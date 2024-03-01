import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            int [] nums = new int [k];
            for(int i=0; i<k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 조합
            combi(nums, 0, 1, new int[k]);
            bw.write("\n");
        }
        bw.flush();

    }

    public static void combi(int [] nums, int idx, int depth, int [] select) throws IOException{
        if(depth == 7){
            for(int i=1; i<7; i++){
                bw.write(select[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=idx; i<nums.length; i++){
            select[depth] = nums[i];
            combi(nums, i+1, depth+1, select);
        }
    }






}

