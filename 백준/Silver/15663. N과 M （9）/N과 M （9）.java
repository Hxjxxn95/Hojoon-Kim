
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int[] result;
    public static StringBuilder sb;
    public static boolean[] visited;
    public static LinkedHashSet<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        list = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        for(String string : list){
            System.out.println(string);
        }

    }

    public static void dfs(int depth){
        sb = new StringBuilder();
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i] ).append(' ');
            }
            list.add(String.valueOf(sb));

        }else{
            for(int i = 0; i < N; i++){
                if(!visited[i]) {
                    visited[i] = true;
                    result[depth] = arr[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }

        }
    }
}
