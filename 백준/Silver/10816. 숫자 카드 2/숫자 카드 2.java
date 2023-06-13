
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1 );
        }

        arr= new ArrayList<>(map.keySet());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int key = Integer.parseInt(st.nextToken());
            if (binarysearch(key, 0 , arr.size()-1 )){
                sb.append(map.get(key)).append(' ');
            }
            else{
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);


    }
    static boolean binarysearch(int key, int low, int high){
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr.get(mid) == key) return true;
            else if( key < arr.get(mid)) high = mid -1;
            else low = mid + 1;
        }

        return false;
    }
}
