import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    private static Player player;
    public static void main(String[] args) throws IOException {


        PlayerCreator pc = new PlayerCreator();
        player = pc.createNewPlayer();

        clearConsole();
        System.out.println("Processing...");



        createPlayerFiles(player);



    }

    private static void createPlayerFiles(Player player) throws IOException {

        String path = tryCreateDirectory();
        PDFFiller.buildPDF(player,path);
        writeFeatures(path);
    }

    private static void writeFeatures(String path) throws IOException {
        File features = new File(path +"/"+player.name+"-Features.txt");
        features.createNewFile();

        FileWriter fw = new FileWriter(path +"/"+player.name+"-Features.txt");
        fw.write(IOManager.ArrayListToString(player.features));
        fw.close();


    }
    private static String tryCreateDirectory(){
        boolean successfullCreation;
        String pathname ="./Player/"+playerNameToDirectory();
        int i=0;


        do {
            File directory = new File(pathname);

            if (!directory.exists()) {
                directory.mkdirs();
                successfullCreation = true;
            }else{
                i++;
                pathname="./Player/"+playerNameToDirectory()+i;
                successfullCreation = false;
            }
        }while(!successfullCreation);

        return pathname;
    }
    private static String playerNameToDirectory(){
        String playerName = player.name;
        playerName = playerName.replaceAll(" ", "_");
        return playerName;
    }

    public static void clearConsole() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }



}