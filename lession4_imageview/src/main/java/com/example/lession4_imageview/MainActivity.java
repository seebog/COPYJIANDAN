package com.example.lession4_imageview;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
//import android.util.DisplayMetrics;
import android.util.Log;
//import android.view.MotionEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
public class MainActivity extends Activity {
    ImageView img1 = null;
    ImageView img2=null;
    int alpha=255;
    int index=-1;
    //只能获得手机内置SD卡的路径
    String dirPath =Environment.getExternalStorageDirectory()+"/imge";
//手机插入外置sd或者链接u盘这个方法是不能获得路径的
    File[] imgsPath;
//    String dirPath="/mnt/user/0/imge";
//String dirPath="/storage/emulated/0/imge";
    // /sdcard 4.0yishang
    // //mnt/sdcard  2.0


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        img2=(ImageView)findViewById(R.id.img2);
        //触摸事件
        img1.setOnTouchListener(lst);
        //获得扩展存储器的目录
        initPicDir();
        nextSDCardImage();
//        nextImage();
//               nextImage();

    }
    View.OnTouchListener lst=new View.OnTouchListener() {
        //可以识别十个手指头的.......识别脚趾头的哦~~~~~~~~
        @Override
        public boolean onTouch(View v, MotionEvent event) {
           float x =  event.getX();
           float y = event.getY();
           //要从图片上截图，坐标系要换算成图片的坐标系
            //首先要计算图片的缩放倍率


            //凡是小数全部选用flaot 默认为double所以21.5f  float占用内存较小
           //截图。获得图片获得img1的原始图片
           BitmapDrawable da =(BitmapDrawable)img1.getDrawable();
           Bitmap srcPic=da.getBitmap();
           //缩放倍率使用的是fitStar缩放，所以缩放倍率scale=图片高/imageview的高
            float scale= srcPic.getHeight()*1.0f/img1.getHeight();
            //计算在图片坐标系中的原始坐标
            float x1=scale*x;
            float y1=scale*y;
            //从原图片中截取出长宽各100的小图片
           Bitmap subPic=Bitmap.createBitmap(srcPic,(int)x1,(int)y1,100,100);


            img2.setImageBitmap(subPic);

            return true;



        }
    };



    public void clickBtn(View view) {

        int id = view.getId();
        if (R.id.addAlphaBtn == id) {
            //增加透明度  增加alph值是减小透明度
//            alpha-=1;
            changeAlpha(1);
            img1.setImageAlpha(alpha);


        } else if (R.id.redAlphaBtn == id) {
            changeAlpha(2);
            img1.setImageAlpha(alpha);

        }else if(R.id.nextBtn == id){
//            nextImage();
            nextSDCardImage();

        }
    }
    public void initPicDir(){
//        File dir=new File(dirPath);
//        Log.i("dir","dir="+dir+"  dirPath"+dirPath);
//        if(dir!=null && dir.isDirectory()){
//            imgsPath = dir.listFiles();//得到文件夹下所以有文见
//        Log.i("tester","  dirPath="+dirPath );
        File dir=new File(dirPath);
        Log.i("tester","dir="+dir+"  dirPath="+dirPath );
//        boolean b=(dir==null);
//        Log.i("bbb","aaaa"+b);
        if(dir!=null && dir.isDirectory()) {//经过logi这段if是没有错不可能走进else应该是遍历文件夹出错
            imgsPath=dir.listFiles();//这里尼玛的为什么是null呢 也是文件也有权限为什么就是null呢

            Log.i("imgePath","imgePath"+imgsPath);//imgsPath为null
        }


        }


    public void nextSDCardImage(){

//        index++;
//        index=index>=imgsPath.length?0:index;
//        String picPath=imgsPath[index].getAbsolutePath();
//        Log.i("test","picPath"+picPath);
//        Bitmap pic= BitmapFactory.decodeFile(picPath);
//        img1.setImageBitmap(pic);

        index++;
//        index=index>5?0:index;

        index=index>=imgsPath.length?0:index;
//        Log.i("length","imagePath"+imgsPath.length);
//        String picPath=imgsPath[index].getAbsolutePath();

        String picPath=imgsPath[index].getAbsolutePath();
        Log.i("txt","picPath="+picPath);
        Bitmap pic= BitmapFactory.decodeFile(picPath);
        Log.i("txt","picPath=aaa"+picPath);
//        -------------------------------------
//        DisplayMetrics dm=new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenWidth=dm.widthPixels;
//        if(pic.getWidth()<=screenWidth){
//
//            img1.setImageBitmap(pic);
//        }else{
//
//            Bitmap bmp=Bitmap.createScaledBitmap(pic,screenWidth,pic.getHeight()*screenWidth/pic.getWidth(),true);
//            img1.setImageBitmap(bmp);
//
//        }
//         ---------------===================
        img1.setImageBitmap(pic);

    }
        public void nextImage(){
            index++;
            index=index>9?0:index;

            int resId=R.drawable.a01+index;
            img1.setImageResource(resId);




    }





    public void changeAlpha(int type){
        if(type==1){

            alpha+=5;
        }else if(type==2){
            alpha-=5;
        }
    alpha=alpha>255?255:alpha;
    alpha=alpha<0?0:alpha;

    }


}
