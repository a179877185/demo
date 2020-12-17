package springboot.demo.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HttpsClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpsClientUtils.class);

    public HttpsClientUtils() {
    }

    public static String doPost(String url, HashMap<String, String> map, String charset, String token) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;

        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            if(!StringUtils.isEmpty(token)){
                httpPost.setHeader("Authorization", token);
            }
            List<NameValuePair> list = new ArrayList();
            Iterator iterator = map.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry)iterator.next();
                list.add(new BasicNameValuePair((String)elem.getKey(), (String)elem.getValue()));
            }

            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }

            HttpResponse response = httpClient.execute(httpPost);
            logger.info(response.getEntity().getContent().toString());
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("回调返回状态{}", statusCode);
                if (200 == statusCode) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, charset);
                    }
                } else {
                    result = String.valueOf(statusCode);
                }
            }

            return result;
        } catch (Exception var12) {
            var12.printStackTrace();
            return result;
        }
    }

    public static String doGet(String url, HashMap<String, String> map, String charset, String token) {
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;

        try {
            httpClient = new SSLClient();
            List<NameValuePair> list = new ArrayList();
            Map.Entry elem;
            if (map != null) {
                Iterator iterator = map.entrySet().iterator();

                while(iterator.hasNext()) {
                    elem = (Map.Entry)iterator.next();
                    list.add(new BasicNameValuePair((String)elem.getKey(), (String)elem.getValue()));
                }
            }

            String param = "";
            elem = null;
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                param = "?" + EntityUtils.toString(entity);
            }

            httpGet = new HttpGet(url + param);
            httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Authorization", token);
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("回调返回状态{}", statusCode);
                if (200 == statusCode) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, charset);
                    }
                }
            }

            return result;
        } catch (Exception var13) {
            return result + JSON.toJSONString(var13.getStackTrace());
        }
    }
}
