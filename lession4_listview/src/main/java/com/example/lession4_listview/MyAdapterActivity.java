package com.example.lession4_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterActivity extends AppCompatActivity {
    ListView myAdapterLst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adapter);

        myAdapterLst=(ListView) findViewById(R.id.myAdapterLst);
       MyGameAdapter adapter=new MyGameAdapter(this);
        myAdapterLst.setAdapter(adapter);

    }
    public class MyGameAdapter extends BaseAdapter{
        List<GameEntity> dataList;
        //布局文件解析器
        LayoutInflater inflater;
        Context context;
        public MyGameAdapter(Context context){
            this.context=context;
// 最原始的方法
            inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//            inflater=LayoutInflater.from(context);
            loadData();
        }
        public void loadData(){

        dataList=new ArrayList<GameEntity>();
            for(int i=0;i<50;i++){
                GameEntity g=new GameEntity();
                g.gameName="愤怒的小鸟"+i;
                g.gameSize=(2+i)+"M";
                g.gameIconID=R.drawable.bird+(i%10);
                dataList.add(g);
            }

        }
        //得到数据集的总数
        @Override
        public int getCount() {

            return dataList.size();


        }
        //
        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;


        }


        //getView是核心方法用来确定ListView中每一行要显示的内容
        //所以它的返回值是一个View,这个View就是列表中每一行的行视图
        //第一个参数postition是要显示行的行号所以当listView要显示出来时
        //假设列表中一屏要显示10行，那么这个getView方法会反复调用10便
        //来获得每一行的视图


// /第一个参数是第几行
        //第二个得到这一行的视图
//ListView优化
        //1------不能每一行创建一个View而是应该重用convertView
        //2------使用viewHolder对象记录下view里面的每个控件，holder对象保存在每一行的比行视图tag中 ，减少搜索的次数
        //3------使用分页 PullToRefresh这样的第三方控件，实现下拉更新操作


//Adapter除了在ListView中使用外，也广泛使用在GridView,Spinner,ViewPager等容器类控件中




        public class ViewHolder{
            TextView gameNameTxt;
            TextView gameSizeTxt;
            ImageView gameIconImg;
            Button downloadBtn;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

//                 优化前
//          View view=inflater.inflate(R.layout.line_item,null);
//          Log.i("test","pos"+position+" view="+view+" convertView"+convertView);
                     //优化后
            if(convertView==null){
             //如果为空  意味着是listview的第一次显示，需要创建view对象
            //这样就可以重用convertview减少view对象的创建

             convertView=inflater.inflate(R.layout.line_item,null);
                ViewHolder holder=new ViewHolder();
             holder.gameNameTxt=(TextView) convertView.findViewById(R.id.gameTxt);
            holder.gameSizeTxt=(TextView) convertView.findViewById(R.id.sizeTxt);
            holder.gameIconImg=(ImageView) convertView.findViewById(R.id.gameIcon);
            holder.downloadBtn=(Button) convertView.findViewById(R.id.downloadBtn);
            convertView.setTag(holder);


         }


          final GameEntity game=(GameEntity) getItem(position);

            ViewHolder holder=(ViewHolder)convertView.getTag();

//            TextView gameTxt=(TextView) view.findViewById(R.id.gameTxt);
//            TextView sizeTxt=(TextView) view.findViewById(R.id.sizeTxt);
//            ImageView gameIcon=(ImageView) view.findViewById(R.id.gameIcon);
//            Button downloadBtn=(Button) view.findViewById(R.id.downloadBtn);
                    //convertView优化后
//            TextView gameTxt=(TextView) convertView.findViewById(R.id.gameTxt);
//            TextView sizeTxt=(TextView) convertView.findViewById(R.id.sizeTxt);
//            ImageView gameIcon=(ImageView) convertView.findViewById(R.id.gameIcon);
//            Button downloadBtn=(Button) convertView.findViewById(R.id.downloadBtn);
                        //优化前
//            gameTxt.setText(game.gameName);
//            sizeTxt.setText(game.gameSize);
//            gameIcon.setImageResource(game.gameIconID);
//            downloadBtn.setOnClickListener(new View.OnClickListener() {

                    //优化后
            holder.gameNameTxt.setText(game.gameName);
            holder.gameSizeTxt.setText(game.gameSize);
            holder.gameIconImg.setImageResource(game.gameIconID);
            holder.downloadBtn.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View v) {
//                    Toast.makeText(MyAdapterActivity.this,"正在下载"+ game.gameName).show();
                Toast.makeText(MyAdapterActivity.this,"正在下载："+game.gameName,Toast.LENGTH_LONG).show();

                }
            });

            return convertView;
        }
    }



}
