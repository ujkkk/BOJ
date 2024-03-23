import java.io.*;
import java.util.*;

public class Main {

    // x, y
    // 길이가 6이고 (3*2) 1번째 수와 5번째 수가 같은 수열의 개수
    // 분할 정복처럼 재귀 통해 n -> 1까지 수열에 담아둠. 시작 인덱스 , 끝 인덱스
    // 1의 자리까지 완료 되었으면, x번째 수와 y 번째 수가 만족하는지 체크
    public static int x, y, n;
    public static int nums [];
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        nums = new int[2*n +1];

        solution(n);
        System.out.println(count);

    }
    public static void solution(int n){
        if(n == 0){
            if(nums[x] == nums[y])
                count++;
            return;
        }
        for(int i=1; i+n+1 < nums.length; i++){
            if(nums[i] == 0 && nums[i+n+1] == 0){
                nums[i] = n;
                nums[i+n+1] = n;
                solution(n-1);
                nums[i] = 0;
                nums[i+n+1] = 0;
            }

        }
    }

}



