package com.example.cga2351.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    Handler mainThreadHandler;
    Handler subThreadHandler;
    Handler subThread2Handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainThreadHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Message sendMsg = Message.obtain();
                        sendMsg.what = 0;
                        subThreadHandler.sendMessage(sendMsg);
                        Log.e(TAG, "main thread send msg to sub thread 1");
                    }
                }, 5000);

            }
        };

//        testThreadFunc();

        testObjCompare();

        return;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "MainActivity onActivityResult called! requestCode=" + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void testObjCompare() {

        Integer obj1 = new Integer(123);
        Integer obj2 = new Integer(123);
        final Integer tmp = obj1;

        //
        Log.e(TAG, "(obj1 == obj2)=" + String.valueOf(obj1 == obj2));
        Log.e(TAG, "(obj1.equals(obj2))=" + String.valueOf(obj1.equals(obj2)));
        Log.e(TAG, "obj1.toString()=" + obj1.toString());
        Log.e(TAG, "obj2.toString()=" + obj2.toString());
        Log.e(TAG, "obj1.hashCode()=" + obj1.hashCode());
        Log.e(TAG, "obj2.hashCode()=" + obj2.hashCode());
        Log.e(TAG, "obj1.this=" + obj1);
        Log.e(TAG, "obj2.this=" + obj2);


    }

    private void testThreadFunc() {

        //
        new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();

                subThreadHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {

                        subThreadHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Message sendMsg = Message.obtain();
                                sendMsg.what = 1;
                                subThread2Handler.sendMessage(sendMsg);
                                Log.e(TAG, "sub thread 1 send msg to sub thread 2");
                            }
                        }, 5000);
                    }
                };

                Message sendMsg = Message.obtain();
                sendMsg.what = 1;
                subThread2Handler.sendMessage(sendMsg);
                Log.e(TAG, "sub thread send msg to sub thread 2, init");

                Looper.loop();

                sendMsg.what = 1;
                subThread2Handler.sendMessage(sendMsg);
                Log.e(TAG, "sub thread send msg to sub thread 2, after loop");
            }
        }).start();


        HandlerThread subThread = new HandlerThread("sub thread 2");
        subThread.start();
        subThread2Handler = new Handler(subThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                subThread2Handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Message sendMsg = Message.obtain();
                        sendMsg.what = 0;
                        mainThreadHandler.sendMessage(sendMsg);
                        Log.e(TAG, "sub thread 2 send msg to main thread");
                    }
                }, 5000);
            }
        };
    }
}
