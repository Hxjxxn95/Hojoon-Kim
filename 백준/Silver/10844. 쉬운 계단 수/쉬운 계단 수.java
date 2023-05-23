
import java.util.Scanner;

public class Main {
    public static Long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp = new Long[10][N+1];
        long sum = 0L;
        for(int i = 1; i <=9; i++){
            sum += func(i,N);
        }
        sum %= 1000000000;
        System.out.println(sum);



    }
    public static Long func(int t ,int n){
        if(n == 1){
            return 1L;
        }
        if(dp[t][n] != null) return dp[t][n];

        if(t == 0){
            dp[t][n] = func(t+1,n-1);
            return dp[t][n];
        } else if (t == 9) {
            dp[t][n] = func(t-1,n-1);
            return dp[t][n];
        }
        dp[t][n] = (func(t-1,n-1) + func(t + 1, n-1))%1000000000;

        return dp[t][n];
        }
    }

