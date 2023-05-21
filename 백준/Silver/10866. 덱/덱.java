import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            String[] string = br.readLine().split(" ");
            String a = string[0];
            String b = "";
            if (string.length == 2) b = string[1];

            switch (a) {
                case "push_front": {
                    list.addFirst(Integer.parseInt(b));
                    break;
                }
                case ("push_back"): {
                    list.add(Integer.parseInt(b));
                    break;
                }
                case ("pop_front"): {
                    if(list.isEmpty()){sb.append(-1).append('\n');break;}
                    sb.append(list.getFirst()).append('\n');
                    list.removeFirst();
                    break;
                }
                case ("pop_back"): {
                    if(list.isEmpty()){sb.append(-1).append('\n');break;}
                    sb.append(list.getLast()).append('\n');
                    list.removeLast();
                    break;
                }
                case ("size"): {
                    sb.append(list.size()).append('\n');
                    break;
                }
                case ("empty"): {
                    if (list.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case ("front"): {
                    if(list.isEmpty()){sb.append(-1).append('\n');break;}
                    sb.append(list.getFirst()).append('\n');
                    break;
                }
                case ("back"): {
                    if(list.isEmpty()){sb.append(-1).append('\n');break;}
                    sb.append(list.getLast()).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);


    }
}