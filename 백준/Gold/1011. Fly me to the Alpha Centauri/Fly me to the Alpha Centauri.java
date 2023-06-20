
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int distance = end - start;

            int max =(int)Math.sqrt(distance);

            if( Math.sqrt(distance) == max){
                sb.append( 2 * max -1 ).append('\n');
            }
            else if( distance  <= max * (max + 1)){
                sb.append(2 * max).append('\n');
            }
            else{
                sb.append(max * 2 + 1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
