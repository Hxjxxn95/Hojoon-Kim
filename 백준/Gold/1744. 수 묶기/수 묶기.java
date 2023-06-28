
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        long sum = 0;
        int zero_cnt = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if( num > 0 ) plus.add(num);
            else if(num < 0) minus.add(num);

            if( num == 0) zero_cnt++;
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int plus_size = plus.size();

        int flag = plus_size % 2 == 0 ? 1 : 2;

        for(int i = 0; i < plus_size - flag ; i += 2) {
            int a = plus.get(i);
            int b = plus.get(i + 1);

            if(a == 1 || b == 1) sum += a + b;
            else sum += (long) a * b;
        }
        if(flag == 2) sum += plus.get(plus_size - 1);

        int minus_size = minus.size();

        flag = minus_size % 2 == 0 ? 1 : 2;

        for(int i = 0; i < minus_size - flag; i+=2){
            int a = minus.get(i);
            int b = minus.get(i + 1);
            sum += (long) a * b;
        }

        if(flag == 2 && zero_cnt == 0){
            sum += minus.get(minus_size - 1);
        }

        System.out.println(sum);


    }
}
