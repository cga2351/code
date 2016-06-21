package com.example.cga2351.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cga2351 on 2016/6/15.
 */
public class Fragment1 extends Fragment {
    @Bind(R.id.btn_start_activity)
    Button btnStartActivity;
    @Bind(R.id.ll_fragment1)
    LinearLayout llFragment1;

    private final static String TAG = Fragment1.class.getName();

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "Fragment1 onActivityResult called! requestCode=" + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @OnClick({R.id.btn_start_activity, R.id.ll_fragment1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_activity:
                //startActivityForResult(new Intent(getActivity(), Activity1.class), 101);
                btnStartActivity.setEnabled(false);
                break;
            case R.id.ll_fragment1:

                break;
        }
    }
}
