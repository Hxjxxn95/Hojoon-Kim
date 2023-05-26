
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        int[][] arr= new int[N+2][N+2];
        boolean[][] visited = new boolean[N+2][N+2];

        int cnt = 0;

        for(int i = 1; i <= N; i++){
            String a = br.readLine();
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(a.charAt(j-1)));
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 1; i <= N; i++ ){
            for(int j = 1; j <= N; j++){

                if(arr[i][j] == 1 && !visited[i][j]  ){
                    cnt++;
                    int num_count = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add( new int[] {i,j});
                    while(!queue.isEmpty()){
                        int[] xy = queue.poll();

                        for(int k = 0 ; k < 4; k++){

                            int next_x = xy[0] + dx[k];
                            int next_y = xy[1] + dy[k];

                            if( visited[next_x][next_y] || arr[next_x][next_y] == 0) continue;

                            queue.add(new int[] {next_x , next_y});
                            visited[next_x][next_y] = true;
                            num_count++;

                        }

                    }
                    if(num_count == 0) num_count++;
                   list.add(num_count);

                }


            }
        }

        Collections.sort(list);
        System.out.println(cnt);
        System.out.println(list.toString().replace("[","").replace("]","").replace(", ","\n"));
    }
}
