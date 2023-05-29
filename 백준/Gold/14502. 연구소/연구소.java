

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map, copy;
    public static int N, M;
    public static Queue<int[]> queue;
    public static int max = Integer.MIN_VALUE;

    public static void bfs() {
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = xy[0] + dx[i];
                int next_y = xy[1] + dy[i];

                if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M && map[next_x][next_y] == 0) {
                    map[next_x][next_y] = 2;
                    queue.add(new int[]{next_x, next_y});
                }
            }
        }
    }

    public static void dfs(int wall) {
        if (wall == 3) {
            copyMap();
            bfs();
            int cnt = countSafeAreas();
            max = Math.max(max, cnt);
            restoreMap();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void copyMap() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(map[i], M);
        }
    }

    public static int countSafeAreas() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void restoreMap() {
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(copy[i], M);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }
}
