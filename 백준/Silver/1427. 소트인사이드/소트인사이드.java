import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열로 입력 받기
        Scanner sc = new Scanner(System.in);
        String sNum = sc.next();

        // 숫자 배열로 만들기
        char [] cNum = sNum.toCharArray();
        int N = cNum.length;
        int [] nums = new int[N];

        for(int i=0; i< N; i++){
            nums[i] = Character.getNumericValue(cNum[i]);
        }

        // 정렬 (선택 정렬)
        for(int i=0; i < N-1; i++){
            int max = i;
            for(int j= i+1; j< N; j++){
                if(nums[max] < nums[j])
                    max = j;
            }
            if(max != i)
                swap(i, max, nums);
        }

        // 출력
        for(int i=0; i< N; i++){
            System.out.print(nums[i]);
        }

    }

    public static void swap(int first, int second, int [] array){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
