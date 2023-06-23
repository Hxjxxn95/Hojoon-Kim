
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            arr[i][0]  = a;
            arr[i][1]  = b;
        }

        Arrays.sort(arr, Comparator.comparingLong((long[] o) -> o[0]).thenComparingLong((long[] o) -> o[1]));



        PriorityQueue<Long> list = new PriorityQueue<>();
        list.add(arr[0][1]);
        for(int i = 1; i < N; i++){
            if( list.peek() <= arr[i][0] ){
                    list.poll();
                }

            list.add(arr[i][1]);


        }
        System.out.println(list.size());

    }
}
