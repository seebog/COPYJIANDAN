package com.lession12_weather;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity implements LocationListener {
    WebView web1 = null;
    LocationManager lm;
    String url;
    ProgressDialog prgDlg=null;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web1 = (WebView) findViewById(R.id.web1);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        url=this.getResources().getString(R.string.url);
        prgDlg=new ProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
        prgDlg.setTitle("获取天气");
        prgDlg.setMessage("访问网络中....");


    }

    @Override
    protected void onResume() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //位置监听器一旦被注册，那么GPS就会被打开
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, this);

        super.onResume();
    }

    @Override
    protected void onPause() {
        //不用时
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.removeUpdates(this);
        super.onPause();
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.i("mytest", "维度" + location.getLatitude() + "维度" + location.getLongitude() + "海拔：" + location.getAltitude());
        new MyGetWeatherTask().execute(location);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lession12_weather/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lession12_weather/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public class MyGetWeatherTask extends AsyncTask<Location,Void,String> {

        @Override
        protected void onPreExecute() {
            prgDlg.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Location... params) {
            Location location=params[0];
            String urlStr=String.format(url,location.getLatitude(),location.getLongitude());
            try {
                URL url=new URL(urlStr);
                URLConnection con=url.openConnection();
                InputStream is = con.getInputStream();
                List<Weather> weatherList=getWeatherXML(is);


                String html=getWeatherHtnl(weatherList);


                Log.i("mytest",""+weatherList);
                return html;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }


            public String getWeatherHtnl(List<Weather> list){
                StringBuilder sb=new StringBuilder();
                sb.append("<html>");
                sb.append("<body>");

                sb.append("<table>");
                sb.append("<th>");
                sb.append("<td>天气</td><td>温度</td><td>时间</td>");

                sb.append("</th>");
                for (int i=0;i<list.size();i++){
                    sb.append("<tr>");
                    Weather w=list.get(i);
                    sb.append("<td><img src='"+w.icon+"'></td>");
                    sb.append("<td>"+w.temp+"</td>");
                    sb.append("<td>"+w.time+"</td>");

                    sb.append("</tr>");

                }


                sb.append("</table>");
                sb.append("</body>");
                sb.append("</htnl>");

                return sb.toString();
            }



        public List<Weather> getWeatherXML(InputStream is){
            List list=new ArrayList<Weather>();
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder=factory.newDocumentBuilder();
                Document doc = builder.parse(is);
                NodeList timeList=doc.getElementsByTagName("start-valid-time");

                NodeList  tempList=doc.getElementsByTagName("value");
                NodeList  iconList=doc.getElementsByTagName("icon-Link");
                for(int i=0;i<timeList.getLength();i++){
                    Weather weather=new Weather();
                    Element timeNode = (Element) timeList.item(i);
                    Element tempNode=(Element) tempList.item(i);
                    Element iconNode=(Element) iconList.item(i);

                    weather.time= timeNode.getFirstChild().getNodeValue();
                    weather.temp=tempNode.getFirstChild().getNodeValue();
                    weather.icon=iconNode.getFirstChild().getNodeValue();
                    list.add(weather);


                    list.add(weather);









                }





            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;



        }

        @Override
        protected void onPostExecute(String html) {

            web1.loadData(html,"text/html","utf-8");

            prgDlg.dismiss();


//            super.onPostExecute(html);
        }
    }




}
