import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 숫자의 개수 입력 받기
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        // N자리 문자열 입력 받기
        String sNum = null;
        sNum = scanner.next();

        // 문자 배열로 전환
        char [] cNums = sNum.toCharArray();

        int sum = 0;
        for(int i=0; i< cNums.length; i++) {
            sum += cNums[i] - '0';
        }
        // 결과 출력
        System.out.print(sum);
    }
}