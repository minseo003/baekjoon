import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws Exception {

        double[] point = {4.5 , 4.0 , 3.5 , 3.0 , 2.5 , 2.0 , 1.5 , 1.0 , 0.0};
        String[] grade = {"A+" , "A0" , "B+" , "B0" , "C+" , "C0" , "D+" , "D0" , "F"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        double answer = 0.0;
        double sum = 0.0;

        while((input = br.readLine()) != null) {
            String[] sar = input.split(" ");
            if(sar[2].equals("P")) continue;

            for (int i = 0; i < grade.length; i++) {
                if(sar[2].equals(grade[i])) {
                    answer += point[i] * Double.parseDouble(sar[1]);
                    sum += Double.parseDouble(sar[1]);
                }
            }
        }
        System.out.print(answer / sum);
    }

}