
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_hight = 0;
        int min_hight = 100;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+2][N+2];
        boolean[][] visited = new boolean[N+2][N+2];
        for(int i  = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                max_hight = Math.max(max_hight, a);
                min_hight = Math.min(min_hight, a);
            }
        }
        
        if(max_hight == min_hight){
            System.out.println(1);
            System.exit(0);
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int max = 0;
        for(int a = min_hight; a <= max_hight; a++ ) {
            visited = new boolean[N+2][N+2];
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > a && !visited[i][j]) {
                        cnt++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] xy = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int next_x = xy[0] + dx[k];
                                int next_y = xy[1] + dy[k];

                                if (visited[next_x][next_y] || arr[next_x][next_y] <= a) continue;
                                queue.add(new int[]{next_x, next_y});
                                visited[next_x][next_y] = true;

                            }

                        }

                    }



                }
            }
        
            max = Math.max(max,cnt);
        }
        System.out.println(max);
    }

    }

