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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        int[][] map = new int[N][M];
        int[][] cnt_map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        int[] dx = {1,-1,0,0,};
        int[] dy = {0,0,1,-1};

        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] temp = queue.poll();

                for(int j = 0; j < 4; j++){
                    int next_x = temp[0] + dx[j];
                    int next_y = temp[1] + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M || map[next_x][next_y] == 0
                    || visited[next_x][next_y]){
                        continue;
                    }
                    visited[next_x][next_y] = true;
                    cnt_map[next_x][next_y] = cnt;
                    queue.add(new int[] {next_x,next_y});

                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 2 && map[i][j] != 0 && cnt_map[i][j] == 0){
                    cnt_map[i][j] = -1;
                }
                sb.append(cnt_map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
