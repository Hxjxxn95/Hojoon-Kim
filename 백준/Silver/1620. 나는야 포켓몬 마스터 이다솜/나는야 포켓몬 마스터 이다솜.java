
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String string = br.readLine();
            map1.put(string,i);
            map2.put(i,string);
        }

        for(int i = 0; i < M; i++){
            String string = br.readLine();
            try{
                int a = Integer.parseInt(string);
                sb.append(map2.get(a)).append('\n');
            }catch (NumberFormatException ex){
                sb.append(map1.get(string)).append('\n');
            }
        }

        System.out.println(sb);


    }
}
