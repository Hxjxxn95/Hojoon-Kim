import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        if (B- 45 < 0){
            B = 60 - (45-B);
            A -= 1;
        } else {B-=45;
        }
        if(A<0){
            A = 23;
        }

        System.out.println(A+" "+B);

    }
}