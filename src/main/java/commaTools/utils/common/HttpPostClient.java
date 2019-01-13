package commaTools.utils.common;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static commaTools.utils.common.GetDate.getTimesTamp;

public class HttpPostClient {
    public static String getHttpResponse(URL url,JSONObject object) {
        //String line = "";
        String httpResults = "";
        try {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.setRequestProperty("appT", getTimesTamp());
            connection.setRequestProperty("App-Secret", "3417ecda34b5d55d77083a9784fb847f");
            connection.setRequestProperty("App-Key", "iwjw.superjia.com");
            connection.setRequestProperty("imei", "958A6EDC-23FD-4D52-BD40-FC0CD805FFA7");
            connection.setRequestProperty("model", "iPhone7 Plus");
            connection.setRequestProperty("os", "iPhone OS");
            connection.setRequestProperty(" Data-Type", "json");

            connection.setConnectTimeout(3 * 1000);
            connection.connect();
            //定义连接后的输入流
            DataOutputStream dataOutputStream=new DataOutputStream(connection.getOutputStream());
            //JSONObject object=new JSONObject();
            //需要的json值
            //object.put("rentId","1695");
            dataOutputStream.writeChars(object.toString());
            //获取连接后读取的输入流
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

/*    public static void main(String[] args) {
        URL url = null;
        JSONObject object=new JSONObject();
        object.put("rentId","1695");
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            boolean flag = getHttpResponse(url,object).contains("STATUS OK");
            System.out.println(getHttpResponse(url,object));
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
