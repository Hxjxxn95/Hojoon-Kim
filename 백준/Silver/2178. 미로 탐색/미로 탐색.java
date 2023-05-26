import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+2][M+2];
        boolean[][] visited = new boolean[N+2][M+2];

        for(int i = 1; i <= N; i++){
            String a = br.readLine();
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(a.charAt(j-1)));
            }
        }

        int cnt = 0;
        visited[1][1] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});

        while(!queue.isEmpty()) {

            int[] xy = queue.poll();

            for(int i = 0; i < 4; i++){
                int next_x = xy[0] + dx[i];
                int next_y = xy[1] + dy[i];

                if( visited[next_x][next_y] || arr[next_x][next_y] == 0) continue;

                queue.add(new int[] {next_x , next_y});
                visited[next_x][next_y] = true;

                arr[next_x][next_y] = arr[xy[0]][xy[1]] +1;
            }
        }

        System.out.println(arr[N][M]);
    }
}