
import java.util.*;
import  java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        int[][]list = new int[101][101];
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            for(int j = A; j< A+10;j++){
                for(int k = B; k < B+10; k++){
                    list[j][k] = 1;
                }
            }

        }
        int sum = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                sum += list[i][j];
            }
        }
        System.out.println(sum);
    }
}