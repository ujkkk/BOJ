import java.io.*;
import java.util.*;

public class Main{
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N;
    public static int [] nums;
    public static int [] oper_N;
    public static int min = Integer.MAX_VALUE -1;
    public static int max = Integer.MIN_VALUE;
    public static int count =0;

    public static void main(String [] args) throws Exception{
         br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));

         N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        oper_N = new int[4];
        nums = new int[N];

        // 수 입력 받기
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력 받기
        int index = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()){
            // 1.더하기, 2. 뺄셈, 3. 곱셈, 4. 나눗셈
            oper_N[index++] = Integer.parseInt(st.nextToken());
        }

        dfs(0, oper_N, nums[0]);

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int[] oper_N, int value){
        if(depth == N-1){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        int cloneValue = value;
        //int [] clone = clone(oper_N);
        for(int i=0; i<oper_N.length; i++){
            if(oper_N[i] == 0) continue;
            oper_N[i]--;
            switch (i){
                case 0:
                    value += nums[depth+1];
                    break;
                case 1:
                    value -= nums[depth+1];
                    break;
                case 2:
                    value *= nums[depth+1];
                    break;
                case 3:
                    value /=nums[depth+1];
                    break;
            }
            dfs(depth+1, oper_N, value);
            oper_N[i]++;
            //oper_N = clone;
            value = cloneValue;
        }
    }

//    public static int [] clone(int[] arr){
//        int [] clone = new int[arr.length];
//        for(int i=0; i<clone.length; i++){
//            clone[i] = arr[i];
//        }
//        return clone;
//    }

}

