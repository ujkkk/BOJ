
// BinarySearch
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int[] arr = new int[n];
        
        // 그리고 가장 입국 심사대에서 오래 걸리는 시간을 max_value 로 구함
        int max_value = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(max_value, arr[i]);
        }
      
        long left = 0L;
        long right = (max_value) * 1000000000L;

        long ans = 0L;
        while (left< right){
            long mid = (left+right) / 2;
            
            // mid초 일 때 각 입국 심사대에서 보낼 수 있는 수를 카운트 해줌
            long cnt = 0;
            for(int i=0;i<n;i++){
                cnt += (mid / arr[i]);
                
                if(cnt >= m) break; // 통

            }
            
            // 비교 후 탐색 범위 변경
            if(cnt >= m){
                right = mid;
                
            }  else if (cnt < m){
                left = mid +1;

            }
        }

        System.out.println(right);

    }
}