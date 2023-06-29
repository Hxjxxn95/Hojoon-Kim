
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T = 0; T < t; T++){

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = arr[0];
            int right = arr[1];
            int max = Integer.MIN_VALUE ;

            for(int i = 2; i < n; i++){
                int temp = arr[i];

                if(i % 2 == 0){
                    max = Math.max( max, temp - left);
                    left = temp;
                }
                else{
                    max = Math.max( max, temp - right);
                    right = temp;
                }
            }
            sb.append(max).append('\n');
        }

        System.out.println(sb);

    }
}
