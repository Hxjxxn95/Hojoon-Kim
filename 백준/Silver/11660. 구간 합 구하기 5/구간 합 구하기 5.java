
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N +1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N +1; j++){
                sum[i][j] = arr[i][j] + sum[i][j-1];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2){
                sb.append(arr[x1][y1]).append('\n');
            }else{
                int a = 0;
                for(int j = x1; j <= x2; j++){
                    a += sum[j][y2] - sum[j][y1-1];
                }
                sb.append(a).append('\n');
            }
        }
        System.out.println(sb);
    }
}
