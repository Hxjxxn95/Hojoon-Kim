
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        dp = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(func(0, N-1));
    }

    public static int func ( int start, int end){

        if(start == end) return 0;
        if(dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
        for(int i = start; i < end; i++){
            int cost = func(start, i) + func(i + 1, end) + arr[start][0] * arr[i][1] * arr[end][1];
            dp[start][end] = Math.min( dp[start][end], cost);
        }
        return dp[start][end];
    }
}
