
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int row_length = 3;
        int col_length = 3;
        while (true) {

            if (time > 100) {
                System.out.println(-1);
                return;
            }

            if (map[r][c] == k) {
                System.out.println(time);
                return;
            }

            time++;


            if (row_length >= col_length) {
                for (int i = 1; i <= row_length; i++) {
                    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
                    for (int j = 1; j <= col_length; j++) {
                        if(map[i][j] != 0)treeMap.put(map[i][j], treeMap.getOrDefault(map[i][j], 0) + 1);
                    }
                    List<Map.Entry<Integer, Integer>> ascendingList = new ArrayList<>(treeMap.entrySet());
                    ascendingList.sort(Comparator.comparing(Map.Entry::getValue));

                    int idx = 1;
                    for (Map.Entry<Integer, Integer> entry : ascendingList) {
                        map[i][idx++] = entry.getKey();
                        map[i][idx++] = entry.getValue();
                    }

                    col_length = Math.max(col_length, idx);

                    if(col_length >= idx) {
                        for (int j = idx; j <= col_length; j++) {
                            map[i][j] = 0;
                        }
                    }

                }
            } else {
                for (int i = 1; i <= col_length; i++) {
                    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
                    for (int j = 1; j <= row_length; j++) {
                        if(map[j][i] != 0) treeMap.put(map[j][i], treeMap.getOrDefault(map[j][i], 0) + 1);
                    }
                    List<Map.Entry<Integer, Integer>> ascendingList = new ArrayList<>(treeMap.entrySet());
                    ascendingList.sort(Comparator.comparing(Map.Entry::getValue));

                    int idx = 1;
                    for (Map.Entry<Integer, Integer> entry : ascendingList) {
                        map[idx++][i] = entry.getKey();
                        map[idx++][i] = entry.getValue();
                    }
                    row_length = Math.max(row_length, idx);

                    if (row_length >= idx) {
                        for (int j = idx; j <= row_length; j++) {
                            map[j][i] = 0;
                        }
                    }
                }
            }
            
        }
    }
}
