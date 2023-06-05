
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int a  = Integer.parseInt(st.nextToken());

                if(c == 'I'){
                    map.put(a,map.getOrDefault(a,0)+1 );
                }else{
                    if(map.size() == 0) continue;
                    else{
                        int key = a == 1 ? map.lastKey() : map.firstKey();
                        int cnt = map.get(key);

                        if(cnt == 1){
                            map.remove(key);
                        }else{
                            map.replace(key,map.get(key)-1);
                        }
                    }
                }

                }
            if(map.size() == 0){
                sb.append("EMPTY").append('\n');
            }else{
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
            }
        System.out.println(sb);
    }
}
