///////////////////////////////////////////
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // 우선 경우의 수를 다 탐색하는 완탐이야
        // 하지만 set을 써서 중복을 모두 지워줬어
        // 그러면 최대 720개까지만 담기거든
        // 6x5x4x3x2x1이니깐!
        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            char[] origin = str[0].toCharArray();
            int count = Integer.parseInt(str[1]);

            String[] list;
            HashSet<String> preSet = new HashSet<>();

            // 처음 수에서 자리 다 바꿔주기
            extracted(origin, preSet);

            for (int i = 1; i < count; i++) {
                HashSet<String> curSet = new HashSet<>();
                // 바꿀 수 있는거 모두 넣기
                Iterator<String> iterator = preSet.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();

                    extracted(key.toCharArray(), curSet);
                }
                preSet = curSet;
            }

            // 제일 큰 값
            Object[] result =preSet.toArray();
            Arrays.sort(result);

            bw.write(String.format("#%d %d\n", t +1, Integer.parseInt((String) result[result.length - 1])));
        }
        bw.flush();
    }

    private static void extracted(char[] origin, HashSet<String> set) {
        // 총 15개
        for (int i = 0; i < origin.length - 1; i++) {
            for (int j = i + 1; j < origin.length; j++) {
                // swap
                char temp = origin[i];
                origin[i] = origin[j];
                origin[j] = temp;

                // set에 넣기
                set.add(String.valueOf(origin));

                // 복구
                origin[j] = origin[i];
                origin[i] = temp;
            }
        }
    }
}