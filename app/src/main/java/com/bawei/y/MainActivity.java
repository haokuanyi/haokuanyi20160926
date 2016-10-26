package com.bawei.y;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.dapter.MyListAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import bean.Bean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String path = "http://172.17.29.120/localuser/loupengfei/kaoshi/shoppingcar.json";
    public static TextView main_zong;
    private List<Bean.DataBean> dataList;
    private MyListAdapter adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dataList = (List<Bean.DataBean>) msg.obj;
            ListView listView = (ListView) findViewById(R.id.listView);
            adapter = new MyListAdapter(MainActivity.this, dataList);
            listView.setAdapter(adapter);


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                super.run();
                //获取数据源
                getDatas();
            }
        }.start();

        //控件初始化
        initView();


    }

    private void getDatas() {

        try {
            //用HttpURLConnection进行解析
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           //连接
            connection.connect();
            //连接成功
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
               //gson解析
                Gson gson = new Gson();
                Bean bean = gson.fromJson(new InputStreamReader(inputStream), Bean.class);
                List<Bean.DataBean> data = bean.getData();
                Message msg = Message.obtain();
                msg.obj = data;
                handler.sendMessage(msg);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
//全选反选找Id
        Button main_quanxuan_but = (Button) findViewById(R.id.main_quanxuan_but);
        main_quanxuan_but.setOnClickListener(this);
        Button main_fanxuan_but = (Button) findViewById(R.id.main_fanxuan_but);
        main_fanxuan_but.setOnClickListener(this);
//价格计算
        main_zong = (TextView) findViewById(R.id.main_zong);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击全选
            case R.id.main_quanxuan_but:
                for (Bean.DataBean db : dataList) {
                    db.setCb(true);
                }
                adapter.notifyDataSetChanged();

                break;
            //点击反选

            case R.id.main_fanxuan_but:
                for (int i = 0; i < dataList.size(); i++) {
                    if (dataList.get(i).getCb()) {
                        dataList.get(i).setCb(false);
                    } else {
                        dataList.get(i).setCb(true);
                    }
                }
                adapter.notifyDataSetChanged();


                break;
            case R.id.main_zong:
                break;
        }

    }
}
