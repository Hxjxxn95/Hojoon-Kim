
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if(B+C >= 60){
            A += (B+C)/60;
            B = (B+C)%60;
            if(A>23){
                A -=24;
            }

        }else{
            B+= C;
        }
        System.out.println(A+" "+B);
    }
}