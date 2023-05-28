

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] distance = new int[n-1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        long temp = 0;
        long min_price = 1000000000;
        for(int i = 0; i < n-1; i++){

            if(price[i] < min_price){
                min_price = price[i];
            }

            total += min_price * distance[i];
        }

        System.out.println(total);

    }
}
