package com.example.cga2351.testrxandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.pb_update_ui)
    ProgressBar pbUpdateUi;
    @Bind(R.id.btn_proc_in_main_thread)
    Button btnProcInMainThread;
    @Bind(R.id.btn_proc_in_async_task)
    Button btnProcInAsyncTask;
    @Bind(R.id.btn_proc_with_rx)
    Button btnProcWithRx;
    @Bind(R.id.tv_result)
    TextView tvResult;

    int mCurResult = 0;
    View mRootView = null;

    private void handleResult(int result) {
        tvResult.setText(String.valueOf(result));
        mCurResult = result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRootView = findViewById(android.R.id.content);

    }

    @OnClick({R.id.btn_proc_in_main_thread, R.id.btn_proc_in_async_task, R.id.btn_proc_with_rx})
    public void onClick(View view) {
        int param = mCurResult;
        switch (view.getId()) {
            case R.id.btn_proc_in_main_thread:
                handleInMainThread(param);
                break;

            case R.id.btn_proc_in_async_task:
                handleInAsyncTask(param);
                break;

            case R.id.btn_proc_with_rx:
                handleWithRxAndroid(param);
                break;
        }
    }

    private class MyAsyncTask extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            handleResult(integer);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            if (integers.length > 0) {
                int result = integers[0];
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                result++;

                return result;
            }

            return null;
        }
    }

    private void handleInMainThread(int params) {
        try {
            Thread.sleep(5000);
            params++;
            handleResult(params);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleInAsyncTask(int params) {
        new MyAsyncTask().execute(params);
    }

    private void handleWithRxAndroid(final int param) {

        Retrofit a;


//         使用IO线程处理, 主线程响应
        final Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(longRunningOperation(param));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        btnProcWithRx.setEnabled(false);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                btnProcWithRx.setEnabled(true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer result) {
                Snackbar.make(mRootView, "result=" + result, Snackbar.LENGTH_LONG).show();
                handleResult(result);
            }
        });



    }

    private Integer longRunningOperation(int param) {
        try {
            Thread.sleep(5000);
            param++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return param;
    }
}
