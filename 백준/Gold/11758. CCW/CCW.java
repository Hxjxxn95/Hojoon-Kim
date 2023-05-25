import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) { 
        int value = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
        return value < 0 ? -1 : value > 0 ? 1 : 0;
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int xy[][] = new int[3][2], i, j;
            for (i = 0; i < 3; ++i) {
                st = new StringTokenizer(br.readLine());
                for (j = 0; j < 2; ++j)  xy[i][j] = Integer.parseInt(st.nextToken());
            } br.close();
            System.out.println(ccw(xy[0][0], xy[0][1], xy[1][0], xy[1][1], xy[2][0], xy[2][1]));
        }
    }
