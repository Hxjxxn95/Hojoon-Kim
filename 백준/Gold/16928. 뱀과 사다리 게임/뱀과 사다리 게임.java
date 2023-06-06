
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] n_arr = new int[101];
        int[] m_arr = new int[101];
        int[] cnt = new int[101];
        boolean[] visited = new boolean[101];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            n_arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            m_arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while(!queue.isEmpty()){

            for(int t = 0; t < queue.size(); t++){

                int cur = queue.poll();

                for(int i = 1; i <= 6;i++) {
                    int next = cur + i;

                    if(next > 100 || visited[next])continue;
                    if(n_arr[next] != 0 ){
                        next = n_arr[next];
                    }
                    if(m_arr[next] != 0){
                        next = m_arr[next];
                    }
                    if(visited[next]) continue;

                    visited[next] = true;
                    cnt[next] = cnt[cur] + 1;
                    queue.add(next);
                }
            }

        }

        System.out.println(cnt[100]);






    }
}
