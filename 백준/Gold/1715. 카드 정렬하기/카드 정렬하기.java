

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        Long sum = 0L;

        for(int i = 0; i < N; i++){
            queue.add(Long.parseLong(br.readLine()));
        }

        while(queue.size()>1){
            long a = queue.poll();
            long b = queue.poll();
            sum += a + b;
            queue.add(a+b);
        }
        System.out.println(sum);
    }
}

