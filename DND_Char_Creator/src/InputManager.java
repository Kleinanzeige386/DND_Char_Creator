import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputManager {
    private static Scanner input = new Scanner(System.in);




    public static String getString(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }


    public static int getInt(String prompt){
        String temp;

        do{
            System.out.println("\n"+prompt);
            temp=input.nextLine();
        }while(!isNumeric(temp));

        return Integer.parseInt(temp);
    }
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            System.out.println("ERROR: Please enter a valid Integer");
            return false;
        }
    }


    public static <T> T getArrayElement(String prompt,T[] arr) throws IOException {
        return arr[getInt(prompt+" [1-"+arr.length+"]   \n\n"+arrToString(arr)+"\n")-1];
    }
    private static <T> String arrToString(T[] arr){
        List<T> temp= new ArrayList<>();

        Collections.addAll(temp, arr);

        return temp.stream().map(Object::toString)
                .collect(Collectors.joining("\n\n"));
    }


}
