package com.example.lession12_downloadimone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ProgressDialog proDlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        proDlg=new ProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
        proDlg.setMax(100);
        proDlg.setMessage("正在下载...");
        proDlg.setTitle("下载");

    }
    String url1="https://www.baidu.com/img/bd_logo1.png";
//    URL url=new URL("https://www.baidu.com/img","9080","/bd_logo1.png");
//    URL a=new URL("http://192.168.0.63:8888");
    public void clickBtn(View view){

        if(view.getId()==R.id.dowloadBtn){

            new MydownloadImageTask().execute(url1);


        }


    }

    public class MydownloadImageTask extends AsyncTask<String,Integer,Bitmap> {

        @Override
        protected void onPreExecute() {
            proDlg.show();
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            img1.setImageBitmap(bitmap);
            proDlg.dismiss();
            super.onPostExecute(bitmap);


        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url=params[0];
        HttpClient client=new DefaultHttpClient();
            HttpGet get=new HttpGet(url);
            try {
                HttpResponse response=client.execute(get);
                if(response.getStatusLine().getStatusCode()==200){

                    Long size = response.getEntity().getContentLength();
                    InputStream is=response.getEntity().getContent();

//                    Bitmap pic=BitmapFactory.decodeStream(is);

                    ByteArrayOutputStream bos=new ByteArrayOutputStream();

                    byte[] buf=new byte[1024];
                    int count=0;
                    int length=0;
                    while((length=is.read(buf))!=-1){
                        bos.write(buf,0,length);
                        count+=length;
                       //计算进度
                        int prg=(int)( count*1.0/size*100);
                        //更新进度
                        this.publishProgress(prg);





                    }

                    byte[] data= bos.toByteArray();
                    Bitmap pic= BitmapFactory.decodeByteArray(data,0,data.length);
                    return  pic;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
//            HttpURLConnection conn = (HttpURLConnection) url.o

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //更新进度框
            proDlg.setProgress(values[0]);

            super.onProgressUpdate(values);
        }
    }





}
