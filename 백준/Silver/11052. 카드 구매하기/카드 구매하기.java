

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n + 1];
        for(int i =1; i < n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        for(int i = 2; i <= n; i++){
            int max = arr[i];
            for(int j = 1; j < i; j++){
            dp[i] = Math.max(max,dp[i-j]+arr[j]);
            max = Math.max(max,dp[i-j]+arr[j]);
        }}
        System.out.println(dp[n]);

    }

}
