package com.example.cga2351.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cga2351 on 2016/6/15.
 */
public class Activity1 extends Activity {

    @Bind(R.id.et_input)
    EditText etInput;
    @Bind(R.id.btn_close)
    Button btnClose;
    @Bind(R.id.ll_activity_1)
    LinearLayout llActivity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick({R.id.et_input, R.id.btn_close, R.id.ll_activity_1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_input:
                break;
            case R.id.btn_close:
                Intent intent = new Intent();
                intent.putExtra("string","data from activity 1");
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.ll_activity_1:
                break;
        }
    }
}
