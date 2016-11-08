package com.example.lession10_threadtest;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView prgTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   prgTxt=(TextView)findViewById(R.id.prgTxt);
    }

    public void clickBtn(View view) {

//        SystemClock.sleep(20000);
//        prgTxt.post(
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
//            Thread.sleep(1000);需要抛出异常
                    SystemClock.sleep(1000);
                    //通过网主线程发送消息的形式
//                    Message msg = new Message();
                        //从消息池2中生成
//                    Message msg=Message.obtain();
                    Message msg=handler.obtainMessage();


                    //这个What属性值是用来给msg一个编号以便区分
                    msg.what=0x101;
                    Bundle data = new Bundle();
                    data.putInt("progress", i);
                    msg.setData(data);
                    handler.sendMessage(msg);


//                        prgTxt.setText("已下载" + i + "%");

                }

//                super.run();
            }


        }.start();

    }

    //handler是与主线程绑定的消息发送对象专门给主线程发送消息的f负责消息的发送也负责消息的处理
    Handler handler =new Handler(){
    @Override
    public void handleMessage(Message msg) {
//        super.handleMessage(msg);
        if(msg.what==0x101){
             int prg=msg.getData().getInt("progress");
            prgTxt.setText("下载进度"+prg+"%");

        }
    }
};

}
