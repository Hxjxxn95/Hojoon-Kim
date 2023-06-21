
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for(int i = 0; i < n +1; i++){
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(idx == 0){
                if(a != b) union(a, b);
            }
            else{
                if( find(a) == find(b)) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);

    }

    static void union( int a, int b){
        if(find(a) != find(b)) arr[find(a)] = arr[find(b)];
    }

    static int find(int a){
        if(arr[a] == a) return a;
        else return arr[a] = find(arr[a]);
    }
}
