
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][][] map = new int[c][b][a];
        boolean[][][] visited = new boolean[c][b][a];
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < c; i++){
            for(int j = 0; j < b; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < a; k++){

                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        queue.add(new int[] { i , j , k});
                        visited[i][j][k] = true;
                    }


                }
            }
        }


        int[] dz = {0,0,0,0,1,-1};
        int[] dx = {1,-1,0,0,0,0};
        int[] dy = {0,0,1,-1,0,0};

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] xyz = queue.poll();

                for(int j = 0; j < 6; j++){

                    int next_z = xyz[0] + dz[j];
                    int next_x = xyz[1] + dx[j];
                    int next_y = xyz[2] + dy[j];

                    if(next_z >= c || next_x >= b || next_y >= a || next_z < 0 || next_x < 0 || next_y < 0) continue;
                    if(visited[next_z][next_x][next_y] || map[next_z][next_x][next_y] == -1 ) continue;

                    visited[next_z][next_x][next_y] = true;
                    queue.add(new int[] { next_z, next_x, next_y});

                }

            }

            cnt++;
        }
        for(int i = 0; i < c; i++){
            for(int j = 0; j < b; j++){
                for(int k = 0; k < a; k++){
                    if(!visited[i][j][k] && map[i][j][k] != -1){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt-1);

    }
}
