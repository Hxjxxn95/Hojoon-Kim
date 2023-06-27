
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[n+1];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= n; i++){
            if(!prime[i]){
                for(long j = (long) i * i; j <= n ; j += i ) prime[(int) j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(!prime[i]) list.add(i);
        }
        list.add(0);

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(left <= list.size()-1 && right <= list.size() -1  ){

            if(sum == n) cnt++;

            if(sum < n){
                sum += list.get(right++);
            }else{
                sum -= list.get(left++);
            }
        }

        System.out.println(cnt);
    }
}
