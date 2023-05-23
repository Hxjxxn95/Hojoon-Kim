

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n-(n-1-i); j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n-(n-1-i); j++){
                if(j == 0){
                    arr[i][j] += arr[i-1][j];
                }
                else if(j == n-(n-1-i)){
                    arr[i][j] += arr[i-1][j-1];
                }else{
                    arr[i][j] += Math.max(arr[i-1][j],arr[i-1][j-1]);
                }
            }
        }
        System.out.println(Arrays.stream(arr[n-1]).max().getAsInt());
    }

}
