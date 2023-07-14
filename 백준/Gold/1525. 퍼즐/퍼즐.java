import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[3][3];
        Queue<int[][]> queue = new LinkedList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    queue.add(map);
                }
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        if (toString(map).equals("123456780")) {
            System.out.println(0);
            return;
        }
        visited.put(toString(map), false);

        int cnt = 0;

        while (!queue.isEmpty()) {
            cnt++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[][] curMap = queue.poll();
                int[] xy = findZero(curMap);

                for (int j = 0; j < 4; j++) {
                    int nx = xy[0] + dx[j];
                    int ny = xy[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                        int[][] tempMap = copyMap(curMap);
                        int temp = tempMap[nx][ny];
                        tempMap[nx][ny] = 0;
                        tempMap[xy[0]][xy[1]] = temp;

                        String mapString = toString(tempMap);
                        if (!visited.containsKey(mapString)) {
                            visited.put(mapString, true);
                            queue.add(tempMap);
                        }

                        if (mapString.equals("123456780")) {
                            System.out.println(cnt);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static String toString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }

    public static int[][] copyMap(int[][] map) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static int[] findZero(int[][] map) {
        int[] xy = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) {
                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }
        return xy;
    }
}
