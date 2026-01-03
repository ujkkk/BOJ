import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char[] map = new char[25];

    static List<Integer> sIndices = new ArrayList<>();
    static List<Integer> yIndices = new ArrayList<>();

    static int[] selected = new int[7];

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        // 입력 처리: 2차원 배열 대신 1차원(0~24)으로 펴서 저장
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                int idx = i * 5 + j; // (r, c) -> 0~24 인덱스 변환
                map[idx] = str.charAt(j);
                if (map[idx] == 'S') {
                    sIndices.add(idx);
                } else {
                    yIndices.add(idx);
                }
            }
        }

        // S파를 4명 ~ 7명 뽑는 경우의 수 순회
        // S파 인원이 결정되면, 나머지는 자동으로 Y파 인원이 됨 (7 - i)
        for (int i = 4; i <= 7; i++) {
            if (sIndices.size() < i) continue; // S파 전체 인원보다 많이 뽑을 순 없음

            // Step 1: S파 뽑기 시작
            selectS(0, 0, i);
        }

        System.out.println(ans);
    }

    /**
     * S파 학생을 조합으로 선택하는 함수
     * @param listIdx : sIndices 리스트에서 탐색할 인덱스
     * @param selIdx  : selected 배열에 채워넣을 인덱스 (0부터 시작)
     * @param targetCount : 뽑아야 할 S파 학생 수
     */
    static void selectS(int listIdx, int selIdx, int targetCount) {
        // 목표한 S파 인원을 다 채웠다면, 이제 Y파를 채우러 감
        if (selIdx == targetCount) {
            selectY(0, selIdx);
            return;
        }

        for (int i = listIdx; i < sIndices.size(); i++) {
            selected[selIdx] = sIndices.get(i); // 객체 생성 없이 정수값만 복사
            selectS(i + 1, selIdx + 1, targetCount);
        }
    }

    /**
     * Y파 학생을 조합으로 선택하는 함수
     * @param listIdx : yIndices 리스트에서 탐색할 인덱스
     * @param selIdx  : selected 배열에 이어서 채워넣을 인덱스 (S파 이후부터)
     */
    static void selectY(int listIdx, int selIdx) {
        // 7명을 모두 다 채웠다면 (S파 + Y파 = 7명) 연결 확인
        if (selIdx == 7) {
            if (checkConnection()) {
                ans++;
            }
            return;
        }

        for (int i = listIdx; i < yIndices.size(); i++) {
            selected[selIdx] = yIndices.get(i);
            selectY(i + 1, selIdx + 1);
        }
    }

    /**
     * 선택된 7명이 상하좌우로 연결되어 있는지 BFS로 확인
     * (boolean[5][5] 대신 boolean[7] 사용으로 최적화)
     */
    static boolean checkConnection() {
        int[] q = new int[7];
        int head = 0;
        int tail = 0;

        // selected 배열 내에서 방문 여부 체크 (5x5 전체 맵이 아님)
        boolean[] visited = new boolean[7];

        // 첫 번째 사람을 큐에 넣고 시작
        q[tail++] = selected[0];
        visited[0] = true;

        int connectedCount = 1;

        while (head < tail) {
            int curIdx = q[head++];

            // 1차원 인덱스 -> 2차원 좌표 변환
            int r = curIdx / 5;
            int c = curIdx % 5;

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 맵 범위를 벗어나면 패스
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int nIdx = nr * 5 + nc; // 인접한 칸의 1차원 인덱스
                for (int i = 0; i < 7; i++) {
                    if (!visited[i] && selected[i] == nIdx) {
                        visited[i] = true;
                        q[tail++] = selected[i];
                        connectedCount++;
                    }
                }
            }
        }

        return connectedCount == 7;
    }
}