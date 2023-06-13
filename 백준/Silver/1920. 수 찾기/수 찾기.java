
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

     public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            sb.append( binarysearch( Integer.parseInt(st.nextToken()), 0, arr.length-1)).append('\n');
        }

        System.out.println(sb);

    }

    static int binarysearch(int key, int low, int high){
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] == key) return 1;
            else if( key < arr[mid]) high = mid -1;
            else low = mid + 1;
        }

        return 0;
    }
}
