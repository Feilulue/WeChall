import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class RequestAndResponse {

    private static String requestURL = "https://www.wechall.net/challenge/training/programming1/index.php?";
    private static String myCookie = "WC=xxxxxxxxxxxx";

    private static String URLRequest(String parameter) throws Exception{
        URL url = new URL(requestURL+parameter);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Cookie",myCookie);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer sendBack = new StringBuffer();
        String getLine;

        while((getLine = in.readLine()) != null) sendBack.append(getLine);
        in.close();

        return sendBack.toString();
    }




    public static void main(String[] args) throws Exception{
        String message = URLRequest("action=request");
        URLRequest("answer="+message);
    }
}
