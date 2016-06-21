package com.example.cga2351.test;


import android.content.Intent;
import android.os.Bundle;
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
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

    private final static String TAG = Fragment4.class.getName();
    @Bind(R.id.btn_start_activity)
    Button btnStartActivity;
    @Bind(R.id.ll_fragment4)
    LinearLayout llFragment4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment4, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "Fragment4 onActivityResult called! requestCode=" + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_start_activity, R.id.ll_fragment4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_activity:
                startActivityForResult(new Intent(getActivity(), Activity1.class), 104);
                break;
            case R.id.ll_fragment4:
                break;
        }
    }
}
