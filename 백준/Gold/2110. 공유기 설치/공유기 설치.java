import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lo = 1; // 최소 간격
        int hi = arr[n-1];  // 최대 간격

        int result = 0;
        while(lo <= hi) {
            int mid = (lo + hi)/2;

            int pos = 0; // 공유기 설치 위치
            int cnt = 1;    // 설치 가능한 공유기 수
            for(int i=1; i<n; i++){
                // 최소 간격이니깐 최소보다 커도 되구나
                if(arr[i] - arr[pos] >= mid){
                    pos = i;
                    cnt++;
                }
            }

            if(cnt < c){    // 설치된 공유기 수가 가지고 있는 공유기 수보다 적으면
                hi = mid-1;
            }
            else{
                result = mid;
                lo = mid+1;

            }
        }
        System.out.println(result);
    }

}