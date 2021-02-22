import java.net.URL;
import java.util.Scanner;

public class URLReader {
    private String urlString;
    private String theURLContents;

    public URLReader(String urlString) {
        this.urlString = urlString;
        this.theURLContents = "";

        //get data from url
        this.readFromURL();
    }

    public void display() {
        System.out.println(this.theURLContents);
    }

    private void readFromURL () {
        String line = "";
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            // open the url stream, wrap it an a few "readers"
            //BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            //keep reading from the scanner as long as their is something to read
            while (input.hasNext()) {
                line += input.nextLine();
            }

            // close our reader
            input.close();

            //reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            line = "Can't Connect";
        }
        this.theURLContents = line;
    }

    public String getTheURLContents() {
        return theURLContents;
    }
}
