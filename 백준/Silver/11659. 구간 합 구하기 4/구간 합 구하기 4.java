import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N+1];
        int[]sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N+1; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(sum[b]-sum[a-1]).append('\n');
        }
        System.out.println(sb);

    }
}