
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static int Min = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0, 0);
        System.out.println(Min);
    }

    public static void total_score() {
        int star = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    star += arr[i][j];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                }
            }
        }

        int value = Math.abs(star - link);

        if (value == 0) {
            System.out.println(0);
            System.exit(0);
        }

        Min = Math.min(Min, value);
    }

    public static void team(int idx, int cnt) {
        if (cnt == N / 2) {
            total_score();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                team(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
