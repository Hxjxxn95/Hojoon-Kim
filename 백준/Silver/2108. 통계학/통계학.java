
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        //HashMap에 mapping
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int num = scanner.nextInt();
            list.add(num);
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.replace(num,map.get(num)+1);
            }
        }
        //산술평균
        double sansul = 0;
        for(Map.Entry<Integer,Integer> pair: map.entrySet()){
            sansul+= pair.getKey() * pair.getValue();
        }
        sansul = Math.round((double)sansul/(double) N);

        //중앙값
        int junjang = 0;
        Collections.sort(list);
        junjang = list.get((int)(N/2));
        //최빈값
        int numbers = 0;
        int chebin = 0;
        List<Integer> chebinList = new ArrayList<>();
        for(int key : map.values()) {
            numbers = Math.max(numbers, key);
        }
        for(int i : map.keySet()){
            if(map.get(i)==numbers)chebinList.add(i);
        }
        Collections.sort(chebinList);
        if(chebinList.size() >= 2) chebin = chebinList.get(1);
        else chebin= chebinList.get(0);

        //범위
        int beom = Collections.max(list)- Collections.min(list);

        System.out.println((int)sansul);
        System.out.println(junjang);
        System.out.println(chebin);
        System.out.println(beom);


    }
}