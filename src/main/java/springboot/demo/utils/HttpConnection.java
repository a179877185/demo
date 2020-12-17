package springboot.demo.utils;

import net.sf.json.JSONObject;
import org.apache.commons.io.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpConnection{



	public static InputStream doPostReturnIO(String requestURL,Map<String, String> parameterMap) {

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost(requestURL);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotEmpty(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, Charsets.UTF_8));
			HttpResponse response = client.execute(httpPost);

			return response.getEntity().getContent();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}


	public static JSONObject doGet(String requestURL,Map<String, String> parameterMap) {
		List<NameValuePair> pairs = new ArrayList<>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotEmpty(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}

		String query = "";
		if (pairs != null) {
			query = URLEncodedUtils.format(pairs, Charsets.UTF_8.name());
		}
		if(StringUtils.isNotBlank(query))
			requestURL += "?" + query;

		// System.out.println(requestURL);

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(requestURL);
		try {
			HttpResponse response = client.execute(httpGet);

			String string = EntityUtils.toString(response.getEntity());
			if(StringUtils.isBlank(string))return null;
			JSONObject fromObject = JSONObject.fromObject(string);
			return fromObject;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static JSONObject doGet1(String requestURL,Map<String, String> parameterMap) {
		List<NameValuePair> pairs = new ArrayList<>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotEmpty(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}

		String query = "";
		if (pairs != null) {
			query = URLEncodedUtils.format(pairs, Charsets.UTF_8.name());
		}
		if(StringUtils.isNotBlank(query))
			requestURL += "?" + query;

		// System.out.println(requestURL);

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(requestURL);
		try {
			HttpResponse response = client.execute(httpGet);
			response.setHeader("content-type", "text/html;charset=GBK");

			String string = EntityUtils.toString(response.getEntity());
			if(StringUtils.isBlank(string))
				return null;
			JSONObject fromObject = JSONObject.fromObject(string);
			return fromObject;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static JSONObject doPut(String requestURL,Map<String, String> parameterMap) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPut httpPut = new HttpPut(requestURL);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotEmpty(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}
		StringBuffer buffer = new StringBuffer();
		try {
			httpPut.setEntity(new UrlEncodedFormEntity(pairs, Charsets.UTF_8));
			HttpResponse response = client.execute(httpPut);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), Charsets.UTF_8));
			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSONObject.fromObject(buffer.toString());
	}

	public static JSONObject doPost(String requestURL,Map<String, String> parameterMap) {

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost(requestURL);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotEmpty(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}
		StringBuffer buffer = new StringBuffer();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, Charsets.UTF_8));
			HttpResponse response = client.execute(httpPost);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), Charsets.UTF_8));
			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSONObject.fromObject(buffer.toString());
	}

	public static JSONObject doPost_json(String requestURL, String jsonParam) {

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost(requestURL);

		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");

		StringBuffer buffer = new StringBuffer();
		try {
			httpPost.setEntity(entity);
			HttpResponse response = client.execute(httpPost);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), Charsets.UTF_8));
			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSONObject.fromObject(buffer.toString());
	}

	public static JSONObject doDelete(String requestURL,Map<String, String> parameterMap) {

		List<NameValuePair> pairs = new ArrayList<>();
		if (parameterMap != null) {
			String key = null;
			String value = null;
			for (Entry<String, String> entry : parameterMap.entrySet()) {
				key = entry.getKey();
				if (StringUtils.isNotBlank(key)) {
					value = entry.getValue();
				} else {
					value = "";
				}
				pairs.add(new BasicNameValuePair(key, value));
			}
		}

		String query = "";
		if (pairs != null) {
			query = URLEncodedUtils.format(pairs, Charsets.UTF_8.name());
		}
		requestURL += "?" + query;

		// System.out.println(requestURL);

		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete httpDelete = new HttpDelete(requestURL);
		StringBuffer buffer = new StringBuffer();
		try {
			HttpResponse response = client.execute(httpDelete);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), Charsets.UTF_8));
			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONObject.fromObject(buffer.toString());

	}
	  
}




