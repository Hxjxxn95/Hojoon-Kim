
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++ ){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Collections.reverseOrder());

        if(boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while(!boxes.isEmpty()){

            int idx = 0;

            for (int i = 0; i < N; ) {
                if(idx == boxes.size()) break;
                if(boxes.get(idx) <= cranes.get(i)){
                    boxes.remove(idx);
                    i++;
                }else{
                    idx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
