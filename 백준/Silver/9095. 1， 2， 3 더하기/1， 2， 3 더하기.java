
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            int a= Integer.parseInt(br.readLine());
            arr[i] = a;
            max = Math.max(max,a);
        }

        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        for(int i = 4; i <=max; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i  : arr){
            sb.append(dp[i]).append('\n');
        }

        System.out.println(sb);

    }
}
