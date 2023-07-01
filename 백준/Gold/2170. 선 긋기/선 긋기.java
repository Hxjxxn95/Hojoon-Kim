
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int sum = 0;
        int left = arr[0][0];
        int right = arr[0][1];
        for(int i = 1; i < N; i++){

            if(arr[i][1] < right) continue;

            if(arr[i][1] > right){

                if(arr[i][0] > right){
                    sum += right - left;
                    left = arr[i][0];
                    right = arr[i][1];
                }else{
                    right = arr[i][1];
                }
            }
        }
        sum += right - left;

        System.out.println(sum);
    }
}
