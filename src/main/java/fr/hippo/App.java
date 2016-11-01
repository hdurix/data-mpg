package fr.hippo;

import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        if (args.length < 3) {
            usage();
            System.exit(1);
        }

        String fileName = args[0];
        String league = args[1];
        String token = args[2];
        System.out.println("fileName = " + fileName);
        System.out.println("league = " + league);
        System.out.println("token = " + token);

        Extraction extraction = new Extraction();
        String url = "https://api.monpetitgazon.com/league/" + league + "/teams";
        String json;
        try {
            json = extraction.callWebService(url, token);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        PlayerList playerList = extraction.extractFromJson(json);
        List<String> csvLines = playerList.toCsv();
        System.out.println(csvLines.size() + " joueurs");
        //csvLines.forEach(System.out::println);
        extraction.writeInFile(fileName, csvLines);
    }

    private static void usage() {
        System.err.println("--------------------------------------------------------------");
        System.err.println("Problème lors de l'appel du programme");
        System.err.println("java -jar mpg-extract.jar __FILENAME__ __LEAGUE_ID__ __TOKEN_MPG__");
        System.err.println("--------------------------------------------------------------");
    }

}
