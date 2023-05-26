import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] points = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;

        for (int i = 1; i < n - 1; i++) {
            sum += calculateTriangleArea(points[0], points[i], points[i + 1]);
        }

        System.out.printf("%.1f%n", Math.abs(sum));
    }

    public static double calculateTriangleArea(long[] point1, long[] point2, long[] point3) {
        double area = (point1[0] * point2[1] + point2[0] * point3[1] + point3[0] * point1[1]
                - point2[0] * point1[1] - point3[0] * point2[1] - point1[0] * point3[1]) / 2.0;
        return area;
    }
}