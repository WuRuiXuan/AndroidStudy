package com.example.wuruixuan.androidstudy.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;
import com.google.gson.Gson;

import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUrlConnectionActivity extends AppCompatActivity {

    private TextView tv_info;
    private EditText et_username, et_password;

    private final MyHandler handler = new MyHandler(this);
    private static final int LOGIN_SUCCESS = 200;
    private static final int LOGIN_ERROR = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection);

        tv_info = findViewById(R.id.textView_info);
        et_username = findViewById(R.id.editText_username);
        et_password = findViewById(R.id.editText_password);
    }

    // 登录功能
    public void login(View view) {
        String username = et_username.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String password = et_password.getText().toString();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // 启动登录工作线程
        // Android模拟器访问本地服务器ip：10.0.2.2（或使用真是IP）
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://10.0.2.2:8080/Android_NetServer/LoginServlet";
                try {
                    URL url = new URL(path);
                    // 打开http链接
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setConnectTimeout(1000 * 30); // 连接超时时间
                    conn.setReadTimeout(1000 * 30); // 读数据超时时间
                    conn.setUseCaches(false);
                    conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    // 对服务器端读取或写入数据（使用输入输出流）
                    // 获取连接的输出流
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes("username=" + URLEncoder.encode("vince", "GBK"));
                    out.writeBytes("&password=" + URLEncoder.encode("123", "GBK"));
                    out.flush();
                    out.close();
                    // 从服务器获取响应数据
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String result = br.readLine();
                    System.out.println("result=" + result);
                    br.close();
                    conn.disconnect(); // 关闭连接
                    Message msg = handler.obtainMessage(LOGIN_SUCCESS, result);
                    handler.sendMessage(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    handler.sendEmptyMessage(LOGIN_ERROR);
                }
            }
        }).start();
    }

    private static class MyHandler extends Handler {
        private final WeakReference<HttpUrlConnectionActivity> weakReference;
        public MyHandler(HttpUrlConnectionActivity httpUrlConnectionActivity) {
            weakReference = new WeakReference<HttpUrlConnectionActivity>(httpUrlConnectionActivity);
        };

        @Override
        public void handleMessage(Message msg) {
            HttpUrlConnectionActivity httpUrlConnectionActivity = weakReference.get();
            if (httpUrlConnectionActivity != null) {
                switch (msg.what) {
                    case LOGIN_SUCCESS:
                        String json = (String) msg.obj;
                        httpUrlConnectionActivity.jsonToObject(json);
                        break;
                    case LOGIN_ERROR:
                        httpUrlConnectionActivity.tv_info.setText("登陆失败，请检查用户名或密码是否正确！");
                        break;
                }
            }
        }
    }

    // 解析json为对象
    public void jsonToObject(String json) {
        Gson gson = new Gson();
        JSONObject object = gson.fromJson(json, JSONObject.class);
        tv_info.setText(object.toString());
    }
}
