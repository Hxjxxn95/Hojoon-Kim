import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> list = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        String ac = "";
        Loop1:
        for (int i = 0; i < N; i++) {
            int dir = -1; // -1 represents the front, 1 represents the back
            ac = br.readLine();
            String[] acList = ac.split("");
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine().replace("[", "").replace("]", ""), ",");

            while (st.hasMoreElements()) {
                list.add(st.nextToken().trim());
            }

            if (Arrays.asList(acList).contains("D") && list.isEmpty()) {
                sb.append("error").append('\n');
                continue;
            }
            Loop2 :
            for (String word : acList) {
                if (word.equals("R")) {
                    dir *= -1;
                } else if (word.equals("D")) {
                    if (list.isEmpty()) {
                        sb.append("error").append('\n');
                        continue Loop1;
                    } else {
                        if (dir == -1) {
                            list.removeFirst();
                        } else {
                            list.removeLast();
                        }
                    }
                }
            }

            if (list.isEmpty()) {
                sb.append("[]").append('\n');
            } else {
                if (dir == -1) {
                    sb.append("[");
                    while (!list.isEmpty()) {
                        sb.append(list.removeFirst());
                        if (!list.isEmpty()) {
                            sb.append(",");
                        }
                    }
                    sb.append("]").append('\n');
                } else {
                    sb.append("[");
                    while (!list.isEmpty()) {
                        sb.append(list.removeLast());
                        if (!list.isEmpty()) {
                            sb.append(",");
                        }
                    }
                    sb.append("]").append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}

