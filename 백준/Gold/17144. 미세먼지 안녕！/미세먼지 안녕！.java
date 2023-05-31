
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int[][] map = new int[R][C];
        int Ac_bottom = 0;


        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 ){
                    Ac_bottom = i;
                }
            }
        }

        int Ac_top = Ac_bottom - 1;


        for(int t = 0; t < T; t++){

            int[][] second_map = new int[R][C];
            Queue<int[]> queue = new LinkedList<>();

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] > 0){
                        queue.add(new int[]{i,j});
                    }
                }
            }
            // 먼지 퍼뜨리기
            while(!queue.isEmpty()) {

                int[] xy = queue.poll();
                int cnt = 0;

                for (int i = 0; i < 4; i++) {

                    int next_x = xy[0] + dx[i];
                    int next_y = xy[1] + dy[i];

                    if (next_x < 0 || next_y < 0 || next_x >= R || next_y >= C || map[next_x][next_y]== -1) continue;

                    second_map[next_x][next_y] += (int) (map[xy[0]][xy[1]] / 5);
                    cnt++;
                }

                second_map[xy[0]][xy[1]] -= (int) (map[xy[0]][xy[1]] / 5 * cnt);
            }

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    map[i][j] += second_map[i][j];
                }
            }


                //먼지 옮기기
                second_map = new int[R][C];
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){

                        if(map[i][j] >= 0) {

                            //공기청정기 오른쪽 코너 제외
                            if ((i == Ac_top && j != C - 1)|| (i == Ac_bottom&& j != C - 1)) {
                                second_map[i][j+1] = map[i][j];
                            }
                            //맵 맨 위 코너 제외
                            else if( (i == 0 || i == R -1) && j != 0 ){
                                second_map[i][j-1] = map[i][j];

                            }

                            //멥 위 오른쪽
                            else if(i <= Ac_top && j == C -1){
                                second_map[i-1][j] = map[i][j];
                            }
                            //맵 위 왼쪽
                            else if(i <= Ac_top && j == 0 ){
                                second_map[i+1][j] = map[i][j];

                            }
                            //맵 이레 오른쪽
                            else if(i >= Ac_bottom && j == C-1 ){
                                second_map[i+1][j] = map[i][j];
                            }
                            //맵 아래 왼쪽
                            else if(i >= Ac_bottom && j == 0){
                                second_map[i-1][j] = map[i][j];
                            }
                            else{
                                second_map[i][j] = map[i][j];
                            }
                        }
                    }
                }

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                        if(map[i][j] == -1) continue;
                        map[i][j] = second_map[i][j];
                }
            }


        }
        int total = 2;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                total += map[i][j];
            }
        }

        System.out.println(total);

    }
}
