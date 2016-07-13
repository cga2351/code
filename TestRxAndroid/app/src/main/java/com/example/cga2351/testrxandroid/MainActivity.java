package com.example.cga2351.testrxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {


    public interface Interface1
    {
        default int func1(int p) {return 0;}
        int func2(int p, int q);
    }

    private int doSomething() {
        return 0;
    }
    private int func1(int p) {
        return 0;
    }
    private int func2(int p, int q) {
        return 0;
    }
    private int func3(Interface1 if1) {
        return if1.func2(1, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                doSomething();
//            }
//        };
        Runnable runnable = this::doSomething;

        Func1<Integer, Integer> func1 = integer -> 0;

        Interface1 if1 = (p, q) -> 0;

        func3((p, q) -> p + q);
    }
}
