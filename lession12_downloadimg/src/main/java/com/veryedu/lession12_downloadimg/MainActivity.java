package com.veryedu.lession12_downloadimg;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    ProgressDialog  prgDlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        prgDlg=new ProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
        prgDlg.setMax(100);
        prgDlg.setMessage("正在下载。。。。");
        prgDlg.setTitle("下载");
    }

    String url="http://f.hiphotos.baidu.com/image/pic/item/6c224f4a20a446237cd252b39c22720e0df3d7c3.jpg";

    public void clickBtn(View view)
    {
        if(view.getId()==R.id.downloadBtn)
        {
           new MyDownloadImageTask().execute(url);
        }
    }

    public class MyDownloadImageTask extends AsyncTask<String,Integer,Bitmap>
    {

        @Override
        protected void onPreExecute() {
            prgDlg.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            img1.setImageBitmap(bitmap);
            prgDlg.dismiss();
            super.onPostExecute(bitmap);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //更新进度框
            prgDlg.setProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url=params[0];

            HttpClient client=new DefaultHttpClient();
            HttpGet get=new HttpGet(url);
            try {
            HttpResponse response  =
                    client.execute(get);

                if(response.getStatusLine().getStatusCode()==200)
                {
                     long size  =  response.getEntity().getContentLength();
                     InputStream is = response.getEntity().getContent();
                    // Bitmap pic=BitmapFactory.decodeStream(is);
                    ByteArrayOutputStream  bos=new ByteArrayOutputStream();
                     byte[]  buff=new byte[1024];
                     int count=0;
                    int length=0;
                    while((length=is.read(buff))!=-1)
                    {
                         bos.write(buff,0,length);
                         count=count+length;
                        //计算进度
                         int prg=(int)( count*1.0/size*100);
                        //更新进度
                        this.publishProgress(prg);
                    }

                   byte[]  data= bos.toByteArray();
                   Bitmap pic= BitmapFactory.decodeByteArray(data,0,data.length);
                    return pic;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
