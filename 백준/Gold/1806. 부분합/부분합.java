
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        while(left <= n && right <= n){

            if(sum >= s) answer = Math.min(right - left, answer);

            if(sum < s ){
                sum += arr[right++];
            }else {
                sum -= arr[left++];
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
