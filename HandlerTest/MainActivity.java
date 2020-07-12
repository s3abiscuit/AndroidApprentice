package com.example.handlertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SEND_MESSAGE_FLAG = 1;
    private TextView tv_message;
    Button bt_send;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        private Bundle mData;

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SEND_MESSAGE_FLAG:
                    mData = msg.getData();
                    String name = mData.getString("name");
                    String sex = mData.getString("sex");
                    //tv_message.setText(msg.obj.toString());
                    tv_message.setText(name+" :  "+sex);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_send = findViewById(R.id.button);
        tv_message = findViewById(R.id.textView);

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        // 在此执行耗时工作，执行完毕后调用handler发送消息
                        try {
                            //睡眠1秒 模拟执行耗时任务
                            Thread.sleep(1000);
                            //发送消息
                            Message message = Message.obtain();
                            message.what = SEND_MESSAGE_FLAG;
                            Bundle mBundle = new Bundle();
                            mBundle.putString("name", "xxx");
                            mBundle.putString("sex", "男");
                            message.setData(mBundle);
                            mHandler.sendMessage(message);
                            //mHandler.obtainMessage(SEND_MESSAGE_FLAG, "消息来啦").sendToTarget();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
