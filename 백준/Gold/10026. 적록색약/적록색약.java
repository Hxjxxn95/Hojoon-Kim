
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < N; i++){
            String string = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = string.charAt(j);
            }
        }

        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();


        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited1[i][j]) {
                    queue1.add(new int[]{i, j});
                    cnt1++;
                }
                while (!queue1.isEmpty()){

                    int[] xy = queue1.poll();

                    for(int q = 0; q < 4; q++){

                        int next_x = xy[0] + dx[q];
                        int next_y = xy[1] + dy[q];

                        if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N ||
                                map[next_x][next_y] != map[xy[0]][xy[1]] || visited1[next_x][next_y]){
                            continue;
                        }
                        visited1[next_x][next_y] = true;
                        queue1.add(new int[] {next_x,next_y});
                    }
                }

                if(!visited2[i][j]){
                    queue2.add(new int[] {i,j});
                    cnt2++;
                }
                while(!queue2.isEmpty()){

                    int[] xy = queue2.poll();

                    for(int q = 0; q < 4; q++){

                        int next_x = xy[0] + dx[q];
                        int next_y = xy[1] + dy[q];

                        if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N || visited2[next_x][next_y]) continue;

                        if((map[xy[0]][xy[1]] == 'R' || map[xy[0]][xy[1]] == 'G') && map[next_x][next_y] == 'B' ) continue;

                        if(map[xy[0]][xy[1]] == 'B'&& map[next_x][next_y] != 'B') continue;

                        visited2[next_x][next_y] = true;
                        queue2.add(new int[] {next_x,next_y});

                    }
                }

            }
        }

        System.out.println(cnt1 + " " + cnt2);



    }
}
