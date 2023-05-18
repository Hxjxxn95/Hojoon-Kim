import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int count = N;
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < N; i++){
            String string = scanner.nextLine();
            String[] word = string.split("");
            temp.clear();
            for (int j = 0; j < word.length; j++){
                if(!temp.contains(word[j])){
                    temp.add(word[j]);

                }else{
                    if(!Objects.equals(word[j], word[j-1])){
                        count--;
                        break;
                    }else continue;

                }

            }
        }System.out.println(count);
    }
}