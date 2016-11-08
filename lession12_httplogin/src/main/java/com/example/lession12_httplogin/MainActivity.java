package com.example.lession12_httplogin;

import android.content.Entity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText nameTxt;
    EditText pwdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt=(EditText)findViewById(R.id.nameTxt);
        pwdTxt=(EditText)findViewById(R.id.pwdTxt);


    }

    public void clicBtn(View view){
        int id =view.getId();
        if(R.id.loginBtn==id){
            String name=nameTxt.getText().toString();
            String pwd=pwdTxt.getText().toString();
            new MyLoginTask().execute(url,name,pwd);




        }

    }

    String url="http://localhost:8080/XMPPY/login.do";
    public class MyLoginTask  extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
           String url=params[0];
            String username=params[1];
            String pwd=params[2];


            HttpClient client= new DefaultHttpClient();
            HttpPost post=new HttpPost(url);
            List<NameValuePair>  values=new ArrayList<>();


            values.add(new BasicNameValuePair("username",username));
            values.add(new BasicNameValuePair("pwd",pwd));

//            Entity是封装表单数据
//            HttpEntity entity= null;
            try {
                //封装post请求的消息体
                HttpEntity entity = new UrlEncodedFormEntity(values ,"utf-8" );
                post.setEntity(entity);
                HttpResponse response = client.execute(post);
                Log.i("test","respCode="+response.getStatusLine().getStatusCode());


                //获取响应状态吗
                if (response.getStatusLine().getStatusCode()==200){
                    //把响应的消息体转换成字符串
                    String msg = EntityUtils.toString( response.getEntity());
                        return msg;

                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
//            post.setEntity(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        //转到onPostExecute
        }

        public User getUserFromJson(JSONObject json) throws JSONException {

            //google的Gson可以转换json和javabean

            Gson gson=new Gson();
            User user=gson.fromJson(json.getJSONObject("user").toString(),User.class);




//            JSONObject userObj= json.getJSONObject("user");
//
//
//            if(userObj!=null) {
//                User user = new User();
//                Log.i("mytest","user="+user);
//                user.setUserid(userObj.getInt("userid"));
//                user.setUsername(userObj.getString("username"));
//                user.setPwd(userObj.getString("pwd"));
//                user.setAge(userObj.getInt("age"));
//                return user;
//            }
//            return null;
            return user;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject obj=new JSONObject(s);
                int code=obj.getInt("code");
                if(code==101){

                   User user= getUserFromJson(obj);
                    Toast.makeText(MainActivity.this,"欢迎"+user.getUsername(),Toast.LENGTH_LONG).show();

                }else if(code==102){

                    String msg = obj.getString("msg");
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
//             super.onPostExecute(s);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }




}
