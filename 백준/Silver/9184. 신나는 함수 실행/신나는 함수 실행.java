

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        int a, b, c;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if(a== -1 && b== -1 && c==-1) break;

        sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');


        }
        System.out.println(sb);

    }

    public static int w(int a, int b, int c){
        if(0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && arr[a][b][c] != 0) return arr[a][b][c];

        if( a<= 0 || b <= 0 || c <= 0) return 1;

        if( a> 20 || b > 20 || c > 20)
            return arr[20][20][20] = w(20,20,20);
        if( a < b && b < c){
            return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
