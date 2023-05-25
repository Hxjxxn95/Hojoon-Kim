
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double length = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));

            if( length == 0){
                if(r1 == r2) sb.append(-1).append('\n');
                else sb.append(0).append('\n');
            }
            else {
                if (length > r1 + r2 || Math.abs(r1-r2) > length) sb.append(0).append('\n');
                else if (length == r1 + r2 || Math.abs(r1-r2) == length) sb.append(1).append('\n');
                else if(r1 + r2 > length && Math.abs(r1-r2) < length ) sb.append(2).append('\n');
            }
        }

        System.out.println(sb);
    }
}
