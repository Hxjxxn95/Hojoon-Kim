import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sdoku(0,0);

    }

    public static boolean isTrue(int row , int col, int value){
        //행 검사
        for(int i = 0; i < 9; i++){
            if(arr[row][i] == value) return false;
        }
        //열 검사
        for (int i = 0; i < 9 ; i++){
            if(arr[i][col] == value) return false;
        }
        //3*3 검사]
        int first_row = (int)(row/3) * 3;
        int first_col = (int)(col/3) * 3;
        for(int i = first_row; i < first_row+3; i++){
            for(int j = first_col; j < first_col +3; j++){
                if(arr[i][j]==value) return false;
            }

        }
        return true;
    }


    public static void sdoku(int row, int col){
        if (col == 9){
            sdoku(row +1, 0);
            return;
        }
        if(row == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(arr[row][col] == 0){
            for (int i = 1; i <= 9; i++){
                if(isTrue(row,col,i)){
                    arr[row][col] = i;
                    sdoku(row,col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sdoku(row,col+1);
    }

}


