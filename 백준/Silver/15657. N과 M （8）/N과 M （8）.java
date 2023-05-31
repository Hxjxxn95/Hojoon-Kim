
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = Arrays.stream(arr).sorted().toArray();

        dfs(0, 0);

        System.out.println(sb);


    }

    public static void dfs(int depth, int index){
        if (depth == M) {
            for(int i = 0; i < M; i++){
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i = index  ; i < N; i++){
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth+1, i);
                visited[i] = false;
            }

        }
    }
}
