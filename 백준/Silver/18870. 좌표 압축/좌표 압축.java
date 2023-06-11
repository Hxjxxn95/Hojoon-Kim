
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int key = 0;

        for(int i : set){
            map.put(i,key++);
        }
        for(int i : arr){
            sb.append(map.get(i)).append(' ');
        }
        System.out.println(sb);

    }
}
