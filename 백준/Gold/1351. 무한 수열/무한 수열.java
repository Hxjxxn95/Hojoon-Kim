
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int P,Q;
    static HashMap<Long,Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(dp(N));
    }

    static long dp( long num){
        if(map.containsKey(num)) return map.get(num);

        long a = num / P;
        long b = num / Q;

        map.put(num, dp(a) + dp(b));
        return map.get(num);
    }
}
