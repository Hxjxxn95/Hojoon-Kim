import java.util.*;
import  java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(a == 0 || b == 0){
            a = b = 1;
        }
        int fia = a;
        int fib = b;
        for(int i = 1; i < b; i++ ){
            fia *= a-i;
        }
        for(int i = 1; i < b; i++) {fib *= i;}
        System.out.println((int)(fia/fib));

    }
}