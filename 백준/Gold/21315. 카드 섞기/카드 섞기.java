import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int [] run(int N, int [] after){

        // 2^k < N 을 만족하는 Max K
        int maxK = getMaxK(N);

        for(int i=1; i<=maxK; i++){
            for(int j=1; j<=maxK; j++){
                Queue<Integer> base = new LinkedList<>();
                for(int n=N; n>=1; n--){
                    base.add(n);
                }

                mixCards(base, i, j);

                // 오리진과 같은지
                int [] result = queToArray(base);
                if(isSame(result, after)){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }

    private boolean isSame(int [] arr1, int [] arr2){
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    private int[] queToArray(Queue<Integer> base) {
        int [] result = new int[base.size()];
        for(int i=result.length-1; i>=0; i--){
            result[i] = base.poll();
        }
        return result;
    }

    private void mixCards(Queue<Integer> base, int k1, int k2){
        mixCard(base, k1);
        mixCard(base, k2);
    }

    private void mixCard(Queue<Integer> base, int k){
        Queue<Integer> temp = new LinkedList<>();
        // 밑에서 2^K개의 카드를 더미의 맨 위로 올린다.
        for(int i=0; i<Math.pow(2, k); i++){
            temp.offer(base.poll());
        }

        for(int i=2; i<= k+1; i++){
            int size = temp.size();
            int cnt =0;
            for(int c = 0; c<Math.pow(2, k-i+1); c++){
                cnt++;
                temp.offer(temp.poll());
            }
            // 아직 남아있는 거는 base로
            while(cnt < size){
                base.offer(temp.poll());
                cnt++;
            }
        }
        while (!temp.isEmpty()){
            base.offer(temp.poll());
        }
    }
    private int getMaxK(int N){
        int k= 0;
        int cur = 1;

        while(true){
            cur *=2;
            k++;
            if(cur >= N){
                break;
            }
        }
        return k-1;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String [] numStr = br.readLine().split(" ");
        int [] nums = new int[numStr.length];

        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }

        // k는 1 ~ 9 까지. 81개의 경우
        int [] resut = new Main().run(N, nums);
        System.out.println(String.format("%d %d", resut[0], resut[1]));

    }


}

