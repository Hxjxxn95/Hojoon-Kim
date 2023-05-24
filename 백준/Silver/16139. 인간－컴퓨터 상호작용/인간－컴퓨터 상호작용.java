
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String string = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int length = string.length();
        int[][] arr = new int[26][length];
        //arr[문자][string 길이]
        for(int i = 0; i < 26; i++){
            arr[i][0] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());



            char find = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());


            if (arr[find-'a'][0] == -1 ){
                if (string.charAt(0) == find) arr[find-'a'][0] =1;
                else arr[find-'a'][0] = 0;
                for(int j = 1; j < length; j++ ){
                    if(find == string.charAt(j)){
                        arr[find-'a'][j] = arr[find-'a'][j-1] + 1;
                    }else arr[find-'a'][j] = arr[find-'a'][j-1];
                }
            }


            if(l!=0){ sb.append(arr[find-'a'][r]-arr[find-'a'][l-1]).append('\n');}
            else {sb.append(arr[find-'a'][r]).append('\n');}


        }
        System.out.println(sb);

    }
}
