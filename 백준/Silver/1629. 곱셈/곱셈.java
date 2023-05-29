
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    public static long pow(long A, long B, long C) {

        if(B == 1) {
            return A % C;
        }
        long temp = pow(A, B / 2, C);

        if(B % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }
}
