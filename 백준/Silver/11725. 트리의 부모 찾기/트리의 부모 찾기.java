
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static int[] parentNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        parentNode = new int[N+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);

        }
        dfs(1);

        for(int i= 2; i <= N; i++){
            sb.append(parentNode[i]).append('\n');
        }

        System.out.println(sb);


    }

    private static void dfs(int index) {
        visited[index] = true;
        for(int i : arr[index]){
            if(!visited[i]){
                parentNode[i] = index;
                dfs(i);
            }
        }
    }



}
