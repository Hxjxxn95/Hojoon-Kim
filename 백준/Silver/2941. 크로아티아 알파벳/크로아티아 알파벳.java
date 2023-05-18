import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[]croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        int index = 0;
        int count = 0;
        for(int i = 0; i < croatia.length; i++){
            index = string.indexOf(croatia[i]);
            if (index>= 0){
                string = string.replaceAll(croatia[i],"*");

            }
        }
        System.out.println(string.length());
    }
}