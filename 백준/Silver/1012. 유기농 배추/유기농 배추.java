
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] arr = new int[a+2][b+2];
            boolean[][] visited = new boolean[a+2][b+2];


            for(int j = 0;  j < c; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken())+1;
                int y = Integer.parseInt(st.nextToken())+1;

                arr[x][y] = 1;
            }

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            int cnt = 0;

            for(int j = 1; j <= a; j++ ){
                for(int k = 1; k <= b; k++){

                    if(arr[j][k] == 1 && !visited[j][k]  ){
                        cnt++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add( new int[] {j,k});
                        while(!queue.isEmpty()){
                            int[] xy = queue.poll();

                            for(int r = 0 ; r < 4; r++){

                                int next_x = xy[0] + dx[r];
                                int next_y = xy[1] + dy[r];

                                if( visited[next_x][next_y] || arr[next_x][next_y] == 0) continue;

                                queue.add(new int[] {next_x , next_y});
                                visited[next_x][next_y] = true;

                            }

                        }

                    }


                }
            }
            sb.append(cnt).append('\n');


        }
        System.out.println(sb);

    }
}
