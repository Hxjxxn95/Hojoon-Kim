import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double S = Double.parseDouble(br.readLine());

        double sum = 0;
        int cnt = 0;
        for(int i = 1; ; i++){
            if(sum > S) break;
            sum += i;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}