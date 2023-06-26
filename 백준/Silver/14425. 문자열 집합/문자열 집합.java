
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            map.put(br.readLine(), 0);
        }

        for(int i = 0; i < M; i++){
            String temp = br.readLine();
            if(map.containsKey(temp)) map.put(temp,map.getOrDefault(temp, 0) + 1);
        }

        for(String string : map.keySet()){
            answer += map.get(string);
        }

        System.out.println(answer);
    }
}
