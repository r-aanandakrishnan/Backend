
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader implements Serializable{
  private String key,value;

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
}
public class filehandle
{
  private static final String filepath="C:\\Users\\krishna\\Desktop\\obj";
  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://url");
    System.out.println(json.toString());
    String s=json.get("key");
    String t=json.get("value");
    filehandle f=new filehandle();
    JsonReader js= new JsonReader(s,t);
    
}