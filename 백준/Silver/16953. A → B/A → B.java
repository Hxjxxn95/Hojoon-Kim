

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N =Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int cnt = 1;

        while( M > N ){
            String string = String.valueOf(M);

            if(M%10 ==  1 ){
                M = Integer.parseInt(string.substring(0, string.length()-1));
                cnt++;
                continue;
            }
            else if( M % 2 == 0){
                M = M /2;
                cnt++;
                continue;
            }

            if(string.charAt(string.length()-1) != '1'){
                System.out.println(-1);
                System.exit(0);
            }

        }
        if (N == M) System.out.println(cnt);
        else System.out.println(-1);
    }
}
