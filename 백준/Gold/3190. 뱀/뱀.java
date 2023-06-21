import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        map[a][b] = 1;
        }

        HashMap<Integer, Character> dir_map = new HashMap<>();

        int dir = Integer.parseInt(br.readLine());

        for(int i = 0; i < dir; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir_map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }


        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        List<int[]> snake = new LinkedList<>();

        snake.add(new int[] { 1, 1});

        int time = 0;
        int cur_x = 1;
        int cur_y = 1;

        int index = 0;
        while(true){

            time++;

            int next_x = cur_x + dx[index];
            int next_y = cur_y + dy[index];

            if(next_x < 1 || next_y < 1|| next_x > N || next_y > N) break;

            boolean flag = false;
            for(int i = 0; i < snake.size(); i++){
                if( next_x == snake.get(i)[0] && next_y == snake.get(i)[1]){
                    flag = true;
                    break;
                }
            }
            if(flag) break;

            if(map[next_x][next_y] == 1){
                map[next_x][next_y] = 0;
                snake.add(new int[] { next_x, next_y});
            }else{
                snake.add(new int[] {next_x, next_y});
                snake.remove(0);
            }

            cur_x = next_x;
            cur_y = next_y;

            if(dir_map.containsKey(time)){
                if(dir_map.get(time).equals('D')){
                    index++;
                    if(index == 4){
                        index = 0;
                    }
                } else if (dir_map.get(time).equals('L')) {
                    index--;
                    if(index == -1){
                        index = 3;
                    }

                }
            }
        }

        System.out.println(time);



    }
}
