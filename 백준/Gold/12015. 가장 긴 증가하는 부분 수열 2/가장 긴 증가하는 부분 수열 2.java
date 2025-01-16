import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        int size = 0;
        StringTokenizer st= new StringTokenizer(br.readLine());

        nums[0] = Integer.parseInt(st.nextToken());
        size++;
        for(int i=0; i< N-1; i++){
            int n = Integer.parseInt(st.nextToken());

            if(n < nums[0]){
                nums[0] = n;
            }
            else if(n > nums[size-1]){
                nums[size] = n;
                size++;
            }
            else{
                // 자기 보다 큰거 찾기
                int left = 0;
                int right = size-1;

                while(left<right){
                    int mid = (left+right)/2;

                    if(nums[mid] < n){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                nums[left] = n;
            }
        }
        System.out.println(size);
    }

}

