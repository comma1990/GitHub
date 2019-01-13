package commaTools.utils.common;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient {
    public static String getHttpResponse(URL url) {
        String httpResults = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3 * 1000);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, length);
                stringBuilder.append(s);
            }
            httpResults = stringBuilder.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResults;
    }

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            boolean flag = getHttpResponse(url).contains("STATUS OK");
            System.out.println(getHttpResponse(url));
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*      下面是尝试json使用
        public static void main(String[] args) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Content-Type","application/json");
        jsonObject.put("model","OPPO R9s");
        jsonObject.put("os","android");
        //jsonObject.put("App-Secret",getMD5s);
        jsonObject.put("mobile","18862396927");
    }*/
}
