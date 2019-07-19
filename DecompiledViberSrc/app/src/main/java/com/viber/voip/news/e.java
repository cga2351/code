package com.viber.voip.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;

public class e extends i<MoreScreenNewsBrowserPresenter, g>
{
  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    AppCompatActivity localAppCompatActivity = (AppCompatActivity)getActivity();
    this.h = new MoreScreenNewsBrowserPresenter(new h(this.a.a(), 1, localAppCompatActivity.isTaskRoot()), this.b, this.c, this.d, this.e, this.f);
    this.i = new g(localAppCompatActivity, this, (MoreScreenNewsBrowserPresenter)this.h, paramView);
    addMvpView(this.i, this.h, paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.generic_web_view, paramViewGroup, false);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    AppCompatActivity localAppCompatActivity = (AppCompatActivity)getActivity();
    localAppCompatActivity.setSupportActionBar((Toolbar)paramView.findViewById(R.id.toolbar));
    localAppCompatActivity.getSupportActionBar().a(false);
    localAppCompatActivity.getSupportActionBar().b(true);
    dj.a(localAppCompatActivity, R.string.news_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.e
 * JD-Core Version:    0.6.2
 */