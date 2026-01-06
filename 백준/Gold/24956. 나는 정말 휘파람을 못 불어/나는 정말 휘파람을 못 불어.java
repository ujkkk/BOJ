import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] origin = br.readLine().toCharArray();

        // 1. 2의 거듭제곱 미리 계산 (Precomputation)
        // 최대 N 길이만큼 필요하므로 N+1 크기로 생성
        long[] powerOf2 = new long[N + 1];
        powerOf2[0] = 1;
        for (int i = 1; i <= N; i++) {
            powerOf2[i] = (powerOf2[i - 1] * 2) % MOD;
        }

        // 2. 전체 E의 개수 세기
        int totalE = 0;
        for (char c : origin) {
            if (c == 'E') {
                totalE++;
            }
        }

        long ans = 0;
        long currentW = 0; // 현재까지 만난 W의 개수
        int currentE = totalE; // 현재 위치보다 뒤에 있는 E의 개수

        // 3. 문자열 순회하며 계산
        for (char c : origin) {
            if (c == 'W') {
                currentW++; // W 누적
            } else if (c == 'E') {
                currentE--; // 내 뒤에 있는 E의 개수가 하나 줄어듦
            } else if (c == 'H') {
               
                if (currentE < 2) continue; // 뒤에 E가 2개 미만이면 못 만듦

                long combinationSum = (powerOf2[currentE] - currentE - 1);
                // 뺄셈 후 음수가 될 수 있으므로 MOD를 더해줌
                while (combinationSum < 0) {
                    combinationSum += MOD;
                }
                combinationSum %= MOD;

                ans = (ans + (currentW * combinationSum) % MOD) % MOD;
            }
        }

        System.out.println(ans);
    }
}