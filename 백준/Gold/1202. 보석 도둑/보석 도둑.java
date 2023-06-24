
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long total = 0;

        List<int[]> jewelry = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jewelry.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }

        jewelry.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        for(int i = 0; i < K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);

        int idx = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int bag : bags) {
            while (idx < N && bag >= jewelry.get(idx)[0]) {
                queue.add(jewelry.get(idx)[1]);
                idx++;
            }
            if (!queue.isEmpty()) {
                total += queue.poll();
            }
        }
        System.out.println(total);
    }

}
