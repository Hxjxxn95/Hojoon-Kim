
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            String string = br.readLine();

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(string.charAt(j)));
            }
        }

        partition(0,0,n);
        System.out.println(sb);
    }

    static void partition(int row, int col, int size){

        if(numberCheck(row, col, size)){

            if(map[row][col] == 0) sb.append(0);
            else sb.append(1);

            return;

        }
        sb.append('(');
        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        sb.append(')');
    }

    static boolean numberCheck(int row, int col, int size){

        int num = map[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col+ size; j++){
                if(map[i][j] != num) return false;
            }
        }

        return true;
    }
}
