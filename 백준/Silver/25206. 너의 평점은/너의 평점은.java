import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = 20;
        float totalScore = 0F;
        float totalClass = 0F;
        Map<String,Float> score = new HashMap<String, Float>() {
                {   put("A+", 4.5F);
                    put("A0", 4.0F);
                    put("B+", 3.5F);
                    put("B0", 3.0F);
                    put("C+", 2.5F);
                    put("C0", 2.0F);
                    put("D+", 1.5F);
                    put("D0", 1.0F);
                    put("F", 0.0F);
                }
            };

        for(int i = 0; i < N; i++){
            String[] strings = scanner.nextLine().split("\\s");
            if(Objects.equals(strings[2],"F")){
                totalClass += Float.parseFloat(strings[1]);
            } else if (Objects.equals(strings[2], "P")) {
                continue;
            }else{
                totalClass = totalClass + Float.parseFloat(strings[1]);
                totalScore += score.get(strings[2])*Float.parseFloat(strings[1]);
            }


        }System.out.println(Math.round(totalScore/totalClass*1000000) / 1000000.0);


    }
}