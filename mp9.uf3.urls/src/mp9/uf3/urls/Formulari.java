package mp9.uf3.urls;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Formulari {
    public static void main(String[] args){
        String nom = "frank";
        String Parametros = "entry.835030737="+nom+"&entry.1616686619=Si";
        String request = "https://docs.google.com/forms/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/viewform";

        Formulari.excutePost(request, Parametros);
    }
    private static void excutePost(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {

            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();

            connection.setDoOutput(true);


            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close ();


            InputStream is = connection.getInputStream();


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }


}
