import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i = 1; i <=9; i++){
            dp[1][i] = 1;
        }
        
        long [] arr = new long[n+1];
        arr[1] = 10;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    dp[i][j]%=10007;
                }
                arr[i] += dp[i][j];

            }
            
             arr[i] += arr[i-1];
        }
        System.out.println((int)arr[n]%10007);



    }
}


