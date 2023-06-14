
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static TreeMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            int n = Integer.parseInt(br.readLine());

            map = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                Long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0L)+1);
            }

            long cnt = 0;

            while(map.size() != 1){

                long a = map.firstKey();
                map.replace(map.firstKey(), map.get(map.firstKey())-1);
                if(map.get(map.firstKey()) == 0 ) map.remove(map.firstKey());

                long b = map.firstKey();
                map.replace(map.firstKey(), map.get(map.firstKey())-1);
                if(map.get(map.firstKey()) == 0 ) map.remove(map.firstKey());

                map.put(a + b, map.getOrDefault(a + b, 0L)+ 1);
                cnt+= a + b;
             }

            sb.append(cnt).append('\n');

            }
        System.out.println(sb);




        }

    }

