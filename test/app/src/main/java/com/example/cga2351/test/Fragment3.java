package com.example.cga2351.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
public class Fragment3 extends Fragment {

    @Bind(R.id.btn_start_activity)
    Button btnStartActivity;
    @Bind(R.id.ll_fragment3)
    LinearLayout llFragment3;


    private final static String TAG = Fragment3.class.getName();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "Fragment3 onActivityResult called! requestCode=" + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fg_fragment4, new Fragment4(), "tag_fragment4");
        ft.addToBackStack("tag_fragment4");
        ft.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_start_activity, R.id.ll_fragment3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_activity:
                startActivityForResult(new Intent(getActivity(), Activity1.class), 103);
                break;
            case R.id.ll_fragment3:
                break;
        }
    }
}
