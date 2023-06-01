
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[][] cnt;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = new int[N][N];
        

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());{
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        dfs(0,1,0);
        System.out.println(cnt[N-1][N-1]);


    }
    public static void dfs(int r, int c, int rotate) {
        if (r>=N || c>=N || map[r][c]==1) return;

        if (rotate==0) {
            dfs(r,c+1,0);
            dfs(r+1,c+1,1);
        } else if (rotate==1) {
            if (map[r-1][c]==1 || map[r][c-1]==1) return;
            dfs(r,c+1,0);
            dfs(r+1,c+1,1);
            dfs(r+1,c,2);
        } else {
            dfs(r+1,c+1,1);
            dfs(r+1,c,2);
        }
        cnt[r][c]++;
    }
}
