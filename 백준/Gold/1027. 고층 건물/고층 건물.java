import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] view = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N-1; i++){

            view[i]++;
            view[i+1]++;

            double slope = arr[i+1] - arr[i];

            for(int j = i+2; j < N; j++){
                double nextSlope = (double)(arr[j] - arr[i])/(j-i);
                if(nextSlope > slope){

                    view[i]++;
                    view[j]++;

                    slope = nextSlope;

                }
            }
        }

        System.out.println(Arrays.stream(view).max().getAsInt());

    }
}