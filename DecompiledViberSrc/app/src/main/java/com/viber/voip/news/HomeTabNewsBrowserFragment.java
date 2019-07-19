package com.viber.voip.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;

public class HomeTabNewsBrowserFragment extends i<HomeTabNewsBrowserPresenter, d>
{
  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    this.h = new HomeTabNewsBrowserPresenter(new n(this.a.a(), 2), this.b, this.c, this.d, this.g, this.e, this.f);
    this.i = new d((AppCompatActivity)getActivity(), this, (HomeTabNewsBrowserPresenter)this.h, paramView);
    addMvpView(this.i, this.h, paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_generic_web_view, paramViewGroup, false);
  }

  public void onTabReselected()
  {
    super.onTabReselected();
    ((d)this.i).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.HomeTabNewsBrowserFragment
 * JD-Core Version:    0.6.2
 */