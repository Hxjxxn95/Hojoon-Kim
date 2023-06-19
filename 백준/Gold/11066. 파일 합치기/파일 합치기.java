
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[][] dp;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){

            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            dp = new int[n+1][n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            sum = new int[n+1];

            for(int i = 1; i <= n ; i++){
                sum[i] = sum[i-1] + arr[i];
            }
            
            sb.append(func(1,n)).append('\n');
        }
        
        System.out.println(sb);

    }

    public static int func(int start, int end){
        if(start == end) return 0;
        if(dp[start][end] != Integer.MAX_VALUE) return dp[start][end];

        for(int i = start; i < end; i++){
            int cost = func(start, i) + func(i + 1, end) +  sum[end] - sum[start-1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }

        return dp[start][end];

    }
}