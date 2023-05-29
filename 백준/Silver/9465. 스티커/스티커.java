
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){

            int M = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][M+1];
            int[][] dp = new int[2][M+1];


            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M;  k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            int max = Math.max(dp[0][0],dp[1][0]);

            for(int j = 1; j  < M; j++){
                if(j == 1){
                    dp[0][1] = dp[1][0] + arr[0][1];
                    dp[1][1] = dp[0][0] + arr[1][1];
                    max = Math.max(dp[0][1], dp[1][1]);
                }
                else {

                    dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                    dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
                    max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
                }
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

}
