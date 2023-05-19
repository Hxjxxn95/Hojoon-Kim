import java.util.*;
import  java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] list = new int[N+1];
        if(N >= 3)list[3] = 1;
        if(N>= 5) list[5] = 1;
        for(int i = 6; i < N+1; i++ ){
            if(i % 5 == 0) list[i] = list[i-5] +1;
            else if(i % 3 == 0) list[i] = list[i-3] +1;
            else{
                if(list[i-3]!=0 && list[i-5]!=0){
                    list[i] = Math.min(list[i-3],list[i-5])+1;
                }
            }
        }
        if(list[N]==0)list[N] = -1;
        System.out.println(list[N]);
    }
}