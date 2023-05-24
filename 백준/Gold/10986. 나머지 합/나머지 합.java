import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long cnt = 0;

        int[] arr = new int[N+1];
        long[] sum = new long[N+1];
        long[] remain = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            sum[i] = arr[i] + sum[i-1];
            remain[(int)(sum[i]%M)]++;
        }

        for(int i = 0; i < M; i++){
            cnt += remain[i] * ( remain[i] -1) / 2;
        }
        cnt += remain[0];

        System.out.println(cnt);
    }
}

// 1 0 0 1 0