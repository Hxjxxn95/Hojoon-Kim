
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new long[K];
    
    long max = 0;
    for(int i = 0; i < K; i++){
        arr[i] = Integer.parseInt(br.readLine());
        max = Math.max(max, arr[i]);
    }
    
    System.out.println(binarysearch(1, max+1));


    }

    static long binarysearch(long low, long high){
        long mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            long temp = 0;
            for(int i = 0; i < K; i++){
                temp += arr[i]/mid;
            }
            if( temp < N) high = mid-1;
            else low = mid + 1;
        }

        return (high + low)/2;
    }
}
