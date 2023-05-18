
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Scanner scanner = new Scanner(System.in);
        int [] list = new int[3];
        for (int i = 0; i < 3; i++){
            list[i] = scanner.nextInt();
        }
        for(int i = 0;  i < 3; i++){
            if (!map.containsKey(list[i])){
                map.put(list[i],1);
            }
            else{
                map.put(list[i],map.get(list[i])+1);
            }
        }
        int max_key = map.entrySet().stream().max((m1, m2) -> m1.getValue() > m2.getValue() ? 1 : -1).get().getKey();
        if(map.get(max_key)==3){
            System.out.println(max_key*1000+10000);
        } else if (map.get(max_key)==2) {
            System.out.println(max_key*100+1000);
        }else{
            System.out.println(max_key*100);
        }
    }
}