

import java.util.Scanner;

public class Main {

    static int cnt_code1 = 0 , cnt_code2 , N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt() ;
        cnt_code2 = N - 2;
        fib(N);
        System.out.println(cnt_code1);
        System.out.println(cnt_code2);


    }
    public static int fib(int n){
        if (n == 1 || n == 2){
            cnt_code1++;
            return 1;
        }
        else{
            return (fib(n-1))+fib(n-2);}
    }
}
