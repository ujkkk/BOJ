import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            nums.add(i+1);
        }

        List<Integer> finds = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            finds.add(Integer.parseInt(st.nextToken()));
        }

        // 찾기
        int count = 0;
        for(int find : finds){
            int idx = 0;
            for(int num : nums){
                if(num == find){
                    break;
                }
                idx++;
            }
            if(nums.get(0) == find){
                nums.remove(0);
                continue;
            }
            int front = idx;
            int back = nums.size() -idx +1;

            if(front < back){
                while(nums.get(0) != find){
                    int temp = nums.get(0);
                    nums.remove(0);
                    nums.add(temp);
                    count++;
                }
//                System.out.print("뽑기전 ");
//                print(nums);
                nums.remove(0);
            }
            else{
                int size = nums.size();
                while(nums.get(size-1) != find){
                    int temp = nums.get(size-1);
                    nums.remove(size-1);
                    nums.add(0, temp);
                    count++;
                }
                count++;
//                System.out.print("뽑기전 ");
//                print(nums);
                nums.remove(size-1);
            }
//            System.out.print("뽑은 후 ");
//            print(nums);
        }
        bw.write(count+"\n");
        bw.flush();
    }

    public static void print(List<Integer> list){
        for(int n : list){
            System.out.print(n +" ");
        }
        System.out.println("\n");
    }
}
