
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int top = -1;

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0)+1);
            arr[i] = temp;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){

            while( !stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }


        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}
