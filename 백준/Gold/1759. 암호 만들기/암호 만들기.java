
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[] list;
    static char[] code;
    static int L, C;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);

        code(0,0);

        System.out.println(sb);
    }

    public static void code(int x, int depth ){

        if(depth == L){

            String mo ="aeiou";

            int cnt = 0;
            for(int i = 0; i < L; i++){
                if( mo.contains(String.valueOf(code[i]))) cnt++;
            }

            if(cnt >= 1 && L - cnt >= 2){
                sb.append(code).append('\n');
            }

            return;
        }

        for(int i = x; i < C; i++){
            code[depth] = list[i];
            code(i +1, depth + 1);
        }

    }
}
