
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] list = new int[n+1];

        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            

            if( i % 3 == 0){
                if(dp[i/3] + 1 < dp[i]){
                    dp[i] = dp[i / 3 ] + 1;
                    list[i] = i / 3;
                }

            }
            if( i % 2 == 0){
                if(dp[i / 2] + 1 < dp[i]){
                    dp[i] = dp[i / 2] + 1;
                    list[i] = i / 2;
                }
            }

            if(dp[i -1] + 1 < dp[i]){
                dp[i] = dp[i - 1] + 1;
                list[i] = i - 1;
            }

        }
        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            sb.append(n + " ");
            n = list[n];
        }

        System.out.println(sb);
    }
}
