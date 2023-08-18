import java.io.*;
import java.util.*;

public class Main {
    public static int sorted [];
    public static void main(String[] args) throws IOException {

        // 1.입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        sorted = new int[N*2];

        // 2.정렬
        //Arrays.sort(A);
        merge_sort(A, 0, N-1);

        // 3.출력
        for(int i=0; i<N; i++){
            bw.write(A[i]+"\n");
            //System.out.println(A[i]);
        }
        bw.flush();
        bw.close();
    }

    public static void merge(int list[], int left, int mid, int right){

        int i,j,k,l;
        i =left; j = mid+1; k = left;
        /* 분할 정복된 list의 합병 */
        while (i <= mid && j <= right){
            if(list [i] <= list[j]){
                sorted[k++] = list[i++];
            }else{
                sorted[k++] = list[j++];
            }
        }
        if(i>mid){
            for(l=j ; l <= right; l++){
                sorted[k++] = list[l];
            }
        }
        else{
            for(l=i ; l <= right; l++){
                sorted[k++] = list[l];
            }
        }
        /* 배열 sorted[]의 리스트를 배열 list[]로 복사 */
        for(l=left; l<= right; l++){
            list[l] = sorted[l];
        }
    }

    public static void merge_sort(int list [], int left, int right){
        int mid;
        if(left < right){
            mid = (left + right)/2;
            merge_sort(list, left, mid);
            merge_sort(list, mid+1, right);
            merge(list, left, mid, right);
        }
    }

}
