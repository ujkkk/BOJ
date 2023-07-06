import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 과목 개수 N 입력 받기
        int N = scanner.nextInt();
        // 점수 배열 선언
        int [] scores = new int[N];
        for(int i = 0; i< N; i++){
            scores[i] = scanner.nextInt();
        }

        int nMax =0, sum = 0;
        for(int i=0 ; i<N;i++){
            if(scores[i] > nMax){
                nMax = scores[i];
            }
            sum += scores[i];
        }

        // 결과 계산 후 출력
        System.out.print(sum*100.0/nMax/N);
    }
}