

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = Arrays.stream(arr).sorted().toArray();
        int max = 0;

        for(int i = 0; i < n; i++){

            int temp = arr[i] * (n-i);
            max = Math.max(max, temp);

        }

        System.out.println(max);

    }
}
