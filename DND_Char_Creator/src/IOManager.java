import java.util.ArrayList;
import java.util.Scanner;



public class IOManager {
    private static final Scanner input = new Scanner(System.in);




    public static String getString(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }


    public static int getInt(String prompt){
        String temp;

        do{
            System.out.println("\n"+prompt);
            temp=input.nextLine();
        }while(isNumeric(temp));

        return Integer.parseInt(temp);
    }

    public static int getInt(String prompt,int upperLimit){
        String temp;
        boolean inLimit;

        do {
            inLimit =true;

            do {
                System.out.println("\n" + prompt+" [0-"+upperLimit+"]");
                temp = input.nextLine();
            } while (isNumeric(temp));

            if (Integer.parseInt(temp) >upperLimit){
                System.out.println("ERROR: Input Integer to big, only input Integers up to "+upperLimit);
                inLimit = false;
            }
        }while(!inLimit);

        return Integer.parseInt(temp);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch(NumberFormatException e){
            System.out.println("ERROR: Please enter a valid Integer");
            return true;
        }
    }


    public static <T> T getArrayElement(String prompt,T[] arr) {
        return arr[getInt(prompt+" [1-"+arr.length+"]   \n\n"+arrToString(arr)+"\n",arr.length)-1];
    }

    public static <T> T getNamedArrayElement(String prompt,T[] arr) {
        return arr[getInt(prompt+" [1-"+arr.length+"]"+arrToNames(arr)+"\n",arr.length)-1];
    }



    public static <T> int getArrayIndex(String prompt,T[] arr) {
        return getInt(prompt+" [1-"+arr.length+"]"+arrToString(arr)+"\n",arr.length)-1;
    }



    private static <T> String arrToString(T[] arr){
        StringBuilder returnString= new StringBuilder();

        for (int i=0; i<arr.length; i++){
            returnString.append("\n").append(i + 1).append(". ");
            returnString.append(arr[i].toString());
        }
        return returnString.toString();
    }

    private static <T> String arrToNames(T[] arr){
        if (arr[0] instanceof Named) {
            StringBuilder returnString= new StringBuilder();

            for (int i=0; i<arr.length; i++){
                returnString.append("\n").append(i + 1).append(". ");
                returnString.append(((Named)arr[i]).getName());
            }
            return returnString.toString();
        }
        return "ERROR";
    }

    public static <T> String ArrayListToString(ArrayList<T> input){
        StringBuilder returnString= new StringBuilder();

        for (T t : input) {
            returnString.append("\n\n").append(t.toString());
        }

        return returnString.toString();
    }

    public static <T> String ArrayListToNames(ArrayList<T> input){
        StringBuilder returnString= new StringBuilder();

        for (T t : input) {
            if(t instanceof Named)  returnString.append("\n\n").append(((Named) t).getName());
        }

        return returnString.toString();
    }
    public static <T> void removeArrayElement(T[] array,int index){

        System.arraycopy(array, index + 1, array, index, array.length - index - 1);


    }

    public static <T> int getArrayIndex(T[] array, T element){
        for(int i=0; i<array.length; i++){
            if (array[i] == element) return i;
        }
        return 0;
    }




}
