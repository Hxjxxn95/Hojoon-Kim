
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){

            int num = Integer.parseInt(br.readLine());

            if(num > 0){
                plus.add(num);
            }
            else if(num < 0 ){
                minus.add(num);
            }else{

                if(!plus.isEmpty() && !minus.isEmpty()) {
                    if (plus.peek() >= Math.abs(minus.peek())) {
                        sb.append(minus.poll()).append('\n');
                    } else {
                        sb.append(plus.poll()).append('\n');
                    }
                }
                else if(!plus.isEmpty() && minus.isEmpty()){
                    sb.append(plus.poll()).append('\n');
                }
                else if(plus.isEmpty() && !minus.isEmpty()){
                    sb.append(minus.poll()).append('\n');
                }
                else{
                    sb.append(0).append('\n');
                }
            }

        }

        System.out.println(sb);

    }
}
