
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M;
    public static Queue<int[]> queue;
    public static Queue<int[]> queue2;
    public static int[][] map;
    public static boolean[][] visited;
    public static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
        set = new HashSet<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < M; j++){

                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);

                if(map[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        if(!set.contains(0)){
            System.out.println(0);
            System.exit(0);
        }


        int[] dx = {1,-1,0,0,};
        int[] dy = {0,0,1,-1};

        int cnt = 0;

        while(!queue.isEmpty()){

            int[] xy = queue.poll();

            for(int i = 0; i < 4; i++){

                int next_x = xy[0] + dx[i];
                int next_y = xy[1] + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M || map[next_x][next_y] == -1 || visited[next_x][next_y]) continue;

                visited[next_x][next_y] = true;
                map[next_x][next_y] = 1;
                queue2.add(new int[] {next_x,next_y});
            }
            if(queue.isEmpty()){
                cnt++;
                while(!queue2.isEmpty()){
                    queue.add(queue2.poll());
                }
            }
        }
       for(int i = 0; i < N; i++){
           for(int j = 0; j < M; j++){
               if(map[i][j] == 0){
                   System.out.println(-1);
                   System.exit(0);
               }
           }
       }

        System.out.println(cnt-1);
    }
}
