
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] visited = new int[N + 1];
        ArrayList[] map = new ArrayList[N+1];

        for(int i = 1 ;i <= N ; i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = 1;

        while(!stack.isEmpty()){

            int index = stack.pop();

            for(Object nextnode :map[index]){

                if(visited[(int) nextnode] == 0){
                    stack.push((int)nextnode);
                    visited[(int)nextnode] = 1;
                }

            }
        }
        System.out.println(Arrays.stream(visited).sum()-1);

    }
}
