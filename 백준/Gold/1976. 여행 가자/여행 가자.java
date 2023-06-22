
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    union(i, j);
                }
            }
        }

        boolean falg = true;

        int[] course = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            course[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M - 1; i++){
            if( find(arr[course[i]]) != find(arr[course[i+1]])) falg = false;
        }

        if(falg) System.out.println("YES");
        else System.out.println("NO");


    }

    static void union( int a, int b){
        if(find(a) != find(b)) arr[find(a)] = arr[find(b)];
    }

    static int find(int a){
        if(arr[a] == a) return a;
        else return arr[a] = find(arr[a]);
    }
}
