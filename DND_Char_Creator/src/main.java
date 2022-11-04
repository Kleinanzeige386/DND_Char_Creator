import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {


        PlayerCreator pc = new PlayerCreator();
        Player temp = pc.createNewPlayer();


        System.out.println(temp.toString());


        PDFFiller.buildPDF(temp);




    }


}