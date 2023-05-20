import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        List<Integer> new_list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }
        while(list.size()!=0){
            Collections.rotate(list,-(M-1));
            new_list.add(list.get(0));
            list.remove(0);
        }
        System.out.println(Arrays.toString(new_list.toArray()).replace("[","<").replace("]",">"));

    }
}