import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        double [][] arr = new double[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if( func(arr[i][0],arr[i][1],arr[j][0],arr[j][1],arr[k][0],arr[k][1])) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean func(double x1 ,double y1, double x2, double y2, double x3, double y3 ){
        if ( (x1-x2)*(x1-x3) + (y1-y2)*(y1-y3) == 0) return true;
        else if ( (x2-x1)*(x2-x3) + (y2-y1)*(y2-y3) == 0) return true;
        else if ( (x3-x1)*(x3-x2) + (y3-y1)*(y3-y2) == 0) return true;
        else return false;
    }
}