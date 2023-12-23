import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int N;
    public static int result;

    public static int [] mins;
    public static int [] maxs;


    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mins = new int[3];
        maxs =new int[3];

        for(int p=0; p<N; p++){
            String [] nums = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            int n3 = Integer.parseInt(nums[2]);

            if(p==0){
                for(int i=0; i<nums.length; i++){
                    mins[i] = Integer.parseInt(nums[i]);
                    maxs[i] = Integer.parseInt(nums[i]);
                }
                continue;
            }

            int [] preMaxs = maxs.clone();
            int [] preMins = mins.clone();
            for(int i=0; i<3; i++){
                if(i == 0){
                    maxs[i] = Math.max(preMaxs[i+1] +  n1, preMaxs[i] +n1);
                    mins[i] = Math.min(preMins[i+1] +n1, preMins[i] +n1);
                }
                else if(i==1){
                    maxs[i] =   Math.max(Math.max(preMaxs[i-1] + n2 , preMaxs[i]+ n2), preMaxs[i+1]+ n2);
                    mins[i] =  Math.min(Math.min(preMins[i-1]  + n2 , preMins[i]  + n2), preMins[i+1] + n2);
                }else{
                    maxs[i] = Math.max(preMaxs[i-1] +  n3, preMaxs[i] +n3);
                    mins[i] = Math.min(preMins[i-1] +n3, preMins[i] +n3);
                }
            }

        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<3; i++){
            min = Math.min(min, mins[i]);
            max = Math.max(max, maxs[i]);
        }

        System.out.println(max +" " + min);
    }




}
