package com.ycyl.edu.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("all")
public class HttpClient {
	public final static Log log = LogFactory.getLog(HttpClient.class);
	private String api_url;
	private String url;

	public String getApi_url() {
		return api_url;
	}

	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpClient(String url) {
		this.url = url;
	}

	/* // MD5函数 */
	public static String md5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
	

	public JSONObject getJObject(String a, List params) {
		JSONObject jsonObject = null;
		String parm = URLEncodedUtils.format(params, "UTF-8");
		if ("token".equals(a)) {
			this.api_url = this.url + "/apis/token?callback&";
		}
		else if("listone".equals(a)){
			this.api_url = this.url + "/apis/conf/edit?callback&";
		}
		else if("create".equals(a)){
			this.api_url = this.url + "/apis/conf/add?callback&";
		}
		else if("update".equals(a)){
			this.api_url = this.url + "/apis/conf/edit?callback&";
		}
		else if("remove".equals(a)){
			this.api_url = this.url + "/apis/conf/del?callback&";
		}
		else if("login".equals(a)){
			this.api_url = this.url + "/apis/conf/login?callback&";
		}	
		else if("adduser".equals(a)){
			this.api_url = this.url + "/apis/user/add?callback&";
		}
		else if("edituser".equals(a)){
			this.api_url = this.url + "/apis/user/edit?callback&";
		}
		else if("deluser".equals(a)){
			this.api_url = this.url + "/apis/user/delete?callback&";
		}
		else if("confuseradd".equals(a)){
			this.api_url = this.url + "/apis/conf/confuseradd?callback&";
		}
		else if("confuserdel".equals(a)){
			this.api_url = this.url + "/apis/conf/confuserdel?callback&";
		}
		else if("confuseraddbyaccount".equals(a)){
			this.api_url = this.url + "/apis/conf/confuseraddbyname?callback&";
		}
		else if("confuserdelbyaccount".equals(a)){
			this.api_url = this.url + "/apis/conf/confuserdelbyname?callback&";
		}
		else if("confadminlist".equals(a)){
			this.api_url = this.url + "/apis/conf/confadminlist?callback&";
		}
		else if("confcommonlist".equals(a)){
			this.api_url = this.url + "/apis/conf/confcommonlist?callback&";
		}
		else {
			
		}
		log.error(this.api_url+parm);
		JSONParser parser = new JSONParser();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(this.api_url+parm);
			HttpResponse response = null;
			try {
				response = httpclient.execute(httpget);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonstr = EntityUtils.toString(entity,"UTF-8");
				if(jsonstr.startsWith("(")){
					jsonstr = jsonstr.substring(1, jsonstr.length()-1);
				}
				if(jsonstr.endsWith(")")){
					jsonstr = jsonstr.substring(0, jsonstr.length()-2);
				}
				log.error(jsonstr);
				Object obj = parser.parse(jsonstr);
				jsonObject = (JSONObject) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return jsonObject;
	}
	

	public JSONArray getJArray(String a, List params) {
		JSONArray jsonarr = null;
		String parm = URLEncodedUtils.format(params, "UTF-8");
		if("listall".equals(a)){
			this.api_url = this.url + "/apis/conf/list?callback&";
		} 
		else if("group".equals(a)){
			this.api_url = this.url + "/apis/conf/group?callback&";
		}
		else if("online".equals(a)){
			this.api_url = this.url + "/apis/conf/online?callback&";
		}
		else if("dept".equals(a)){
			this.api_url = this.url + "/apis/conf/dept?callback&";
		}
		else if("logconf".equals(a)){
			this.api_url = this.url + "/apis/log/conf/all?callback&";
		}
		else if("loguser".equals(a)){
			this.api_url = this.url + "/apis/log/user/all?callback&";
		}
		else if("logconfsingle".equals(a)){
			this.api_url = this.url + "/apis/log/conf/single?callback&";
		}
		else if("logusersingle".equals(a)){
			this.api_url = this.url + "/apis/log/user/single?callback&";
		}
		else if("userlist".equals(a)){
			this.api_url = this.url + "/apis/user/list?callback&";
		}
		else if("edituser".equals(a)){
			this.api_url = this.url + "/apis/user/edit?callback&";
		}
		else if("confuserlist".equals(a)){
			this.api_url = this.url + "/apis/conf/confuserlist?callback&";
		}
		else {
			
		}
		log.error(this.api_url+parm);
		
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(this.api_url+parm);
			HttpResponse response = null;
			try {
				response = httpclient.execute(httpget);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonstr = EntityUtils.toString(entity,"UTF-8");
				if(jsonstr.startsWith("(")){
					jsonstr = jsonstr.substring(1, jsonstr.length()-1);
				}
				if(jsonstr.endsWith(")")){
					jsonstr = jsonstr.substring(0, jsonstr.length()-2);
				}
				log.error(jsonstr);
				Object obj=JSONValue.parse(jsonstr);
				jsonarr = (JSONArray)obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return jsonarr;
	}
	public String getString(String a, List params) {
		String rs="";
		String parm = URLEncodedUtils.format(params, "UTF-8");
		if("confadminlist".equals(a)){
			this.api_url = this.url + "/apis/conf/confadminlist?callback&";
		}
		else if("confcommonlist".equals(a)){
			this.api_url = this.url + "/apis/conf/confcommonlist?callback&";
		}
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(this.api_url+parm);
			HttpResponse response = null;
			try {
				response = httpclient.execute(httpget);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonstr = EntityUtils.toString(entity,"UTF-8");
				if(jsonstr.startsWith("(")){
					jsonstr = jsonstr.substring(1, jsonstr.length()-1);
				}
				if(jsonstr.endsWith(")")){
					jsonstr = jsonstr.substring(0, jsonstr.length()-2);
				}
				rs = jsonstr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}		
		return rs;
	}
}
