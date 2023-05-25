
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());

            int cnt = 0;
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());
                double r = Double.parseDouble(st.nextToken());

                if(distance(x1, y1, x3, y3) < r && distance(x2,y2,x3,y3) > r){
                    cnt++;
                } else if (distance(x1, y1, x3, y3) > r && distance(x2,y2,x3,y3) < r) {
                    cnt++;
                }

            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}
