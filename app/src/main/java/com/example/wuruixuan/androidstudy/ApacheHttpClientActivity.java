package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 两种请求方式的区别：
 * get: 大小不能超过4KB，速度快，会在URL上显示，不安全
 * post: 大小无限制，速度比GET稍慢，不会在URL上显示，安全性高
 */

public class ApacheHttpClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apache_http_client);
    }

    public void getClick(View view) {
        getRequest();
    }

    public void postClick(View view) {
        postRequest();
    }

    // 使用ApacheHttpClient的GET请求
    private void getRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "https://www.tianqiapi.com/api/?version=v1&cityid=101120201&city=%E9%9D%92%E5%B2%9B&ip=27.193.13.255&callback=%20";
                // 创建请求对象
                HttpGet get = new HttpGet(path);
                // 创建HTTP客户端对象，用于发送请求
                HttpClient httpClient = new DefaultHttpClient();
                try {
                    // 向服务器发送请求，并返回响应对象
                    HttpResponse response = httpClient.execute(get);
                    // 获取响应的状态码
                    int status = response.getStatusLine().getStatusCode();
                    switch (status) {
                        case HttpStatus.SC_OK: // 200
                            HttpEntity entity = response.getEntity();
                            String result = EntityUtils.toString(entity, "utf-8");
                            System.out.println(result);
                            break;
                        case HttpStatus.SC_FORBIDDEN: // 403
                            break;
                        case HttpStatus.SC_NOT_FOUND: // 404
                            break;
                        case HttpStatus.SC_INTERNAL_SERVER_ERROR: // 500
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 使用ApacheHttpClient的POST请求
    private void postRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://172.16.18.16:8000/Api/LogOutSystem";
                // 创建请求对象
                HttpPost post = new HttpPost(path);
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("Username", "string"));
                params.add(new BasicNameValuePair("SessionID", "string"));
                try {
                    HttpEntity entity = new UrlEncodedFormEntity(params);
                    post.setEntity(entity);

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpResponse response = httpClient.execute(post);
                    int status = response.getStatusLine().getStatusCode();
                    switch (status) {
                        case HttpStatus.SC_OK: // 200
                            String result = EntityUtils.toString(response.getEntity(), "utf-8");
                            System.out.println(result);
                            break;
                        case HttpStatus.SC_FORBIDDEN: // 403
                            Log.i("HttpClient", "403");
                            break;
                        case HttpStatus.SC_NOT_FOUND: // 404
                            Log.i("HttpClient", "404");
                            break;
                        case HttpStatus.SC_INTERNAL_SERVER_ERROR: // 500
                            Log.i("HttpClient", "500");
                            break;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
