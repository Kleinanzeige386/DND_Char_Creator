import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        PlayerCreator pc = new PlayerCreator();
        Player temp = pc.createNewPlayer();


        System.out.println(temp.toString());
        
        writeToFile(temp.name,temp.toString());



    }

    public static void writeToFile(String name, String str) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(name+".txt"));
        writer.write(str);

        writer.close();
    }
}