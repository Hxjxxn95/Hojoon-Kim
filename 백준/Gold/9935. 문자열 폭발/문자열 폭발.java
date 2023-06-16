
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] list = br.readLine().toCharArray();
        char[] confirm = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

    for(int i = 0; i < list.length; i++){

        stack.push(list[i]);

        if(stack.size() >= confirm.length){

            boolean flag = true;

            for(int j = 0; j < confirm.length; j++){

                if(stack.get(stack.size() - confirm.length + j) != confirm[j]){
                    flag = false;
                }
            }

            if(flag){
                for(int j = 0; j < confirm.length; j++){
                    stack.pop();
                }
            }
        }

    }

    if(stack.size() == 0){
        System.out.println("FRULA");
        return;
    }
    StringBuilder sb = new  StringBuilder();
    for(int i = 0; i < stack.size(); i++){
        sb.append(stack.get(i));
    }
    System.out.println(sb);
    }
}
