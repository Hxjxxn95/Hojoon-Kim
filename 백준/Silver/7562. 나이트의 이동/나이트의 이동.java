

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

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int I = Integer.parseInt(br.readLine());
            int[][] arr = new int[I][I];
            boolean[][] visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] dx = {-2,-1,1,2,2,1,-1,-2};
            int[] dy = {1,2,2,1,-1,-2,-2,-1};

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {x1,y1});

            while(!queue.isEmpty()){

                int[] xy = queue.poll();

                if(xy[0] == x2 && xy[1] == y2){
                    sb.append(arr[x2][y2]).append('\n');
                    break;
                }

                for(int j = 0; j < 8; j++){

                    int next_x = xy[0] + dx[j];
                    int next_y = xy[1] + dy[j];

                    if(next_x < 0 || next_y < 0 || next_x >= I || next_y >= I || visited[next_x][next_y]) continue;

                    visited[next_x][next_y] = true;
                    queue.add(new int[] {next_x,next_y});
                    arr[next_x][next_y] = arr[xy[0]][xy[1]] + 1;
                }
            }


        }
        System.out.println(sb);

    }
}
