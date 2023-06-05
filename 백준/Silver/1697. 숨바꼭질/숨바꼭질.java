import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();


        queue.add(a);
        int cnt = 0;
        boolean[] visited = new boolean[100001];

        visited[a] = true;

        while (true){
            if(visited[b]){
                System.out.println(cnt);
                return;
            }
            cnt++;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int s = queue.poll();
                visited[s] = true;

                if (s - 1 >= 0 && !visited[s - 1]){
                queue.add(s - 1);
                visited[s - 1] = true;}
                if (s + 1 <= 100000 && !visited[s + 1]) {
                queue.add(s + 1);
                visited[s + 1] = true;}
                if (s * 2 <= 100000 && !visited[s * 2]){
                queue.add(s * 2);
                visited[s * 2] = true;}
                }
        }

    }


}
