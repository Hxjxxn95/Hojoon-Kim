
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if( (i + 1) % 2 == 1){
                queue1.add(num);

                if (!queue2.isEmpty() && queue1.peek() > queue2.peek()) {

                    queue2.add(queue1.poll());
                    queue1.add(queue2.poll());
                }
            }else{
                queue2.add(num);

                if(queue1.peek() > queue2.peek()){
                    queue2.add(queue1.poll());
                    queue1.add(queue2.poll());
                }
            }

            sb.append(queue1.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
