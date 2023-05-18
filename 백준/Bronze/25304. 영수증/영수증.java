import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int n = scanner.nextInt();
        int mine = 0;
        for(int i = 0; i < n; i++){
            mine += scanner.nextInt() * scanner.nextInt();

        }
        if(mine == total){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}