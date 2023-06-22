
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty()) {
                if (arr[stack.peek() - 1] > arr[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                    if(!stack.isEmpty()){
                    answer[i] = stack.peek();
                    }
                    else{
                        answer[i] = 0;
                    }
                }
            }

            if(i < N -1){
                if(arr[i] > arr[i + 1]){
                    stack.push(i + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i : answer){
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
