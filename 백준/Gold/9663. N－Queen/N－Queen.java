import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static int N, cnt;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[N];
        dfs(0);
        System.out.println(cnt);

    }

    public static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if(isTrue(depth)){
                dfs(depth+1);
            }

        }
    }

    public static boolean isTrue(int a) {
        for (int i = 0; i < a; i++) {
            if (arr[a] == arr[i]) {
                return false;
            } else if (Math.abs(a - i) == Math.abs(arr[a] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}

