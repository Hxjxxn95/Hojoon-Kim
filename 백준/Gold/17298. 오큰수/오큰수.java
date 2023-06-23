
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push( N -1);
        for(int i = N-2; i >= 0 ; i--){
            if(!stack.isEmpty()) {
                while( !stack.isEmpty() && arr[stack.peek()] <= arr[i] ){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    answer[i] = arr[stack.peek()];
                }
                stack.push(i);
            }
            else{
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
